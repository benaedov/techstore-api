package cl.techstore.api.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class AuditoriaService {

    private final SqsClient sqsClient;

    @Value("${aws.sqs.queue-url}")
    private String queueUrl;

    public AuditoriaService(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    public void enviarEvento(String accion, Long productoId, String nombre, String usuario) {
        String mensaje = String.format(
                "{\"accion\":\"%s\",\"productoId\":%d,\"nombre\":\"%s\",\"usuario\":\"%s\",\"fecha\":\"%s\"}",
                accion, productoId, nombre, usuario, Instant.now().toString()
        );

        SendMessageRequest request = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(mensaje)
                .build();

        sqsClient.sendMessage(request);
    }

}
