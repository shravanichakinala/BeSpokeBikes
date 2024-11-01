package pro.bike.profisee.entity;

public interface QuarterlyCommissionProjection {
	    Long getSalespersonId();
	    String getSalespersonFirstName();
	    String getSalespersonLastName();
	    Integer getQuarter();
	    Integer getYear();
	    Double getTotalCommission();

}
