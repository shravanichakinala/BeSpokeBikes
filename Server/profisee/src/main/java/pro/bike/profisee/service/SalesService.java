package pro.bike.profisee.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import pro.bike.profisee.entity.Customer;
import pro.bike.profisee.entity.Product;
import pro.bike.profisee.entity.QuarterlyCommissionProjection;

import pro.bike.profisee.entity.Sales;
import pro.bike.profisee.entity.Salesperson;
import pro.bike.profisee.exception.DuplicateEntryException;
import pro.bike.profisee.repository.CustomerRepository;
import pro.bike.profisee.repository.ProductRepository;
import pro.bike.profisee.repository.SalesRepository;
import pro.bike.profisee.repository.SalespersonRepository;

@Service
public class SalesService {
	
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private ProductRepository productRepository;
   // private  SalespersonRepository salespersonRepository;
    private final SalespersonRepository salespersonRepository;
    @Autowired
    private  CustomerRepository customerRepository;

    
    public SalesService(SalespersonRepository salespersonRepository) {
        this.salespersonRepository = salespersonRepository;
    }

    public List<Sales> getSalesByDateRange(LocalDate startDate, LocalDate endDate) {
    	
    	
    	  List<Sales> salesList = salesRepository.findBySalesDateBetween(startDate, endDate);
    	
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx:::"+salesList);
    
    	
  	
    	 
        return salesList;
    }
    
    public Sales createSale(Sales sale) {
        return salesRepository.save(sale);
    }
    

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }
    
    
    public List<Salesperson> getAllSalespersons() {
    	
    	System.out.println("yyyyyyyyyy:::");
        return salespersonRepository.findAll();
    }
    
    

@Transactional
public Salesperson updateSalesperson(Long id, Salesperson updatedSalesperson) {
    return salespersonRepository.findById(id)
            .map(existingSalesperson -> {
                // Check for duplicates (exclude the current salesperson ID)
                if (salespersonRepository.existsByFirstNameAndLastNameAndIdNot(
                        updatedSalesperson.getFirstName(),
                        updatedSalesperson.getLastName(),
                        id)) {
                    throw new DuplicateEntryException("A salesperson with the same first name and last name already exists.");
                }

                // Update fields
                existingSalesperson.setFirstName(updatedSalesperson.getFirstName());
                existingSalesperson.setLastName(updatedSalesperson.getLastName());
                existingSalesperson.setPhone(updatedSalesperson.getPhone());
                existingSalesperson.setAddress(updatedSalesperson.getAddress());
                existingSalesperson.setManager(updatedSalesperson.getManager());

                // Save updated entity
                return salespersonRepository.save(existingSalesperson);
            })
            .orElseThrow(() -> new RuntimeException("Salesperson not found with id: " + id));
}


    
    public Salesperson getSalespersonById(Long id) {
        return salespersonRepository.findById(id).orElse(null);
    }
    
    
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    

    
    public Product updateProduct(Long id, Product updatedProduct) {
        java.util.Optional<Product> existingProductOpt = productRepository.findById(id);
        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();

            // Check for duplicates (exclude the current product ID)
            if (productRepository.existsByNameAndManufacturerAndIdNot(updatedProduct.getName(), updatedProduct.getManufacturer(), id)) {
                throw new DuplicateEntryException("A product with the same name and manufacturer already exists.");
            }

            // Update fields
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setManufacturer(updatedProduct.getManufacturer());
            existingProduct.setStyle(updatedProduct.getStyle());
            existingProduct.setPurchasePrice(updatedProduct.getPurchasePrice());
            existingProduct.setSalePrice(updatedProduct.getSalePrice());
            existingProduct.setQtyOnHand(updatedProduct.getQtyOnHand());
            existingProduct.setCommissionPercentage(updatedProduct.getCommissionPercentage());

            return productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

	
    public List<QuarterlyCommissionProjection> getQuarterlyCommissionReport(LocalDate startDate, LocalDate endDate) {
        return salesRepository.findQuarterlyCommissions(startDate, endDate);
    }

    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    
 

}
