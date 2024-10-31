package pro.bike.profisee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pro.bike.profisee.entity.Salesperson;

@Repository
public interface SalespersonRepository extends JpaRepository<Salesperson, Long> { 
	
	 // boolean existsByFirstNameAndLastNameAndPhoneAndIdNot(String firstName, String lastName, String phone, Long id);

	boolean existsByFirstNameAndLastNameAndIdNot(String firstName, String lastName, Long id);
	
}

