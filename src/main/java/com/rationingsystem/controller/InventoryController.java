package com.rationingsystem.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rationingsystem.constant.Constant;
import com.rationingsystem.entity.Inventory;
import com.rationingsystem.entity.Ration;
import com.rationingsystem.entity.Water;
import com.rationingsystem.services.InventoryService;
import com.rationingsystem.services.RationService;
import com.rationingsystem.services.WaterService;

@Controller
@RequestMapping("/inventorycontroller")
public class InventoryController {

	@Autowired
	private RationService rationService;

	@Autowired
	private WaterService waterService;

	@Autowired
	private InventoryService inventoryService;

	public static LocalDate date = LocalDate.now();
	public static int quantity1;
	public static int totalQuantity;

	/**
	 * request for create ration schedules for inventory
	 * 
	 * @param model
	 * @return view-schedule page s
	 * @throws ParseException
	 */
	@GetMapping("/inventoryschedule")
	public String createSchedule(Model model) throws ParseException {

		// get all ration in ration table
		List<Ration> rationList = rationService.getAllRation();
		// get all water in water table
		List<Water> waterList = waterService.getAllWater();

		List<Ration> ration = new ArrayList<Ration>();
		List<Water> water = new ArrayList<Water>();
		List<Ration> rationKey = new ArrayList<Ration>();
		List<Water> waterStatusList = new ArrayList<Water>();

		// create pair of ration for total 2500 calories
		for (int i = 0; i < rationList.size(); i++) {
			for (int j = 1; j < rationList.size(); j++) {
				Integer calorie1 = rationList.get(i).getCalories();
				Integer calorie2 = rationList.get(j).getCalories();
				Integer calorie = calorie1 + calorie2;
				if (calorie.equals(2500)) {
					if (rationList.get(i).isStatus() == true && rationList.get(j).isStatus() == true) {

						ration.add(rationList.get(i));
						ration.add(rationList.get(j));
						Ration r1 = rationList.get(i);
						Ration r2 = rationList.get(j);

						// update ration status because this ration use in schedule inventory
						rationService.updateStatus(r1);
						rationService.updateStatus(r2);

					} else {
						continue;
					}
				} else {
					continue;
				}
			}
		}

		// for water schedule
		for (int k = 0; k < waterList.size(); k++) {

			// water quantity is 2 then save water with ration in inventory
			if (waterList.get(k).getQuantityInLitres().equals(2) && waterList.get(k).isStatus() == true
					&& ration.size() > 0) {
				water.add(waterList.get(k));
				for (int i = 0; i < 2; i++) {
					rationKey.add(ration.get(i));
				}

				LocalDate expiryDate1 = LocalDate.parse(ration.get(0).getExpiryDate());
				LocalDate expiryDate2 = LocalDate.parse(ration.get(1).getExpiryDate());

				// Compare the dates using compareTo()
				if (expiryDate1.compareTo(date) >= 0 && expiryDate2.compareTo(date) >= 0) {

					Inventory inventory = new Inventory();
					inventory.setDate(date.toString());
					inventory.setRationList(rationKey);
					inventory.setWaterList(water);

					// update water status for used in inventory then can't use again
					Water w1 = waterList.get(k);
					waterService.updateStatus(w1);

					// save ration schedule in inventory
					inventoryService.saveInventory(inventory);
					date = date.plusDays(1);
					rationKey = new ArrayList<Ration>();
					water = new ArrayList<Water>();
					ration.remove(0);
					ration.remove(0);
				} else {
					if (expiryDate1.compareTo(date) < 0 || expiryDate2.compareTo(date) < 0) {
						rationKey = new ArrayList<Ration>();
						water = new ArrayList<Water>();
						
						if (expiryDate1.compareTo(date) < 0)
							rationService.reUpdateStatus(ration.get(1));
						else
							rationService.reUpdateStatus(ration.get(0));
						
						ration.remove(0);
						ration.remove(0);
					}
				}
			} else {
				// water quantity is 1 then else save water with ration in inventory
				quantity1 = waterList.get(k).getQuantityInLitres();
				if (quantity1 == 1 && waterList.get(k).isStatus() == true && ration.size() > 0) {
					totalQuantity = totalQuantity + quantity1;
					water.add(waterList.get(k));
					Water w = waterList.get(k);
					waterStatusList.add(w);

					if (totalQuantity == 2) {

						for (int i = 0; i < 2; i++) {
							rationKey.add(ration.get(i));
						}

						LocalDate expiryDate1 = LocalDate.parse(ration.get(0).getExpiryDate());
						LocalDate expiryDate2 = LocalDate.parse(ration.get(1).getExpiryDate());

						if (expiryDate1.compareTo(date) >= 0 && expiryDate2.compareTo(date) >= 0) {

							Inventory inventory = new Inventory();
							inventory.setDate(date.toString());
							inventory.setRationList(rationKey);
							inventory.setWaterList(water);

							// save ration in inventory with 2 water this quantity is 1 liter
							inventoryService.saveInventory(inventory);

							// date plus for next schedule....
							date = date.plusDays(1);
							rationKey = new ArrayList<Ration>();
							water = new ArrayList<Water>();
							ration.remove(0);
							ration.remove(0);

							// update water status because this water use in inventory schedule
							waterService.updateStatus(waterStatusList.get(0));
							waterService.updateStatus(waterStatusList.get(1));
							waterStatusList = new ArrayList<Water>();
							totalQuantity = 0;
						} else {

							if (expiryDate1.compareTo(date) < 0 || expiryDate2.compareTo(date) < 0) {
								rationKey = new ArrayList<Ration>();
								water = new ArrayList<Water>();
								
								if (expiryDate1.compareTo(date) < 0)
									rationService.reUpdateStatus(ration.get(1));
								else 
									rationService.reUpdateStatus(ration.get(0));
								
								ration.remove(0);
								ration.remove(0);
								waterStatusList = new ArrayList<Water>();
								totalQuantity = 0;
							}
						}
					} else {
						continue;
					}
				} else {
					continue;
				}
			}
		}
		for (int i = 0; i < ration.size(); i++) {
			Ration rationStatusRe_Upd = ration.get(i);
			// ration status re-update.....
			rationService.reUpdateStatus(rationStatusRe_Upd);
		}
		ration = new ArrayList<Ration>();

		// get list of inventory schedule ration
		List<Inventory> inventoryList = inventoryService.getAllInventoryData();

		// add into the model for show into the JSP
		model.addAttribute("listsize", inventoryList.size());
		model.addAttribute("inventoryList", inventoryList);
		return Constant.INVENTORY_RATION;
	}

	/**
	 * request for view inventory ration list
	 * 
	 * @param model
	 * @return list of inventory-ration
	 */
	@GetMapping("/viewinventoryration")
	public String viewInventoryRation(Model model) {
		// get all ration schedule for inventory table
		List<Inventory> inventoryList = inventoryService.getAllInventoryData();
		if (!inventoryList.isEmpty()) {
			// add schedule list in model for view into the jsp
			model.addAttribute("listsize", inventoryList.size());
			model.addAttribute("inventoryList", inventoryList);
			return Constant.INVENTORY_RATION;
		} else {
			model.addAttribute("rationerror", "Inventory Ration Schedule's is Empty!!");
			return Constant.INVENTORY_RATION;
		}
	}
	@GetMapping("/clearschedules")
	public String clearSchedules() {
		inventoryService.clearSchedules();
		date = LocalDate.now();
		quantity1=0;
		totalQuantity=0;
		return Constant.VIEW_REDIRECT;
	}
}
