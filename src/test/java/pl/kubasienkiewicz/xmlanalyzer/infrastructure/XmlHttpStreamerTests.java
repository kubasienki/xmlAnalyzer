package pl.kubasienkiewicz.xmlanalyzer.infrastructure;

import org.junit.Test;
import pl.kubasienkiewicz.xmlanalyzer.domain.exceptions.MalformedURLRuntimeException;

/**
 * Created by Jakub Sienkiewicz on 18.03.2019.
 */
public class XmlHttpStreamerTests {

    private XmlHttpStreamer xmlHttpStreamer = new XmlHttpStreamer();

    @Test(expected = MalformedURLRuntimeException.class)
    public void testUrlWithoutProtocol(){
        xmlHttpStreamer.getXmlStreamReader("s3-eu-west-1.amazonaws.com/merapar-assessment/3dprinting-posts.xml");
    }

    @Test(expected = MalformedURLRuntimeException.class)
    public void testUrlWithWrongProtocol(){
        xmlHttpStreamer.getXmlStreamReader("hts://s3-eu-west-1.amazonaws.com/merapar-assessment/3dprinting-posts.xml");
    }
}
