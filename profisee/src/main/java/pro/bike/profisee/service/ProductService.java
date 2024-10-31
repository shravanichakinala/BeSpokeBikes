package pro.bike.profisee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pro.bike.profisee.entity.Product;
import pro.bike.profisee.repository.ProductRepository;

@Service
public class ProductService {
	
	   @Autowired
	    private ProductRepository productRepository;

	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

}
