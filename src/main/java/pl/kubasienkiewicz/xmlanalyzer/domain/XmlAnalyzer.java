package pl.kubasienkiewicz.xmlanalyzer.domain;

import org.springframework.stereotype.Component;
import pl.kubasienkiewicz.xmlanalyzer.domain.exceptions.IoRuntimeException;
import pl.kubasienkiewicz.xmlanalyzer.domain.exceptions.XmlStreamRuntimeException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.Clock;
import java.time.LocalDateTime;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */

@Component
class XmlAnalyzer {

    private XmlInputStreamPort xmlInputStreamPort;
    private Clock clock;

    XmlAnalyzer(XmlInputStreamPort xmlInputStreamPort, Clock clock) {
        this.xmlInputStreamPort = xmlInputStreamPort;
        this.clock = clock;
    }

    XmlAnalyzeResult analyzeXml(String url) {

        XmlAnalyzeResult.Builder builder = new XmlAnalyzeResult.Builder();
        XmlAnalyzeResultDetails.Builder detailsBuilder = new XmlAnalyzeResultDetails.Builder();
        int totalPosts = 0;
        int acceptedPosts = 0;
        boolean firstRow = true;
        double scoreSum = 0;
        LocalDateTime lastPost = null;
        InputStream inputStream = xmlInputStreamPort.getXmlInputStream(url);
        XMLStreamReader streamReader = initXMLStreamReader(inputStream);
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
            closeXmlStreamReaderAndResource(streamReader, inputStream);
        }
        builder.details(detailsBuilder
                .lastPost(lastPost)
                .totalAcceptedPosts(acceptedPosts)
                .totalPosts(totalPosts)
                .avgScore(scoreSum / totalPosts)
                .build())
                .analyseDate(LocalDateTime.now(clock));
        return builder.build();
    }

    private XMLStreamReader initXMLStreamReader(InputStream inputStream) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            return inputFactory.createXMLStreamReader(inputStream);
        } catch (XMLStreamException ex) {
            throw new XmlStreamRuntimeException(ex.getMessage());
        }
    }

    private void closeXmlStreamReaderAndResource(XMLStreamReader reader, InputStream resource) {
        try {
            reader.close();
        } catch (XMLStreamException ex) {
            throw new XmlStreamRuntimeException(ex.getMessage());
        } finally {
            try {
                resource.close();
            } catch (IOException ex) {
                throw new IoRuntimeException(ex.getMessage());
            }
        }
    }

}
