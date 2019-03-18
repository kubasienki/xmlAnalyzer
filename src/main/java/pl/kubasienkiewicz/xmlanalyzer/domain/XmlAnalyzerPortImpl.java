package pl.kubasienkiewicz.xmlanalyzer.domain;

import org.springframework.stereotype.Component;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */
@Component
public class XmlAnalyzerPortImpl implements XmlAnalyzerPort {

    private XmlAnalyzer xmlAnalyzer;

    XmlAnalyzerPortImpl(XmlAnalyzer xmlAnalyzer) {
        this.xmlAnalyzer = xmlAnalyzer;
    }

    @Override
    public XmlAnalyzeResult analyzeXml(String url){
       return xmlAnalyzer.analyzeXml(url);
    }
}
