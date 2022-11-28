package com.api.futsirio.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_car")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carro;

    @ManyToOne
    @JoinColumn(name = "tb_players")
    private Players players;


    public Cars() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }
}
