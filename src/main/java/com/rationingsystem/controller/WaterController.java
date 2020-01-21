package com.rationingsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rationingsystem.constant.Constant;
import com.rationingsystem.entity.Water;
import com.rationingsystem.services.WaterService;

@Controller
@RequestMapping("/watercontroller")
public class WaterController {
	
	@Autowired
	private WaterService waterService;

	/**
	 * request for save water in rationing system
	 * 
	 * @param model
	 * @param packetId
	 * @param packetType
	 * @param quantity
	 * @return status of save water
	 */
	@PostMapping("/savewater")
	public String saveWater(Model model, @RequestParam("pid") String packetId, @RequestParam("ptype") String packetType,
			@RequestParam("quantity") Integer quantity) {
		Water water = new Water();
		water.setPacketId(packetId);
		water.setPacketType(packetType);
		water.setQuantityInLitres(quantity);
		water = waterService.saveWater(water);
		if (water != null) {
			model.addAttribute("watersuccess", "Water successfully add in Inventory");
			return Constant.ADDWATER;
		} else {
			model.addAttribute("waterError", "Dublicate water packet-Id,Enter unique packet-Id");
			return Constant.ADDWATER;
		}
	}

	/**
	 * request for load update water details page
	 * 
	 * @param model
	 * @param waterId
	 * @return load water detail jsp page
	 */
	@GetMapping("/updatewater")
	public String updateWater(Model model, @RequestParam("waterid") Long waterId) {
		Water water = waterService.findById(waterId);
		if (water != null) {
			model.addAttribute("water", water);
			return Constant.WATER_UPDATE;
		}
		return Constant.VIEW_REDIRECT;
	}

	/**
	 * request for update ration details and update into database
	 * 
	 * @param model
	 * @param packetId
	 * @param packetType
	 * @param quantity
	 * @return update status
	 */
	@PostMapping("/updatewaterdetails")
	public String updateWaterDetails(Model model, @RequestParam("id") Integer waterId,
			@RequestParam("pid") String packetId, @RequestParam("ptype") String packetType,
			@RequestParam("quantity") Integer quantity,HttpSession session) {
		Water water = new Water();
		water.setId(waterId);
		water.setPacketId(packetId);
		water.setPacketType(packetType);
		water.setQuantityInLitres(quantity);
		water = waterService.updateWaterDetails(water);
		if (water != null) {
			session.setAttribute("success","Water update Successfully.");
			return Constant.VIEW_REDIRECT;
		}
		model.addAttribute("updatewatererror", "Water Details updation failed !! try again");
		return Constant.WATER_UPDATE;
	}

	/**
	 * request for delete water on particular-Id
	 * 
	 * @param waterId
	 * @return redirect on view-ration
	 */
	@GetMapping("/deletewater")
	public ModelAndView deleteWater(@RequestParam("waterid") Long waterId) {
		waterService.deleteWater(waterId);
		return new ModelAndView(Constant.VIEW_REDIRECT);
	}
}
