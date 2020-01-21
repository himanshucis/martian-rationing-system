package com.rationingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rationingsystem.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

	/**
	 * query for order by ascending on date
	 * @return ration list on ascending on date 
	 */
	@Query("Select i from Inventory as i order by i.date")
	List<Inventory> findAllOrderByDateAsc();
}
