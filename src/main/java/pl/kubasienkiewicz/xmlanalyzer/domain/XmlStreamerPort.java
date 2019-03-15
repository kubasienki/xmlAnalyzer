package pl.kubasienkiewicz.xmlanalyzer.domain;

import javax.xml.stream.XMLStreamReader;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */
public interface XmlStreamerPort {

    XMLStreamReader getXmlStreamReader(String url);

}
