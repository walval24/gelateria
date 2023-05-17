package it.gelaterialacarraia.gelateria.services;

import it.gelaterialacarraia.gelateria.persistence.entities.Admins;
import it.gelaterialacarraia.gelateria.persistence.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admins> getAll() {
        return adminRepository.findAll();
    }

    public Admins getById (long id){
        Optional<Admins> optionalAdmins = adminRepository.findById(id);

        if(optionalAdmins.isEmpty()){
            throw new IllegalStateException("Product not found");
        }

        return optionalAdmins.get();
    }

}