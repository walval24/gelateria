package it.gelaterialacarraia.gelateria.persistence.repositories;

import it.gelaterialacarraia.gelateria.persistence.entities.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admins, Long> {
    Admins findByUsernameAndPassword(String username, String password);
}

