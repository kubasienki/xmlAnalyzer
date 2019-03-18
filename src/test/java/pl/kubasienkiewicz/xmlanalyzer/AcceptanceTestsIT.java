package pl.kubasienkiewicz.xmlanalyzer;


import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.XmlBody.xml;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by Jakub Sienkiewicz on 18.03.2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AcceptanceTestsIT {

    private static ClientAndServer mockServer;

    @Autowired
    private MockMvc mockMvc;

    @BeforeClass
    public static void startServer() {
        mockServer = startClientAndServer(1080);
    }


    @AfterClass
    public static void stopServer() {
        mockServer.stop();
    }

    @Test
    public void working() throws Exception {
        createWorkingFileExpectation();
        mockMvc.perform(post("/analyze")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"url\":\"http://localhost:1080/working.xml\"}"))
                .andExpect(status().isOk())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.analyseDate").isNotEmpty())
                .andExpect(jsonPath("$.details.firstPost").value("2016-01-12T18:45:19.963"))
                .andExpect(jsonPath("$.details.lastPost").value("2017-01-12T18:45:19.963"))
                .andExpect(jsonPath("$.details.totalPosts").value(2))
                .andExpect(jsonPath("$.details.totalAcceptedPosts").value(1))
                .andExpect(jsonPath("$.details.avgScore").value(5));
    }

    private void createWorkingFileExpectation() {
        new MockServerClient("localhost", 1080)
                .when(
                        request()
                                .withMethod("GET")
                                .withPath("/working.xml"),
                        Times.once()
                )
                .respond(
                        response()
                                .withStatusCode(200)
                                .withBody(
                                        xml("<posts>" +
                                                System.lineSeparator() +
                                                "<row Id=\"1\" PostTypeId=\"5\" AcceptedAnswerId=\"51\" CreationDate=\"2016-01-12T18:45:19.963\" Score=\"8\" ViewCount=\"41\" Body=\"\" OwnerUserId=\"222\" Title=\"How\"/>\r\n" +
                                                System.lineSeparator() +
                                                "<row Id=\"2\" PostTypeId=\"9\" CreationDate=\"2017-01-12T18:45:19.963\" Score=\"2\" ViewCount=\"41\" Body=\"\" OwnerUserId=\"265\" Title=\"How\"/>\r\n" +
                                                System.lineSeparator() +
                                                "</posts>")
                                )
                );
    }
}
