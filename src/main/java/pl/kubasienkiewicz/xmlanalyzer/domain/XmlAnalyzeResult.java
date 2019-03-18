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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof XmlAnalyzeResult)) return false;

        XmlAnalyzeResult that = (XmlAnalyzeResult) o;

        return (analyseDate != null ? analyseDate.equals(that.analyseDate) : that.analyseDate == null) && (details != null ? details.equals(that.details) : that.details == null);
    }

    @Override
    public int hashCode() {
        int result = analyseDate != null ? analyseDate.hashCode() : 0;
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }

    public static final class Builder {
        private LocalDateTime analyseDate;
        private XmlAnalyzeResultDetails details;

        public Builder() {
            this.analyseDate = LocalDateTime.now();
        }

        public Builder analyseDate(LocalDateTime analyseDate) {
            this.analyseDate = analyseDate;
            return this;
        }

        public Builder details(XmlAnalyzeResultDetails details) {
            this.details = details;
            return this;
        }

        public XmlAnalyzeResult build() {
            XmlAnalyzeResult xmlAnalyzeResult = new XmlAnalyzeResult();
            xmlAnalyzeResult.analyseDate = this.analyseDate;
            xmlAnalyzeResult.details = this.details;
            return xmlAnalyzeResult;
        }
    }
}
