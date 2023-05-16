package it.gelaterialacarraia.gelateria.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GelateriaConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();

    }
}
  /*  Questo metodo restituisce un oggetto ModelMapper,
  ossia una libreria che aiuta a mappare oggetti da un tipo ad un altro.
  Nei nostri progetti, il più delle volte, abbiamo bisogno di personalizzare i nostri DTO.
   Naturalmente, ciò si tradurrà in diversi campi, gerarchie
   e le loro mappature irregolari tra loro. A volte, abbiamo anche bisogno
    di più di un DTO per una singola fonte e viceversa.
 */
