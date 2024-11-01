package pro.bike.profisee.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import pro.bike.profisee.entity.Customer;
import pro.bike.profisee.entity.Product;
import pro.bike.profisee.entity.Sales;
import pro.bike.profisee.entity.Salesperson;
import pro.bike.profisee.repository.CustomerRepository;
import pro.bike.profisee.repository.ProductRepository;
import pro.bike.profisee.repository.SalesRepository;
import pro.bike.profisee.repository.SalespersonRepository;

@Component
public class DataInitializer {
	

	@Bean
	CommandLineRunner loadData(ProductRepository productRepository, SalespersonRepository salespersonRepository ,CustomerRepository customerRepository, SalesRepository salesRepository) {
	    return args -> {
	        // Seed Products
	        Product product1 = new Product();
	        product1.setName("Mountain Bike");
	        product1.setManufacturer("TrailMaster");
	        product1.setStyle("Mountain");
	        product1.setPurchasePrice(new BigDecimal("500.00"));
	        product1.setSalePrice(new BigDecimal("750.00"));
	        product1.setQtyOnHand(10);
	        product1.setCommissionPercentage(new BigDecimal("0.10"));
	        productRepository.save(product1);

	        Product product2 = new Product();
	        product2.setName("Road Bike");
	        product2.setManufacturer("Speedster");
	        product2.setStyle("Road");
	        product2.setPurchasePrice(new BigDecimal("600.00"));
	        product2.setSalePrice(new BigDecimal("900.00"));
	        product2.setQtyOnHand(15);
	        product2.setCommissionPercentage(new BigDecimal("0.12"));
	        productRepository.save(product2);

	        Product product3 = new Product();
	        product3.setName("Hybrid Bike");
	        product3.setManufacturer("EcoCycle");
	        product3.setStyle("Hybrid");
	        product3.setPurchasePrice(new BigDecimal("450.00"));
	        product3.setSalePrice(new BigDecimal("700.00"));
	        product3.setQtyOnHand(20);
	        product3.setCommissionPercentage(new BigDecimal("0.08"));
	        productRepository.save(product3);

	        Product product4 = new Product();
	        product4.setName("Electric Bike");
	        product4.setManufacturer("VoltRide");
	        product4.setStyle("Electric");
	        product4.setPurchasePrice(new BigDecimal("1200.00"));
	        product4.setSalePrice(new BigDecimal("1600.00"));
	        product4.setQtyOnHand(5);
	        product4.setCommissionPercentage(new BigDecimal("0.15"));
	        productRepository.save(product4);

	        Product product5 = new Product();
	        product5.setName("Kids Bike");
	        product5.setManufacturer("FunRides");
	        product5.setStyle("Kids");
	        product5.setPurchasePrice(new BigDecimal("200.00"));
	        product5.setSalePrice(new BigDecimal("350.00"));
	        product5.setQtyOnHand(30);
	        product5.setCommissionPercentage(new BigDecimal("0.05"));
	        productRepository.save(product5);

	        Product product6 = new Product();
	        product6.setName("Cruiser Bike");
	        product6.setManufacturer("EasyRide");
	        product6.setStyle("Cruiser");
	        product6.setPurchasePrice(new BigDecimal("700.00"));
	        product6.setSalePrice(new BigDecimal("1000.00"));
	        product6.setQtyOnHand(8);
	        product6.setCommissionPercentage(new BigDecimal("0.10"));
	        productRepository.save(product6);

	        Product product7 = new Product();
	        product7.setName("Folding Bike");
	        product7.setManufacturer("CompactCycle");
	        product7.setStyle("Folding");
	        product7.setPurchasePrice(new BigDecimal("800.00"));
	        product7.setSalePrice(new BigDecimal("1100.00"));
	        product7.setQtyOnHand(12);
	        product7.setCommissionPercentage(new BigDecimal("0.11"));
	        productRepository.save(product7);

	        Product product8 = new Product();
	        product8.setName("Tandem Bike");
	        product8.setManufacturer("DualRide");
	        product8.setStyle("Tandem");
	        product8.setPurchasePrice(new BigDecimal("950.00"));
	        product8.setSalePrice(new BigDecimal("1300.00"));
	        product8.setQtyOnHand(3);
	        product8.setCommissionPercentage(new BigDecimal("0.13"));
	        productRepository.save(product8);

	        // Seed Salespersons
	        Salesperson salesperson1 = new Salesperson();
	        salesperson1.setFirstName("Aarav");
	        salesperson1.setLastName("Patel");
	        salesperson1.setAddress("123 Main St");
	        salesperson1.setPhone("555-123-4565");
	        salesperson1.setStartDate(LocalDate.of(2022, 1, 1));
	        salesperson1.setManager("Manager A");
	        salespersonRepository.save(salesperson1);

	        Salesperson salesperson2 = new Salesperson();
	        salesperson2.setFirstName("Priya");
	        salesperson2.setLastName("Sharma");
	        salesperson2.setAddress("456 Oak St");
	        salesperson2.setPhone("555-567-7865");
	        salesperson2.setStartDate(LocalDate.of(2021, 5, 10));
	        salesperson2.setManager("Manager B");
	        salespersonRepository.save(salesperson2);

	        Salesperson salesperson3 = new Salesperson();
	        salesperson3.setFirstName("Raj");
	        salesperson3.setLastName("Kapoor");
	        salesperson3.setAddress("789 Pine St");
	        salesperson3.setPhone("555-876-7865");
	        salesperson3.setStartDate(LocalDate.of(2020, 3, 15));
	        salesperson3.setManager("Manager C");
	        salespersonRepository.save(salesperson3);

	        Salesperson salesperson4 = new Salesperson();
	        salesperson4.setFirstName("Emily");
	        salesperson4.setLastName("Davis");
	        salesperson4.setAddress("321 Cedar St");
	        salesperson4.setPhone("555-234-8798");
	        salesperson4.setStartDate(LocalDate.of(2021, 11, 22));
	        salesperson4.setManager("Manager A");
	        salespersonRepository.save(salesperson4);

	        Salesperson salesperson5 = new Salesperson();
	        salesperson5.setFirstName("Sita");
	        salesperson5.setLastName("Rao");
	        salesperson5.setAddress("654 Maple St");
	        salesperson5.setPhone("555-432-9089");
	        salesperson5.setStartDate(LocalDate.of(2022, 6, 1));
	        salesperson5.setManager("Manager B");
	        salespersonRepository.save(salesperson5);

	        Salesperson salesperson6 = new Salesperson();
	        salesperson6.setFirstName("Sarah");
	        salesperson6.setLastName("Brown");
	        salesperson6.setAddress("987 Birch St");
	        salesperson6.setPhone("555-678-8987");
	        salesperson6.setStartDate(LocalDate.of(2019, 9, 10));
	        salesperson6.setManager("Manager C");
	        salespersonRepository.save(salesperson6);

	        Salesperson salesperson7 = new Salesperson();
	        salesperson7.setFirstName("David");
	        salesperson7.setLastName("Wilson");
	        salesperson7.setAddress("159 Spruce St");
	        salesperson7.setPhone("555-987-0909");
	        salesperson7.setStartDate(LocalDate.of(2023, 2, 5));
	        salesperson7.setManager("Manager A");
	        salespersonRepository.save(salesperson7);

	        Salesperson salesperson8 = new Salesperson();
	        salesperson8.setFirstName("Anna");
	        salesperson8.setLastName("Guptha");
	        salesperson8.setAddress("753 Elm St");
	        salesperson8.setPhone("555-654-2321");
	        salesperson8.setStartDate(LocalDate.of(2021, 8, 25));
	        salesperson8.setManager("Manager B");
	        salespersonRepository.save(salesperson8);
	        
	        
	        // Customer data
	        
	        
	        Customer customer1 = new Customer();
	        customer1.setFirstName("Dawn");
	        customer1.setLastName("Mock");
	        customer1.setAddress("345 Main St");
	        customer1.setPhone("555-876-9089");
	        customer1.setStartDate(LocalDate.of(2023, 1, 1));
	        customerRepository.save(customer1);

	        Customer customer2 = new Customer();
	        customer2.setFirstName("Adithi");
	        customer2.setLastName("Verma");
	        customer2.setAddress("225 Main St");
	        customer2.setPhone("555-555-4050");
	        customer2.setStartDate(LocalDate.of(2023, 1, 1));
	        customerRepository.save(customer2);

	        Customer customer3 = new Customer();
	        customer3.setFirstName("Arjun");
	        customer3.setLastName("Singh");
	        customer3.setAddress("789 Elm St");
	        customer3.setPhone("555-123-4543");
	        customer3.setStartDate(LocalDate.of(2022, 6, 15));
	        customerRepository.save(customer3);

	        Customer customer4 = new Customer();
	        customer4.setFirstName("Michael");
	        customer4.setLastName("Jordan");
	        customer4.setAddress("432 Oak St");
	        customer4.setPhone("555-678-9999");
	        customer4.setStartDate(LocalDate.of(2021, 9, 5));
	        customerRepository.save(customer4);

	        Customer customer5 = new Customer();
	        customer5.setFirstName("Jessica");
	        customer5.setLastName("Smith");
	        customer5.setAddress("567 Pine St");
	        customer5.setPhone("555-432-8238");
	        customer5.setStartDate(LocalDate.of(2020, 11, 20));
	        customerRepository.save(customer5);

	        Customer customer6 = new Customer();
	        customer6.setFirstName("Robert");
	        customer6.setLastName("Brown");
	        customer6.setAddress("123 Maple St");
	        customer6.setPhone("555-876-9765");
	        customer6.setStartDate(LocalDate.of(2019, 3, 10));
	        customerRepository.save(customer6);

	        Customer customer7 = new Customer();
	        customer7.setFirstName("Emily");
	        customer7.setLastName("Wilson");
	        customer7.setAddress("222 Cedar St");
	        customer7.setPhone("555-234-2030");
	        customer7.setStartDate(LocalDate.of(2022, 12, 1));
	        customerRepository.save(customer7);

	        Customer customer8 = new Customer();
	        customer8.setFirstName("vivek");
	        customer8.setLastName("sami");
	        customer8.setAddress("890 Birch St");
	        customer8.setPhone("555-789-1040");
	        customer8.setStartDate(LocalDate.of(2021, 5, 20));
	        customerRepository.save(customer8);
	        
	        
	        //seles
	        
	        Sales sale1 = new Sales();
	        sale1.setProduct(productRepository.findById(1L).orElse(null)); // Assuming product with ID 1 exists
	        sale1.setSalesperson(salespersonRepository.findById(1L).orElse(null)); // Assuming salesperson with ID 1 exists
	        sale1.setCustomer(customerRepository.findById(1L).orElse(null)); // Assuming customer with ID 1 exists
	        sale1.setSalesDate(LocalDate.of(2023, 1, 15));
	        sale1.setPrice(new BigDecimal("750.00"));
	        sale1.setCommission(new BigDecimal("75.00"));
	        salesRepository.save(sale1);

	        Sales sale2 = new Sales();
	        sale2.setProduct(productRepository.findById(2L).orElse(null));
	        sale2.setSalesperson(salespersonRepository.findById(2L).orElse(null));
	        sale2.setCustomer(customerRepository.findById(2L).orElse(null));
	        sale2.setSalesDate(LocalDate.of(2023, 2, 20));
	        sale2.setPrice(new BigDecimal("900.00"));
	        sale2.setCommission(new BigDecimal("108.00"));
	        salesRepository.save(sale2);

	        Sales sale3 = new Sales();
	        sale3.setProduct(productRepository.findById(3L).orElse(null));
	        sale3.setSalesperson(salespersonRepository.findById(3L).orElse(null));
	        sale3.setCustomer(customerRepository.findById(3L).orElse(null));
	        sale3.setSalesDate(LocalDate.of(2023, 3, 5));
	        sale3.setPrice(new BigDecimal("700.00"));
	        sale3.setCommission(new BigDecimal("56.00"));
	        salesRepository.save(sale3);

	        Sales sale4 = new Sales();
	        sale4.setProduct(productRepository.findById(4L).orElse(null));
	        sale4.setSalesperson(salespersonRepository.findById(4L).orElse(null));
	        sale4.setCustomer(customerRepository.findById(4L).orElse(null));
	        sale4.setSalesDate(LocalDate.of(2023, 4, 12));
	        sale4.setPrice(new BigDecimal("1600.00"));
	        sale4.setCommission(new BigDecimal("240.00"));
	        salesRepository.save(sale4);

	        Sales sale5 = new Sales();
	        sale5.setProduct(productRepository.findById(5L).orElse(null));
	        sale5.setSalesperson(salespersonRepository.findById(5L).orElse(null));
	        sale5.setCustomer(customerRepository.findById(5L).orElse(null));
	        sale5.setSalesDate(LocalDate.of(2023, 5, 8));
	        sale5.setPrice(new BigDecimal("350.00"));
	        sale5.setCommission(new BigDecimal("17.50"));
	        salesRepository.save(sale5);

	        Sales sale6 = new Sales();
	        sale6.setProduct(productRepository.findById(6L).orElse(null));
	        sale6.setSalesperson(salespersonRepository.findById(6L).orElse(null));
	        sale6.setCustomer(customerRepository.findById(6L).orElse(null));
	        sale6.setSalesDate(LocalDate.of(2023, 6, 10));
	        sale6.setPrice(new BigDecimal("1000.00"));
	        sale6.setCommission(new BigDecimal("100.00"));
	        salesRepository.save(sale6);

	        Sales sale7 = new Sales();
	        sale7.setProduct(productRepository.findById(7L).orElse(null));
	        sale7.setSalesperson(salespersonRepository.findById(7L).orElse(null));
	        sale7.setCustomer(customerRepository.findById(7L).orElse(null));
	        sale7.setSalesDate(LocalDate.of(2023, 7, 22));
	        sale7.setPrice(new BigDecimal("1100.00"));
	        sale7.setCommission(new BigDecimal("121.00"));
	        salesRepository.save(sale7);

	        Sales sale8 = new Sales();
	        sale8.setProduct(productRepository.findById(8L).orElse(null));
	        sale8.setSalesperson(salespersonRepository.findById(8L).orElse(null));
	        sale8.setCustomer(customerRepository.findById(8L).orElse(null));
	        sale8.setSalesDate(LocalDate.of(2023, 8, 15));
	        sale8.setPrice(new BigDecimal("1300.00"));
	        sale8.setCommission(new BigDecimal("169.00"));
	        salesRepository.save(sale8);
	    };
	}

}
