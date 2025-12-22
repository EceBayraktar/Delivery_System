package com.delivery.shipmentservice.event;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.delivery.shipmentservice.model.Shipment;

@Service
public class ShipmentEventPublisher {

    private final KafkaTemplate<String, ShipmentStatusChangedEvent> kafkaTemplate;

    public ShipmentEventPublisher(
        KafkaTemplate<String, ShipmentStatusChangedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishStatusChanged(Shipment shipment) {
        ShipmentStatusChangedEvent event =
                new ShipmentStatusChangedEvent(
                        shipment.getId().toString(),      // UUID'yi String'e çevir
                        shipment.getSender(),
                        shipment.getReceiver(),
                        shipment.getStatus().name()       // Enum'u String'e çevir
                );

        kafkaTemplate.send("shipment.status.changed", shipment.getId().toString(), event);
    }
}