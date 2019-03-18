package pl.kubasienkiewicz.xmlanalyzer.api.XmlAnalyze.rest;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.validation.constraints.NotNull;

/**
 * Created by Jakub Sienkiewicz on 17.03.2019.
 */
@JsonDeserialize(builder = XmlAnalyzeRequest.Builder.class)
class XmlAnalyzeRequest {

    @NotNull
    private String url;

    private XmlAnalyzeRequest() {
    }

    String getUrl() {
        return url;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private String url;

        public Builder() {
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public XmlAnalyzeRequest build() {
            XmlAnalyzeRequest xmlAnalyzeRequest = new XmlAnalyzeRequest();

            xmlAnalyzeRequest.url = this.url;
            return xmlAnalyzeRequest;
        }
    }
}
