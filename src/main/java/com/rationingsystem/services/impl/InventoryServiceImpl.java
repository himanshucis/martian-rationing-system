package com.rationingsystem.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rationingsystem.entity.Inventory;
import com.rationingsystem.entity.Ration;
import com.rationingsystem.entity.Water;
import com.rationingsystem.repository.InventoryRepository;
import com.rationingsystem.services.InventoryService;
import com.rationingsystem.services.RationService;
import com.rationingsystem.services.WaterService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private RationService rationService;

	@Autowired
	private WaterService waterService;

	/**
	 * method implementation for save inventory ration
	 */
	@Override
	public Inventory saveInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	/**
	 * method implementation for get list of all inventory data
	 */
	@Override
	public List<Inventory> getAllInventoryData() {
		return inventoryRepository.findAllOrderByDateAsc();
	}

	@Override
	public void clearSchedules() {
		// TODO Auto-generated method stub
		// get all inventory schedules
		List<Inventory> inventoryList = inventoryRepository.findAllOrderByDateAsc();
		for (Inventory inventory : inventoryList) {
			// re-update ration status
			List<Ration> rationList = inventory.getRationList();
			for (Ration ration : rationList) {
				if (ration.isStatus() == false) {
					rationService.reUpdateStatus(ration);
				}
			}
			// re-update water status
			List<Water> waterList = inventory.getWaterList();
			for (Water water : waterList) {
				if (water.isStatus() == false) {
					waterService.reUpdateStatus(water);
				}
			}
		}
		// clear all inventory schedules
		inventoryRepository.deleteAll();
	}
}
