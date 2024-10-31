package pro.bike.profisee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pro.bike.profisee.entity.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> { }