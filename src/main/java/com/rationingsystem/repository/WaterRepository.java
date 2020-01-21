package com.rationingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rationingsystem.entity.Water;

@Repository
public interface WaterRepository extends JpaRepository<Water,Long> {

	/**
	 * method for get water for packetId
	 * @param packetId
	 * @return water object for particular packetId
	 */
	Water findByPacketId(String packetId);
	
	/**
	 * query for get water in desc order
	 * @return desc water list
	 */
	@Query("Select w from Water as w order by w.quantityInLitres desc")
	List<Water> findAllOrderByWaterDesc();
}
