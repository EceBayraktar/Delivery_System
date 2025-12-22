package com.delivery.shipmentservice.repository;

import com.delivery.shipmentservice.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShipmentRepository extends JpaRepository<Shipment, UUID> {
}
