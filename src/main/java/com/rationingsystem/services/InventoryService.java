package com.rationingsystem.services;

import java.util.List;

import com.rationingsystem.entity.Inventory;

public interface InventoryService {

	/**
	 * method for save ration in Inventory
	 * @param inventory
	 * @return inventory ration save status
	 */
	Inventory saveInventory(Inventory inventory);
	
	/**
	 * method for get list of Inventory ration
	 * @return
	 */
	List<Inventory> getAllInventoryData();
	
	/**
	 * method for clear all schedules in inventory
	 */
	void clearSchedules();
	
}
