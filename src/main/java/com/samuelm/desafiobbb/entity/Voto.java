package com.samuelm.desafiobbb.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Candidato candidato;
    private LocalDateTime data_hora;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Candidato getCandidato() {
        return candidato;
    }
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    public LocalDateTime getData_hora() {
        return data_hora;
    }
    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }
}
