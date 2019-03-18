package pl.kubasienkiewicz.xmlanalyzer.domain;


import java.time.LocalDateTime;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */
public class XmlAnalyzeResult {

    private XmlAnalyzeResult() {
    }

    private LocalDateTime analyseDate;
    private XmlAnalyzeResultDetails details;

    public LocalDateTime getAnalyseDate() {
        return analyseDate;
    }

    public XmlAnalyzeResultDetails getDetails() {
        return details;
    }

    public static final class Builder {
        private LocalDateTime analyseDate;
        private XmlAnalyzeResultDetails details;

        Builder() {
            this.analyseDate = LocalDateTime.now();
        }

        public Builder analyseDate(LocalDateTime analyseDate) {
            this.analyseDate = analyseDate;
            return this;
        }

        Builder details(XmlAnalyzeResultDetails details) {
            this.details = details;
            return this;
        }

        XmlAnalyzeResult build() {
            XmlAnalyzeResult xmlAnalyzeResult = new XmlAnalyzeResult();
            xmlAnalyzeResult.analyseDate = this.analyseDate;
            xmlAnalyzeResult.details = this.details;
            return xmlAnalyzeResult;
        }
    }
}
