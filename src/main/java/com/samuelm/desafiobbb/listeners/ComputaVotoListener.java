package com.samuelm.desafiobbb.listeners;

import com.samuelm.desafiobbb.dto.VotoRequest;
import com.samuelm.desafiobbb.service.VotoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ComputaVotoListener {

    private final VotoService votoService;

    public ComputaVotoListener(VotoService service){
        this.votoService = service;
    }
    @RabbitListener(queues = "computar-voto.queue")
    public void processMessage(VotoRequest request){
        votoService.save(request);
    }
}
