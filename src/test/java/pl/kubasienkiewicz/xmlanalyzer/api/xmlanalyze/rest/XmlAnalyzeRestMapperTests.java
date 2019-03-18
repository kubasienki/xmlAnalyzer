package pl.kubasienkiewicz.xmlanalyzer.api.xmlanalyze.rest;

import org.junit.Test;
import pl.kubasienkiewicz.xmlanalyzer.domain.XmlAnalyzeResult;
import pl.kubasienkiewicz.xmlanalyzer.domain.XmlAnalyzeResultDetails;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jakub Sienkiewicz on 18.03.2019.
 */
public class XmlAnalyzeRestMapperTests {

    private XmlAnalyzerRestMapper restMapper = new XmlAnalyzerRestMapper();

    @Test
    public void testMappingForDetails(){
        XmlAnalyzeResultDetails resultDetails = new XmlAnalyzeResultDetails.Builder()
                .firstPost(LocalDateTime.MIN)
                .lastPost(LocalDateTime.MAX)
                .avgScore(0)
                .totalAcceptedPosts(0)
                .totalPosts(0)
                .build();
        XmlAnalyzeResponseDetails responseDetails = new XmlAnalyzeResponseDetails.Builder()
                .firstPost(LocalDateTime.MIN)
                .lastPost(LocalDateTime.MAX)
                .avgScore(0)
                .totalAcceptedPosts(0)
                .totalPosts(0)
                .build();
        assertEquals(restMapper.mapResultDetailsToResultResponse(resultDetails), responseDetails);
    }

    @Test
    public void testMappingForResponse(){
        XmlAnalyzeResultDetails resultDetails = new XmlAnalyzeResultDetails.Builder()
                .firstPost(LocalDateTime.MIN)
                .lastPost(LocalDateTime.MAX)
                .avgScore(0)
                .totalAcceptedPosts(0)
                .totalPosts(0)
                .build();
        XmlAnalyzeResult result = new XmlAnalyzeResult.Builder().details(resultDetails).analyseDate(LocalDateTime.MAX).build();

        XmlAnalyzeResponseDetails responseDetails = new XmlAnalyzeResponseDetails.Builder()
                .firstPost(LocalDateTime.MIN)
                .lastPost(LocalDateTime.MAX)
                .avgScore(0)
                .totalAcceptedPosts(0)
                .totalPosts(0)
                .build();

        XmlAnalyzeResponse response = new XmlAnalyzeResponse.Builder().details(responseDetails).analyseDate(LocalDateTime.MAX).build();
        assertEquals(restMapper.mapResultToResponse(result), response);
    }
}
