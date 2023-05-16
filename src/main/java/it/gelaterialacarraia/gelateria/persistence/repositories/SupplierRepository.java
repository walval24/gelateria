package it.gelaterialacarraia.gelateria.persistence.repositories;

import it.gelaterialacarraia.gelateria.persistence.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
