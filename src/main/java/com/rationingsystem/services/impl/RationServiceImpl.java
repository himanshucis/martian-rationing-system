package com.rationingsystem.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rationingsystem.constant.Constant;
import com.rationingsystem.entity.Ration;
import com.rationingsystem.repository.RationRepository;
import com.rationingsystem.services.RationService;

@Service
public class RationServiceImpl implements RationService {

	@Autowired
	private RationRepository rationRepository;

	/**
	 * method implementation for save ration with ration object
	 */
	@Override
	public Ration saveRation(Ration ration) {
		// TODO Auto-generated method stub
		Ration oldRation = rationRepository.findByPacketId(ration.getPacketId());
		if (oldRation == null) {
			return rationRepository.save(ration);
		} else {
			return Constant.RATION_ERROR;
		}
	}

	/**
	 * method implementation for get All ration list
	 */
	@Override
	public List<Ration> getAllRation() {
		// TODO Auto-generated method stub
	    List<Ration> rationList = rationRepository.findAllOrderByDateAsc();
	    return rationList;
	}

	/**
	 * method implementation for get ration by Id
	 */
	@Override
	public Ration findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Ration> ration = rationRepository.findById(id);
		return ration.isPresent() ? ration.get() : null;
	}
	
	/**
	 * method implementation for get ration by packetId
	 */
	@Override
	public Ration findByPacketId(String packetId) {
		// TODO Auto-generated method stub
		return rationRepository.findByPacketId(packetId);
	}

	/**
	 * method implementation for update ration details for particular ration
	 */
	@Override
	public Ration updateRationDetails(Ration ration) {
		// TODO Auto-generated method stub
		Ration oldRation = findById(ration.getId());
		if (oldRation != null) {
			oldRation.setPacketId(ration.getPacketId());
			oldRation.setPacketType(ration.getPacketType());
			oldRation.setPacketContent(ration.getPacketContent());
			oldRation.setCalories(ration.getCalories());
			oldRation.setExpiryDate(ration.getExpiryDate());
			rationRepository.save(oldRation);
			return oldRation;
		}
		return null;
	}
	
	/**
	 * method implementation for Update status for particular ration
	 */
	@Override
	public Ration updateStatus(Ration ration) {
		// TODO Auto-generated method stub
		Ration oldRation = findById(ration.getId());
		if (oldRation != null) {
			oldRation.setStatus(false);
			return rationRepository.save(oldRation);
		} else {
			return null;
		}
	}
	
	/**
	 * method implementation for delete particular ration
	 */
	@Override
	public void deleteRation(Long id) {
		// TODO Auto-generated method stub
		rationRepository.deleteById(id);
	}

	/**
	 * method implementation for ration status re-update
	 */
	@Override
	public Ration reUpdateStatus(Ration ration) {
		// TODO Auto-generated method stub
		Ration oldRation = findById(ration.getId());
		if (oldRation != null && oldRation.isStatus()==false) {
			oldRation.setStatus(true);
			return rationRepository.save(oldRation);
		} else {
			return null;
		}
	}
	
}
