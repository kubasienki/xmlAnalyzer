package pl.kubasienkiewicz.xmlanalyzer.infrastructure;

import org.junit.Test;
import pl.kubasienkiewicz.xmlanalyzer.domain.exceptions.MalformedURLRuntimeException;

/**
 * Created by Jakub Sienkiewicz on 18.03.2019.
 */
public class XmlHttpStreamerTests {

    private XmlHttpInputStream xmlHttpStreamer = new XmlHttpInputStream();

    @Test(expected = MalformedURLRuntimeException.class)
    public void testUrlWithoutProtocol(){
        xmlHttpStreamer.getXmlInputStream("s3-eu-west-1.amazonaws.com/merapar-assessment/3dprinting-posts.xml");
    }

    @Test(expected = MalformedURLRuntimeException.class)
    public void testUrlWithWrongProtocol(){
        xmlHttpStreamer.getXmlInputStream("hts://s3-eu-west-1.amazonaws.com/merapar-assessment/3dprinting-posts.xml");
    }

}
