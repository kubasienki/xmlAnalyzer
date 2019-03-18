package pl.kubasienkiewicz.xmlanalyzer.api.XmlAnalyze.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kubasienkiewicz.xmlanalyzer.domain.XmlAnalyzerPort;

import javax.validation.Valid;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */
@RestController
class XmlAnalyzerRestAdapter {

    private XmlAnalyzerPort analyzerPort;
    private XmlAnalyzerRestMapper mapper;

    XmlAnalyzerRestAdapter(XmlAnalyzerPort analyzerPort, XmlAnalyzerRestMapper mapper) {
        this.analyzerPort = analyzerPort;
        this.mapper = mapper;
    }

    @PostMapping("/analyze")
    private XmlAnalyzeResponse analyzeXml(@Valid @RequestBody XmlAnalyzeRequest request){
        return mapper.mapResultToResponse(analyzerPort.analyzeXml(request.getUrl()));
    }
}
