package com.samuelm.desafiobbb.service;

import com.samuelm.desafiobbb.dto.VotoRequest;
import com.samuelm.desafiobbb.entity.Candidato;
import com.samuelm.desafiobbb.entity.Voto;
import com.samuelm.desafiobbb.repository.VotoRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VotoService {

    private final RabbitTemplate rabbitTemplate;
    private final VotoRepository repository;

    public VotoService(RabbitTemplate rabbitTemplate, VotoRepository repository){
        this.rabbitTemplate = rabbitTemplate;
        this.repository = repository;
    }
    public void processarVoto(VotoRequest request) {
        rabbitTemplate.convertAndSend("computar-voto.ex","computar-voto.key", request);
    }

    public void save(VotoRequest request) {

        Voto voto = new Voto();
        voto.setCandidato(new Candidato(request.getIdCandidato()));
        voto.setData_hora(LocalDateTime.now());
        repository.save(voto);
    }
}
