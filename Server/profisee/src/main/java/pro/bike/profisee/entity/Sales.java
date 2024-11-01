package pro.bike.profisee.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Sales {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		@ManyToOne
	    private Product product;

	    @ManyToOne
	    private Salesperson salesperson;

	    @ManyToOne
	    private Customer customer;

	    private LocalDate salesDate;
	    private BigDecimal price;
	    private BigDecimal commission;
	    
	    @Override
	    public String toString() {
	        return "Sales{" +
	                "id=" + id +
	                ", product=" + (product != null ? product.getName() : "null") +
	                ", salesperson=" + (salesperson != null ? salesperson.getFirstName() + " " + salesperson.getLastName() : "null") +
	                ", customer=" + (customer != null ? customer.getFirstName() + " " + customer.getLastName() : "null") +
	                ", salesDate=" + salesDate +
	                ", price=" + price +
	                ", commission=" + commission +
	                '}';
	    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Salesperson getSalesperson() {
		return salesperson;
	}
	public void setSalesperson(Salesperson salesperson) {
		this.salesperson = salesperson;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDate getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(LocalDate salesDate) {
		this.salesDate = salesDate;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getCommission() {
		return commission;
	}
	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}
	

}
