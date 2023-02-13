package com.example.healthcheckapi.config;

import com.timgroup.statsd.NoOpStatsDClient;
import com.timgroup.statsd.NonBlockingStatsDClient;
import com.timgroup.statsd.StatsDClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StatsDConfig {

    @Value("true")
    private boolean publishMessage;

    @Value("localhost")
    private String metricHost;

    @Value("8125")
    private int portNumber;

    @Value("csye6225_spring2022")
    private String prefix;

    @Bean
    public StatsDClient metricClient() {
        if (publishMessage)
            return new NonBlockingStatsDClient(prefix, metricHost, portNumber);
        return new NoOpStatsDClient();
    }

}
