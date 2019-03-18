package pl.kubasienkiewicz.xmlanalyzer.api.XmlAnalyze.rest;

import java.time.LocalDateTime;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */
class XmlAnalyzeResponse {

    private XmlAnalyzeResponse(){

    }

    private LocalDateTime analyseDate;
    private XmlAnalyzeResponseDetails details;

    public LocalDateTime getAnalyseDate() {
        return analyseDate;
    }

    public XmlAnalyzeResponseDetails getDetails() {
        return details;
    }

    static final class Builder {
        private LocalDateTime analyseDate;
        private XmlAnalyzeResponseDetails details;

        Builder() {
        }

        Builder analyseDate(LocalDateTime analyseDate) {
            this.analyseDate = analyseDate;
            return this;
        }

        Builder details(XmlAnalyzeResponseDetails details) {
            this.details = details;
            return this;
        }

        XmlAnalyzeResponse build() {
            XmlAnalyzeResponse xmlAnalyzeResponse = new XmlAnalyzeResponse();
            xmlAnalyzeResponse.analyseDate = this.analyseDate;
            xmlAnalyzeResponse.details = this.details;
            return xmlAnalyzeResponse;
        }
    }
}
