package com.rationingsystem.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rationingsystem.constant.Constant;
import com.rationingsystem.entity.Water;
import com.rationingsystem.repository.WaterRepository;
import com.rationingsystem.services.WaterService;

@Service
public class WaterServiceImpl implements WaterService {

	@Autowired
	private WaterRepository waterRepository;

	/**
	 * method implementation for save water object
	 */
	@Override
	public Water saveWater(Water water) {
		// TODO Auto-generated method stub
		Water oldWater = waterRepository.findByPacketId(water.getPacketId());
		if (oldWater == null) {
			return waterRepository.save(water);
		} else {
			return Constant.WATER_ERROR;
		}
	}

	/**
	 * method implementation for get list of water
	 */
	@Override
	public List<Water> getAllWater() {
		// TODO Auto-generated method stub
		List<Water> waterList = waterRepository.findAllOrderByWaterDesc();
		return waterList;
	}

	/**
	 * method implementation for get water by particular-Id
	 */
	@Override
	public Water findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Water> water = waterRepository.findById(id);
		return water.isPresent() ? water.get() : null;
	}

	/**
	 * method implementation for get water by particular packetId
	 */
	@Override
	public Water findByPacketId(String packetId) {
		// TODO Auto-generated method stub
		return waterRepository.findByPacketId(packetId);
	}

	/**
	 * method implementation for update particular water details
	 */
	@Override
	public Water updateWaterDetails(Water water) {
		// TODO Auto-generated method stub
		Water oldWater = findById(water.getId());
		if (oldWater != null) {
			oldWater.setPacketId(water.getPacketId());
			oldWater.setPacketType(water.getPacketType());
			oldWater.setQuantityInLitres(water.getQuantityInLitres());
			waterRepository.save(oldWater);
			return oldWater;
		} else {
			return null;
		}
	}

	/**
	 * method implementation for water status update
	 */
	@Override
	public Water updateStatus(Water water) {
		// TODO Auto-generated method stub
		Water oldWater = findById(water.getId());
		if (oldWater != null) {
			oldWater.setStatus(false);
			return waterRepository.save(oldWater);
		} else {
			return null;
		}
	}
	
	/**
	 * method implementation for water status re-update
	 */
	@Override
	public Water reUpdateStatus(Water water) {
		// TODO Auto-generated method stub
		Water oldWater = findById(water.getId());
		if(oldWater!=null&&oldWater.isStatus()==false) {
			oldWater.setStatus(true);
			waterRepository.save(oldWater);
			return oldWater;
		}
		return null;
	}
	
	/**
	 * method implementation for delete water for particular-Id
	 */
	@Override
	public void deleteWater(Long id) {
		// TODO Auto-generated method stub
		waterRepository.deleteById(id);
	}

}
