package it.gelaterialacarraia.gelateria.presentation.controllers;
import it.gelaterialacarraia.gelateria.persistence.entities.Admins;
import it.gelaterialacarraia.gelateria.persistence.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admins")
public class AdminAuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        if (isValidCredentials(username, password)) {
            // Credenziali valide, restituisci un token di accesso o un messaggio di successo
            String token = "il_tuo_token"; // Sostituisci con la logica di generazione del token
            return ResponseEntity.ok(token);
        } else {
            // Credenziali non valide, restituisci un messaggio di errore o un codice di stato non autorizzato
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @Autowired
    private AdminRepository adminRepository;

    private boolean isValidCredentials(String username, String password) {
        // Utilizza il repository per cercare l'admin nel database
        Admins admins = adminRepository.findByUsernameAndPassword(username, password);
        return admins != null; // Restituisce true se l'admin è presente nel database, altrimenti false
    }
}