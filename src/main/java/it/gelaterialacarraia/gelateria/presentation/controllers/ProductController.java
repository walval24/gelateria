package it.gelaterialacarraia.gelateria.presentation.controllers;

import it.gelaterialacarraia.gelateria.presentation.dtos.ProductDTO;
import it.gelaterialacarraia.gelateria.persistence.entities.Product;
import it.gelaterialacarraia.gelateria.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Questa annotazione indica che questa classe è un controller REST
@RequestMapping("/products") // //Questa annotazione mappa questa classe a /products
@CrossOrigin(origins = "http://localhost:3000") //Questa annotazione consente al client situato all'indirizzo http://localhost:3000 di accedere a questo controller
public class ProductController {
    @Autowired
    private ProductService productService; //Istanza del servizio ProductService
    @Autowired
    private ModelMapper modelMapper; //Istanza della classe ModelMapper


    @GetMapping //Questa annotazione mappa una richiesta HTTP GET a questo metodo
    public List<ProductDTO> getProducts() {
        return productService.getAll() //Recupera tutti i prodotti dal database utilizzando il servizio ProductService
                .stream()
                .map(this::convertToDTO) //Trasforma ogni prodotto in un ProductDTO utilizzando il metodo convertToDTO
                .toList(); //Ritorna la lista di tutti i prodotti come ProductDTO
    }

    @GetMapping ("/{id}") //Questa annotazione mappa una richiesta HTTP GET a /products/{id} a questo metodo
    public ProductDTO getById( @PathVariable long id) { //Il parametro id viene preso dall'URL
        return convertToDTO(productService.getById(id)); //Recupera il prodotto con l'id specificato utilizzando il servizio ProductService e lo trasforma in un ProductDTO utilizzando il metodo convertToDTO
    }

    @PostMapping //Questa annotazione mappa una richiesta HTTP POST a questo metodo
    public ProductDTO createProduct (@RequestBody ProductDTO newProduct) { //Il corpo della richiesta HTTP viene deserializzato in un oggetto ProductDTO
        Product product = convertToEntity(newProduct); //Trasforma il ProductDTO in un oggetto Product utilizzando il metodo convertToEntity
        product = productService.create(product); //Crea il nuovo prodotto nel database utilizzando il servizio ProductService
        return convertToDTO(product); //Trasforma il nuovo prodotto in un ProductDTO e lo ritorna come risposta HTTP
    }

    @PutMapping ("/{id}") //Questa annotazione mappa una richiesta HTTP PUT a /products/{id} a questo metodo
    public ProductDTO updateProduct( @PathVariable long id, @RequestBody ProductDTO updateProduct) { //Il parametro id viene preso dall'URL e il corpo della richiesta HTTP viene deserializzato in un oggetto ProductDTO
        Product product = convertToEntity(updateProduct); //Trasforma il ProductDTO in un oggetto Product utilizzando il metodo convertToEntity
        product = productService.update(id,product); //Aggiorna il prodotto con l'id specificato nel database utilizzando il servizio ProductService
        return convertToDTO(product); //Trasforma il prodotto aggiornato in un ProductDTO e lo ritorna come risposta HTTP
    }

    @DeleteMapping ("/{id}") // Gestisce richieste HTTP DELETE per la risorsa specificata nella path "/{id}"
    public ProductDTO deleteBook(@PathVariable long id ) {
        // Chiama il metodo delete del ProductService, passando l'ID del prodotto da eliminare
        // e restituisce l'oggetto Product eliminato
        return convertToDTO(productService.delete(id));
    }

    private ProductDTO convertToDTO (Product product){  // Converte un oggetto Product in un oggetto ProductDTO
        return modelMapper.map(product,ProductDTO.class);
    }

    private Product convertToEntity (ProductDTO dto){   // Converte un oggetto ProductDTO in un oggetto Product
        return modelMapper.map(dto, Product.class);
    }


}































