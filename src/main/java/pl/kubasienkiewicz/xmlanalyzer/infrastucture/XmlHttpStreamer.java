package pl.kubasienkiewicz.xmlanalyzer.infrastucture;

import org.springframework.stereotype.Component;
import pl.kubasienkiewicz.xmlanalyzer.domain.XmlStreamerPort;
import pl.kubasienkiewicz.xmlanalyzer.domain.exceptions.IoRuntimeException;
import pl.kubasienkiewicz.xmlanalyzer.domain.exceptions.MalformedURLRuntimeException;
import pl.kubasienkiewicz.xmlanalyzer.domain.exceptions.XmlStreamRuntimeException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */
@Component
class XmlHttpStreamer implements XmlStreamerPort {

    @Override
    public XMLStreamReader getXmlStreamReader(String requestUrl) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        URL url = null;
        try {
            url = new URL(requestUrl);
        } catch (MalformedURLException ex) {
            throw new MalformedURLRuntimeException(ex.getMessage());
        }
        XMLStreamReader streamReader = null;
        try {
            streamReader = inputFactory.createXMLStreamReader(url.openStream());
        } catch (IOException ex) {
            throw new IoRuntimeException(ex.getMessage());
        } catch (XMLStreamException ex) {
            throw new XmlStreamRuntimeException(ex.getMessage());
        }
        return streamReader;
    }
}
