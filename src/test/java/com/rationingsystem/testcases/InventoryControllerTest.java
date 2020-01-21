/**
 * 
 */
package com.rationingsystem.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ConcurrentModel;

import com.rationingsystem.controller.InventoryController;
import com.rationingsystem.entity.Ration;
import com.rationingsystem.entity.Water;
import com.rationingsystem.services.InventoryService;
import com.rationingsystem.services.RationService;
import com.rationingsystem.services.WaterService;

/**
 * @author cis
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class InventoryControllerTest {

	@MockBean
	private InventoryService inventoryService;
	
	@MockBean
	private RationService rationService;
	
	@MockBean
	private WaterService WaterService;
	
	@Autowired 
	private InventoryController inventoryController;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateInventory() throws ParseException {
		Ration ration1 = new Ration();
		ration1.setId(1l);
		ration1.setPacketId("F1");
		ration1.setPacketType("Food");
		ration1.setPacketContent("Rice");
		ration1.setCalories(1000);
		ration1.setExpiryDate("10-02-2020");
		ration1.setStatus(true);
		
		Water water = new Water();
		water.setId(1l);
		water.setPacketId("W1");
		water.setPacketType("Water");
		water.setQuantityInLitres(2);
		water.setStatus(true);
		
		List<Ration> rationList = new ArrayList<Ration>();
		List<Water> waterList = new ArrayList<Water>();
		rationList.add(ration1);
		waterList.add(water);
		
		when(WaterService.getAllWater()).thenReturn(waterList);
		when(rationService.getAllRation()).thenReturn(rationList);
		
		String response = inventoryController.createSchedule(new ConcurrentModel());
		assertEquals("inventoryration",response);
	}

}
