package pl.kubasienkiewicz.xmlanalyzer.infrastructure;

import org.springframework.stereotype.Component;
import pl.kubasienkiewicz.xmlanalyzer.domain.XmlInputStreamPort;
import pl.kubasienkiewicz.xmlanalyzer.domain.exceptions.IoRuntimeException;
import pl.kubasienkiewicz.xmlanalyzer.domain.exceptions.MalformedURLRuntimeException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */
@Component
class XmlHttpInputStream implements XmlInputStreamPort {

    @Override
    public InputStream getXmlInputStream(String requestUrl) {
        URL url = null;
        try {
            url = new URL(requestUrl);
        } catch (MalformedURLException ex) {
            throw new MalformedURLRuntimeException(ex.getMessage());
        }
        try {
            return url.openStream();
        } catch (IOException ex) {
            throw new IoRuntimeException(ex.getMessage());
        }

    }
}
