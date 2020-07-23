package com.ironhack.erp.salesservice.config;

import com.ironhack.erp.salesservice.model.entities.Sale;
import com.ironhack.erp.salesservice.repository.SalesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.math.BigDecimal;
import java.util.List;

@EnableMongoRepositories(basePackageClasses = SalesRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(SalesRepository saleRepository) {
        return strings -> {
            List<Sale> test = saleRepository.findAll();

            if (test.size() < 1) {
                saleRepository.save(new Sale((long) 1, "Harry Potter", "card", new BigDecimal(10), new BigDecimal(100)));
            }
        };
    }

}
