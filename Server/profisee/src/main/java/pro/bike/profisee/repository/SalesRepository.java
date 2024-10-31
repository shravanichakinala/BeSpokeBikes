package pro.bike.profisee.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pro.bike.profisee.entity.QuarterlyCommissionProjection;

import pro.bike.profisee.entity.Sales;
@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
	
    List<Sales> findBySalesDateBetween(LocalDate startDate, LocalDate endDate);
    
//    @Query("SELECT pro.bike.profisee.entity.QuarterlyCommissionReport(s.salesperson.id, s.salesperson.firstName, s.salesperson.lastName, " +
//            "FUNCTION('QUARTER', s.salesDate), YEAR(s.salesDate), SUM(s.commission)) " +
//            "FROM Sales s " +
//            "WHERE s.salesDate BETWEEN :startDate AND :endDate " +
//            "GROUP BY s.salesperson.id, YEAR(s.salesDate), FUNCTION('QUARTER', s.salesDate)")
//     List<QuarterlyCommissionReport> findQuarterlyCommissions(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
// 
//    
 
    @Query("SELECT s.salesperson.id AS salespersonId, " +
    	       "s.salesperson.firstName AS salespersonFirstName, " +
    	       "s.salesperson.lastName AS salespersonLastName, " +
    	       "(CASE WHEN MONTH(s.salesDate) IN (1, 2, 3) THEN 1 " +
    	       "WHEN MONTH(s.salesDate) IN (4, 5, 6) THEN 2 " +
    	       "WHEN MONTH(s.salesDate) IN (7, 8, 9) THEN 3 " +
    	       "ELSE 4 END) AS quarter, " +
    	       "YEAR(s.salesDate) AS year, " +
    	       "SUM(s.commission) AS totalCommission " +
    	       "FROM Sales s " +
    	       "WHERE s.salesDate BETWEEN :startDate AND :endDate " +
    	       "GROUP BY s.salesperson.id, YEAR(s.salesDate), " +
    	       "(CASE WHEN MONTH(s.salesDate) IN (1, 2, 3) THEN 1 " +
    	       "WHEN MONTH(s.salesDate) IN (4, 5, 6) THEN 2 " +
    	       "WHEN MONTH(s.salesDate) IN (7, 8, 9) THEN 3 " +
    	       "ELSE 4 END)")
    	List<QuarterlyCommissionProjection> findQuarterlyCommissions(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}

