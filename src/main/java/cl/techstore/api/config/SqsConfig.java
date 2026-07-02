package cl.techstore.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class SqsConfig {

    @Bean // crea un objeto reutilizable en toda la app
    public SqsClient sqsClient(){
        return SqsClient.builder()
            .region(Region.US_EAST_1)
            .build();
    }

}
