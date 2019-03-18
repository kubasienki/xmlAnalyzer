package pl.kubasienkiewicz.xmlanalyzer.domain;

import java.io.InputStream;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */
public interface XmlInputStreamPort {

    InputStream getXmlInputStream(String url);

}
