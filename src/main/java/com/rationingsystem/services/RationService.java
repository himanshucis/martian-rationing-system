package com.rationingsystem.services;

import java.util.List;

import com.rationingsystem.entity.Ration;

public interface RationService {

	/**
	 * method for save ration
	 * 
	 * @param ration
	 * @return status for save ration
	 */
	Ration saveRation(Ration ration);

	/**
	 * method for get all ration list
	 * 
	 * @return list of ration
	 */
	List<Ration> getAllRation();

	/**
	 * method for ration find by id
	 * 
	 * @param id
	 * @return ration object by particular id
	 */
	Ration findById(Long id);

	/**
	 * method for ration find by packetId
	 * 
	 * @param packetId
	 * @return ration object by packetId
	 */
	Ration findByPacketId(String packetId);
	
	/**
	 * method for update ration-details
	 * @param ration
	 * @return ration object
	 */
	Ration updateRationDetails(Ration ration);
	
	/**
	 * method for update ration status
	 * @param ration
	 * @return update status
	 */
	Ration updateStatus(Ration ration);
	
	/**
	 * method for re-update status for ration
	 * @param ration
	 * @return re-update status
	 */
	Ration reUpdateStatus(Ration ration);
	
	/**
	 * method for particular ration delete by id
	 * 
	 * @param id
	 */
	void deleteRation(Long id);
	
}
