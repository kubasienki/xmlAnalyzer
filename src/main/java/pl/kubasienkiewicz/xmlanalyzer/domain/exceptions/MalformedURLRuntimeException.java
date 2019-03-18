package pl.kubasienkiewicz.xmlanalyzer.domain.exceptions;

/**
 * Created by Jakub Sienkiewicz on 18.03.2019.
 */
public class MalformedURLRuntimeException extends RuntimeException {
    public MalformedURLRuntimeException(String message){
        super(message);
    }
}
