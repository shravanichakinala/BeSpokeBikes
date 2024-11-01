package pro.bike.profisee.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pro.bike.profisee.entity.Customer;
import pro.bike.profisee.entity.Product;
import pro.bike.profisee.entity.QuarterlyCommissionProjection;

import pro.bike.profisee.entity.Sales;
import pro.bike.profisee.entity.Salesperson;
import pro.bike.profisee.service.SalesService;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin(origins = "http://localhost:4200") 
public class SalesController {
	
	  @Autowired
	     private SalesService salesService;

	
	   @GetMapping("/all")
	    public List<Sales> getAllSales() {
	        return salesService.getAllSales();
	    }

	    @GetMapping("/by-date")
	    public List<Sales> getSalesByDateRange(
	            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String startDateStr,
	            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String endDateStr) {
	        
	    
	        LocalDate startDate = LocalDate.parse(startDateStr.trim());
	        LocalDate endDate = LocalDate.parse(endDateStr.trim());
	        
	        return salesService.getSalesByDateRange(startDate, endDate);
	    }	    
	    
	    @PostMapping("/createSale")
	    public ResponseEntity<Sales> createSale(@RequestBody Sales sale) {
	        System.out.println(" inside create sale:::::");
	        Sales newSale = salesService.createSale(sale);
	        return ResponseEntity.ok(newSale);
	    }
	    
	    
	    @GetMapping("/salespersons")
	    public List<Salesperson> getAllSalespersons() {
	    	System.out.println("heloo we inside all Salespersons(");
	        return salesService.getAllSalespersons();
	    }
	    
	    @PutMapping("/salespersons/{id}")
	    public ResponseEntity<Salesperson> updateSalesperson(@PathVariable Long id, @RequestBody Salesperson updatedSalesperson) {
	        Salesperson updated = salesService.updateSalesperson(id, updatedSalesperson);
	        
	        if (updated == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
	        }
	        
	        return ResponseEntity.ok(updated);  
	    }
	
	    
	    @GetMapping("/salespersons/{id}")
	    public ResponseEntity<Salesperson> getSalespersonById(@PathVariable Long id) {
	        Salesperson salesperson =  salesService.getSalespersonById(id);
	        System.out.println(" Salespersons salesperson:::::"+salesperson);
	        if (salesperson == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(salesperson);
	    }    
	    
	    @GetMapping("/products")
	    public List<Product> getAllProducts() {
	    	 System.out.println("getAllProducts:::::");
	        return salesService.getAllProducts();
	    }

	    @PutMapping("/products/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
	        Product updated = salesService.updateProduct(id, updatedProduct);
	        return ResponseEntity.ok(updated);
	    }
	    	    
	    @GetMapping("/commission-report")
	    public List<QuarterlyCommissionProjection> getQuarterlyCommissionReport(
	            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
	            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
	        return salesService.getQuarterlyCommissionReport(startDate, endDate);
	    }
	    
	    
	    @GetMapping("/customers")
	    public List<Customer> getAllCustomers() {
	        return salesService.getAllCustomers();
	    }
}


