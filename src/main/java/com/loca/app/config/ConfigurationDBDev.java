package com.loca.app.config;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.loca.app.services._DBService;

/**Classe para configuração do ambiente de Desenvolvimento
* Neste caso, estamos armazenando no banco de dados localhost
*/

@Configuration
@Profile("dev")
public class ConfigurationDBDev {

    @Autowired
    private _DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instatiateDatabase() throws ParseException, IOException {
        if (!"create".equals(strategy)) {
            return false;
        }
        dbService.instantiateTestDatabase();
        return true;
    }

}
