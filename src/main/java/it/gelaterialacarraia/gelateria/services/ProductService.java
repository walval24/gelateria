package it.gelaterialacarraia.gelateria.services;
import it.gelaterialacarraia.gelateria.persistence.entities.Product;
import it.gelaterialacarraia.gelateria.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/*@Service - annotazione che indica che questa classe è un componente di servizio.
La classe viene registrata come un bean in un ApplicationContext e viene
utilizzata per gestire la logica di business.*/
public class ProductService {
    @Autowired
    /*@Autowired - annotazione che permette la dependency injection,
    ossia l'iniezione di una dipendenza. In questo caso viene iniettato
    il ProductRepository nell'attributo productRepository per utilizzarlo all'interno dei metodi.*/
    private ProductRepository productRepository;

    public List<Product> getAll(){return productRepository.findAll();} // restituisce una lista di tutti i prodotti presenti nel database.

    public Product getById (long id){ //  restituisce il prodotto con l'id specificato. Se non esiste, viene sollevata un'eccezione.
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new IllegalStateException("Product not found");
        }

        return optionalProduct.get();
    }

    public Product create(Product newProduct){ // crea un nuovo prodotto nel database con le informazioni del prodotto passato come parametro. Restituisce il prodotto appena creato.

        newProduct = productRepository.save(newProduct);
        return newProduct;
    }

    public Product update(long id,Product updateProduct){ // aggiorna il prodotto con l'id specificato con le informazioni del prodotto passato come parametro.
        // Se il prodotto non esiste, viene sollevata un'eccezione. Restituisce il prodotto aggiornato.

        Optional<Product> optionalProduct =productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new IllegalStateException("Product not found");
        }
        Product entityToUpdate = optionalProduct.get();

        updateProduct.setId(entityToUpdate.getId());

        updateProduct = productRepository.save(updateProduct);

        return updateProduct;
    }
    public Product delete(long id) { // elimina il prodotto con l'id specificato dal database. Se il prodotto non esiste, viene sollevata un'eccezione. Restituisce il prodotto eliminato.
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new IllegalStateException("Product not found");
        }
        Product entityToDelete = optionalProduct.get();

        productRepository.delete(entityToDelete);

        return entityToDelete;
    }

}




























