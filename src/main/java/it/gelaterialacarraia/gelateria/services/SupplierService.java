package it.gelaterialacarraia.gelateria.services;

import it.gelaterialacarraia.gelateria.persistence.entities.Product;
import it.gelaterialacarraia.gelateria.persistence.entities.Supplier;
import it.gelaterialacarraia.gelateria.persistence.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    public List<Supplier> getAll(){return supplierRepository.findAll();}
    public Supplier getById (long id){
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if(optionalSupplier.isEmpty()){
            throw new IllegalStateException("Supplier not found");
        }
        return optionalSupplier.get();
    }
    public Supplier create(Supplier newSupplier){
        newSupplier = supplierRepository.save(newSupplier);
        return newSupplier;
    }

    public Supplier update(long id, Supplier updateSupplier){
        Optional<Supplier> optionalSupplier =supplierRepository.findById(id);
        if(optionalSupplier.isEmpty()){
            throw new IllegalStateException("Supplier not found");
        }
        Supplier entityToUpdate = optionalSupplier.get();

        updateSupplier.setId(entityToUpdate.getId());

        updateSupplier = supplierRepository.save(updateSupplier);

        return updateSupplier;
    }
    public Supplier delete(long id) { // elimina il prodotto con l'id specificato dal database. Se il prodotto non esiste, viene sollevata un'eccezione. Restituisce il prodotto eliminato.
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);

        if(optionalSupplier.isEmpty()){
            throw new IllegalStateException("Supplier not found");
        }
        Supplier entityToDelete = optionalSupplier.get();

        supplierRepository.delete(entityToDelete);

        return entityToDelete;
    }

}
