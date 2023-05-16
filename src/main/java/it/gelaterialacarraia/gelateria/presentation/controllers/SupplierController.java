package it.gelaterialacarraia.gelateria.presentation.controllers;

import it.gelaterialacarraia.gelateria.persistence.entities.Product;
import it.gelaterialacarraia.gelateria.persistence.entities.Supplier;
import it.gelaterialacarraia.gelateria.presentation.dtos.ProductDTO;
import it.gelaterialacarraia.gelateria.presentation.dtos.SupplierDTO;
import it.gelaterialacarraia.gelateria.services.ProductService;
import it.gelaterialacarraia.gelateria.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@CrossOrigin(origins = "http://localhost:3000")
public class SupplierController {

    @Autowired
    private ProductService productService;
     @Autowired
    private ModelMapper modelMapper;
     @Autowired
    private SupplierService supplierService;

     @GetMapping
    public List<SupplierDTO> getSuppliers(){
         return supplierService.getAll()
                 .stream()
                 .map(this::convertToDTO)
                 .toList();
     }

    @GetMapping("/{id}")
    public SupplierDTO getSupplierById(@PathVariable long id) {
        return convertToDTO(supplierService.getById(id));
    }
    @PostMapping
    public SupplierDTO createSupplier(@RequestBody SupplierDTO newSupplier) {
        Supplier supplier = convertToEntity(newSupplier);

        supplier =supplierService.create(supplier);

        return convertToDTO(supplier);
    }
    @PutMapping("/{id}")
    public SupplierDTO updateSupplier(@PathVariable long id, @RequestBody SupplierDTO updateSupplier) {
        Supplier supplier = convertToEntity(updateSupplier);
        supplier = supplierService.update(id,supplier);


        return convertToDTO(supplier);
    }
    @DeleteMapping ("/{id}")
    public SupplierDTO deleteSupplier(@PathVariable long id){
        Supplier supplier = supplierService.getById(id);

        supplier.getProducts()
                .forEach(product -> productService.delete(product.getId()));

        return convertToDTO(supplierService.delete(id));
    }

    @DeleteMapping ("/{id}/products")
    public List<ProductDTO> deleteProducts(@PathVariable long id) {
        Supplier supplier = supplierService.getById(id);

        return supplier.getProducts()
                .stream()
                .map(product -> convertToProductDTO(productService.delete(product.getId())))
                .toList();
    }


    @GetMapping("/{id}/products")
    public List<ProductDTO> getProducts(@PathVariable long id){
        Supplier supplier = supplierService.getById(id);

        return supplier.getProducts()
                .stream()
                .map(this::convertToProductDTO)
                .toList();
    }


    private SupplierDTO convertToDTO(Supplier supplier) {
        return modelMapper.map(supplier, SupplierDTO.class);
    }

    private Supplier convertToEntity(SupplierDTO dto) {
        return modelMapper.map(dto, Supplier.class);

    }

    private ProductDTO convertToProductDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

}




























