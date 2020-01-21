/**
 * 
 */
package com.rationingsystem.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.rationingsystem.entity.Ration;
import com.rationingsystem.repository.RationRepository;
import com.rationingsystem.services.impl.RationServiceImpl;

/**
 * @author cis
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class RationSeviceImplTest {
	
	@MockBean
	private RationRepository rationRepository;
	
	@Autowired
	private RationServiceImpl rationServiceImpl;

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
	void testSaveRation() {
		Ration ration = new Ration();
		ration.setId(1l);
		ration.setPacketId("F1");
		ration.setPacketType("Food");
		ration.setPacketContent("Rice");
		ration.setCalories(1000);
		ration.setExpiryDate("10-02-2020");
		ration.setStatus(true);
		when(rationRepository.save(Mockito.any(Ration.class))).thenReturn(ration);
		Ration rationSaved = rationServiceImpl.saveRation(ration);
		assertEquals(ration.getId(), rationSaved.getId());	
	}
	
	@Test
	void testGetAllRation() {
		List<Ration> rationList = new ArrayList<Ration>();
		Ration ration = new Ration();
		ration.setId(1l);
		ration.setPacketId("F1");
		ration.setPacketType("Food");
		ration.setPacketContent("Rice");
		ration.setCalories(1000);
		ration.setExpiryDate("10-02-2020");
		ration.setStatus(true);
		rationList.add(ration);
		when(rationRepository.findAllOrderByDateAsc()).thenReturn(rationList);
		List<Ration> fetchRationList = rationServiceImpl.getAllRation();
		assertEquals(rationList.get(0).getPacketType(), fetchRationList.get(0).getPacketType());
	}
	
	@Test
	void testFindById() {
		Ration ration = new Ration();
		ration.setId(1l);
		ration.setPacketId("F1");
		ration.setPacketType("Food");
		ration.setPacketContent("Rice");
		ration.setCalories(1000);
		ration.setExpiryDate("10-02-2020");
		ration.setStatus(true);
		when(rationRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(ration));
		Ration fatchedRation = rationServiceImpl.findById(ration.getId());
		assertEquals(ration.getId(),fatchedRation.getId());
	}
	
	@Test
	void testFindByPacketId() {
		Ration ration = new Ration();
		ration.setId(1l);
		ration.setPacketId("F1");
		ration.setPacketType("Food");
		ration.setPacketContent("Rice");
		ration.setCalories(1000);
		ration.setExpiryDate("10-02-2020");
		ration.setStatus(true);
		when(rationRepository.findByPacketId(Mockito.anyString())).thenReturn(ration);
		Ration fatchedRation = rationServiceImpl.findByPacketId(ration.getPacketId());
		assertEquals(ration.getPacketId(),fatchedRation.getPacketId());
	}
	
	@Test
	void testUpdateRation() {
		Ration ration = new Ration();
		ration.setId(1l);
		ration.setPacketId("F1");
		ration.setPacketType("Food");
		ration.setPacketContent("Dry-Food");
		ration.setCalories(1500);
		ration.setExpiryDate("10-02-2020");
		ration.setStatus(true);
		when(rationRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(ration));
		Ration updatedRation = rationServiceImpl.updateRationDetails(ration);
		assertEquals(ration.getId(),updatedRation.getId());
	}

}
