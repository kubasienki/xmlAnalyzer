package pl.kubasienkiewicz.xmlanalyzer.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Jakub Sienkiewicz on 18.03.2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class XmlAnalyzerTests {

    private static final String URL_PLACEHOLDER = "https://s3-eu-west-1.amazonaws.com/merapar-assessment/arabic-posts.xml";

    @Mock
    XmlInputStreamPort inputStreamPortMock;

    @Mock
    Clock clock;

    @InjectMocks
    XmlAnalyzer xmlAnalyzer;

    @Before
    public void mockClock(){
        Clock clock = Clock.fixed(Instant.parse("2014-12-22T10:15:30.00Z"), ZoneId.of("UTC"));
        when(this.clock.instant()).thenReturn(clock.instant());
        when(this.clock.getZone()).thenReturn(clock.getZone());
    }

    @Test
    public void testAnalyzerStatsCounting() {
        when(inputStreamPortMock.getXmlInputStream(URL_PLACEHOLDER))
                .thenReturn(ClassLoader.class.getResourceAsStream("/tests/3dprinting-posts.xml"));
        XmlAnalyzeResultDetails resultDetails = new XmlAnalyzeResultDetails.Builder()
                .firstPost(LocalDateTime.parse("2016-01-12T18:45:19.963"))
                .lastPost(LocalDateTime.parse("2016-03-04T13:30:22.410"))
                .avgScore(3.2732824427480915d)
                .totalAcceptedPosts(102)
                .totalPosts(655)
                .build();
        XmlAnalyzeResult result = new XmlAnalyzeResult.Builder().analyseDate(LocalDateTime.now(clock)).details(resultDetails).build();
        XmlAnalyzeResult result_ = xmlAnalyzer.analyzeXml(URL_PLACEHOLDER);

        assertEquals(result, result_);
    }

}
