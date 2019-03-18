package pl.kubasienkiewicz.xmlanalyzer.api.xmlanalyze.rest;

import org.springframework.stereotype.Component;
import pl.kubasienkiewicz.xmlanalyzer.domain.XmlAnalyzeResult;
import pl.kubasienkiewicz.xmlanalyzer.domain.XmlAnalyzeResultDetails;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */
@Component
class XmlAnalyzerRestMapper {

    XmlAnalyzeResponse mapResultToResponse(XmlAnalyzeResult result){

        return new XmlAnalyzeResponse.Builder()
                .details(mapResultDetailsToResultResponse(result.getDetails()))
                .analyseDate(result.getAnalyseDate())
                .build();
    }

    XmlAnalyzeResponseDetails mapResultDetailsToResultResponse(XmlAnalyzeResultDetails details){
        return new XmlAnalyzeResponseDetails.Builder()
                .firstPost(details.getFirstPost())
                .lastPost(details.getLastPost())
                .avgScore(details.getAvgScore())
                .totalAcceptedPosts(details.getTotalAcceptedPosts())
                .totalPosts(details.getTotalPosts())
                .build();
    }
}
