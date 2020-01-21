package com.rationingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rationingsystem.entity.Ration;

@Repository
public interface RationRepository extends JpaRepository<Ration, Long> {

	/**
	 * method for get ration by packetId
	 * 
	 * @param packetId
	 * @return ration object by packetId
	 */
	Ration findByPacketId(String packetId);
	
	/**
	 * query for order by ascending on date
	 * @return ration list on ascending on date 
	 */
	@Query("Select r from Ration as r order by r.expiryDate")
	List<Ration> findAllOrderByDateAsc();
	
}
