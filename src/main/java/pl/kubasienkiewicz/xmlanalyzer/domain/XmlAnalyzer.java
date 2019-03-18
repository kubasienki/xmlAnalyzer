package pl.kubasienkiewicz.xmlanalyzer.domain;

import org.springframework.stereotype.Component;
import pl.kubasienkiewicz.xmlanalyzer.domain.exceptions.XmlStreamRuntimeException;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.time.LocalDateTime;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */

@Component
class XmlAnalyzer {

    private XmlStreamerPort xmlStreamer;

    XmlAnalyzer(XmlStreamerPort xmlStreamer) {
        this.xmlStreamer = xmlStreamer;
    }

    XmlAnalyzeResult analyzeXml(String url) {
        XmlAnalyzeResult.Builder builder = new XmlAnalyzeResult.Builder();
        XmlAnalyzeResultDetails.Builder detailsBuilder = new XmlAnalyzeResultDetails.Builder();
        int totalPosts = 0;
        int acceptedPosts = 0;
        boolean firstRow = true;
        double scoreSum = 0;
        LocalDateTime lastPost = null;
        XMLStreamReader streamReader = xmlStreamer.getXmlStreamReader(url);
        try {
            while (streamReader.hasNext()) {
                int eventType = streamReader.next();
                switch (eventType) {
                    case XMLStreamReader.START_ELEMENT:
                        String elementName = streamReader.getLocalName();
                        if (elementName.equals("row")) {
                            //ToDo We should extract a method from here - just need to think how
                            String creationDate = streamReader.getAttributeValue(null, "CreationDate");
                            String id = streamReader.getAttributeValue(null, "Id");
                            String score = streamReader.getAttributeValue(null, "Score");
                            if (id == null || creationDate == null || score == null) {
                                break;
                            }
                            lastPost = LocalDateTime.parse(creationDate);
                            if (firstRow) {
                                detailsBuilder = detailsBuilder.firstPost(lastPost);
                                firstRow = false;
                            }
                            if (streamReader.getAttributeValue(null, "AcceptedAnswerId") != null) {
                                acceptedPosts++;
                            }
                            totalPosts++;
                            scoreSum += Double.parseDouble(score);

                        }
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        break;
                }
            }
        } catch (XMLStreamException ex) {
            throw new XmlStreamRuntimeException(ex.getMessage());
        } finally {
            try {
                //TODo zamknąć resource
                streamReader.close();
            } catch (XMLStreamException ex) {
                throw new XmlStreamRuntimeException(ex.getMessage());
            }
        }
        builder.details(detailsBuilder
                .lastPost(lastPost)
                .totalAcceptedPosts(acceptedPosts)
                .totalPosts(totalPosts)
                .avgScore(scoreSum / totalPosts)
                .build());
        return builder.build();
    }

}
