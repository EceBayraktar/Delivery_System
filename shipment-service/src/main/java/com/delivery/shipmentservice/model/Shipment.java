package com.delivery.shipmentservice.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String receiver;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShipmentStatus status;

    public Shipment() {}

    public Shipment(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.status = ShipmentStatus.CREATED;
    }

    // GETTERS & SETTERS

    public UUID getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }
}
