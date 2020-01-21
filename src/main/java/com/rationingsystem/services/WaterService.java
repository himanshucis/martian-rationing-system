package com.rationingsystem.services;

import java.util.List;

import com.rationingsystem.entity.Water;

public interface WaterService {

	/**
	 * method for save water in rationing system
	 * 
	 * @param water
	 * @return status of save water
	 */
	Water saveWater(Water water);

	/**
	 * method for get water by particular id
	 * 
	 * @param id
	 * @return water object by water-id
	 */
	Water findById(Long id);

	/**
	 * method for get water by packetId
	 * 
	 * @param packetId
	 * @return water object by packetId
	 */
	Water findByPacketId(String packetId);

	/**
	 * method for get all water list
	 * 
	 * @return list of water
	 */
	List<Water> getAllWater();

	/**
	 * method for update water details
	 * @param water
	 * @return water object
	 */
	Water updateWaterDetails(Water water);
	
	/**
	 * method for update water status
	 * @param water
	 * @return
	 */
	Water updateStatus(Water water);
	
	/**
	 * method for re-update status of water object
	 * @param water
	 * @return
	 */
	Water reUpdateStatus(Water water);
	
	/**
	 * method for particular water by id
	 * 
	 * @param id
	 */
	void deleteWater(Long id);

}
