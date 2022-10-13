package com.usa.misiontic.ciclo3.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="message")
public class Message implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;


    @ManyToOne
    @JoinColumn(name = "machineId")
    @JsonIgnoreProperties("messages")
    private Machine machine;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties("messages")
    private Client client;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "message")
    @JsonIgnoreProperties("message")
    private List<Reservation> reservations;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
