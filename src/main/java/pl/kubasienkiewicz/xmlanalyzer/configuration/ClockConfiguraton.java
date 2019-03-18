package pl.kubasienkiewicz.xmlanalyzer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

/**
 * Created by Jakub Sienkiewicz on 18.03.2019.
 */
@Configuration
class ClockConfiguraton {

    @Bean
    Clock clock(){
        return Clock.systemUTC();
    }
}
