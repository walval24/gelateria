package it.gelaterialacarraia.gelateria.persistence.repositories;

import it.gelaterialacarraia.gelateria.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

/*Questo codice definisce un'interfaccia per accedere ai dati
 dei prodotti della gelateria utilizzando Spring Data JPA utilizzando
 la reflection (utilizzata per esaminare e manipolare oggetti, classi e metodi durante l'esecuzione del programma)
  per creare query SQL e interfacciarsi con il database.*/
