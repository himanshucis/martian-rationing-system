package com.rationingsystem.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

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
import com.rationingsystem.entity.Ration;
import com.rationingsystem.entity.Water;
import com.rationingsystem.services.RationService;
import com.rationingsystem.services.WaterService;

@Controller
@RequestMapping("/rationcontroller")
public class RationController {

	@Autowired
	private RationService rationService;

	@Autowired
	private WaterService waterService;

	/**
	 * request for save ration in rationing system
	 * 
	 * @param model
	 * @param packetId
	 * @param packetType
	 * @param packetContent
	 * @param calories
	 * @param expiryDate
	 * @return status of save ration
	 * @throws ParseException
	 */
	@PostMapping("/saveration")
	public String saveRation(Model model, @RequestParam("pid") String packetId,
			@RequestParam("ptype") String packetType, @RequestParam("pcontent") String packetContent,
			@RequestParam("calories") Integer calories, @RequestParam("expirydate") String expiryDate)
			throws ParseException {
		Ration ration = new Ration();
		ration.setPacketId(packetId);
		ration.setPacketType(packetType);
		ration.setPacketContent(packetContent);
		ration.setCalories(calories);
		ration.setExpiryDate(expiryDate);
		LocalDate date = LocalDate.parse(expiryDate);
		if (date.compareTo(LocalDate.now()) >= 0) {
			ration = rationService.saveRation(ration);
			if (ration != null) {
				model.addAttribute("success", "Ration successfully add in Inventory");
				return Constant.ADDRATION;
			} else {
				model.addAttribute("failed", "Dublicate Ration packet-Id, Enter unique packet-Id");
				return Constant.ADDRATION;
			}
		} else {
			model.addAttribute("failed", "Expiry Date is before from currunt-date");
			model.addAttribute("dateError", "Enter Date is After from currunt-date");
			return Constant.ADDRATION;
		}
	}

	/**
	 * request for get ration and water in ration system
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/viewration")
	public String viewRation(Model model, HttpSession session) {
		List<Ration> ration = rationService.getAllRation();
		List<Water> water = waterService.getAllWater();
		if (!ration.isEmpty() || !water.isEmpty()) {
			model.addAttribute("rationlists", ration);
			model.addAttribute("waterlists", water);
			model.addAttribute("success", session.getAttribute("success"));
			// rationService.reUpdateStatus();
			session.removeAttribute("success");
			return Constant.VIEWRATION;
		}
		model.addAttribute("failed", "Ration Inventory is Empty!!");
		return Constant.VIEWRATION;
	}

	/**
	 * request for load update detail page
	 * 
	 * @param model
	 * @param rationId
	 * @return update ration details page
	 */
	@GetMapping("/updateration")
	public String updateRation(Model model, HttpSession session, @RequestParam("rationid") Long rationId) {
		Ration ration = rationService.findById(rationId);
		if (ration != null) {
			model.addAttribute("ration", ration);
			model.addAttribute("failed", session.getAttribute("failed"));
			return Constant.RATION_UPDATE;
		}
		return Constant.VIEW_REDIRECT;
	}

	/**
	 * request for update ration details for particular ration
	 * 
	 * @param model
	 * @param rationId
	 * @param packetId
	 * @param packetType
	 * @param packetContent
	 * @param calories
	 * @param expiryDate
	 * @return update ration status
	 * @throws ParseException
	 */
	@PostMapping("/updaterationdetails")
	public String updateRationDetails(Model model, @RequestParam("id") Integer rationId,
			@RequestParam("pid") String packetId, @RequestParam("ptype") String packetType,
			@RequestParam("pcontent") String packetContent, @RequestParam("calories") Integer calories,
			@RequestParam("expirydate") String expiryDate, HttpSession session) throws ParseException {
		Ration ration = new Ration();
		ration.setId(rationId);
		ration.setPacketId(packetId);
		ration.setPacketType(packetType);
		ration.setPacketContent(packetContent);
		ration.setCalories(calories);
		ration.setExpiryDate(expiryDate);
		ration = rationService.updateRationDetails(ration);
		if (ration != null) {
			session.setAttribute("success", "Ration update successFully.");
			session.removeAttribute("failed");
			return Constant.VIEW_REDIRECT;
		} else {
			session.setAttribute("failed", "Ration Details updation failed !! try again");
			return Constant.UPDATE_RATION_REDIRECT + "?rationid=" + rationId;
		}
	}

	/**
	 * VIEW_REDIRECT request for delete ration on particular-Id
	 * 
	 * @param rationId
	 * @return redirect on view-ration
	 */
	@GetMapping("/deleteration")
	public ModelAndView deleteRation(@RequestParam("rationid") Long rationId) {
		rationService.deleteRation(rationId);
		return new ModelAndView(Constant.VIEW_REDIRECT);
	}

}
