package com.samuelm.desafiobbb.controller;

import com.samuelm.desafiobbb.dto.VotoRequest;
import com.samuelm.desafiobbb.service.VotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voto")
public class VotoController {
    private final VotoService service;

    public VotoController(VotoService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void processarVoto(@RequestBody VotoRequest request){
        service.processarVoto(request);
    }

}
