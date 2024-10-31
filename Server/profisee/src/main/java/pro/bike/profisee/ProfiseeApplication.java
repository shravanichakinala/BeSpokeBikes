package pro.bike.profisee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pro.bike.profisee.service.ProductService;


@SpringBootApplication(scanBasePackages = {"pro.bike.profisee"})
public class ProfiseeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfiseeApplication.class, args);
	}
	
	
	
    @Bean
    CommandLineRunner run(ProductService productService) {
        return args -> {
            productService.getAllProducts().forEach(product -> {
                System.out.println("Product: " + product.getName() + ", Price: " + product.getSalePrice());
            });
        };
    }

}
