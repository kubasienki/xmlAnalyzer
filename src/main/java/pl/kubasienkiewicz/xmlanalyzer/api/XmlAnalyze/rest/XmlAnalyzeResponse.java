package pl.kubasienkiewicz.xmlanalyzer.api.xmlanalyze.rest;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof XmlAnalyzeResponse)) return false;

        XmlAnalyzeResponse that = (XmlAnalyzeResponse) o;

        return (analyseDate != null ? analyseDate.equals(that.analyseDate) : that.analyseDate == null) && (details != null ? details.equals(that.details) : that.details == null);
    }

    @Override
    public int hashCode() {
        int result = analyseDate != null ? analyseDate.hashCode() : 0;
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
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
