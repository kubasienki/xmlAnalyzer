package pl.kubasienkiewicz.xmlanalyzer.domain;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */
public interface XmlAnalyzerPort {

    XmlAnalyzeResult analyzeXml(String url);

}
