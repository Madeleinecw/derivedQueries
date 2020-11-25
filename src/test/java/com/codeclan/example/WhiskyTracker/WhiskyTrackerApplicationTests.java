package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskysByYear(){
		List<Whisky> found = whiskyRepository.findWhiskysByYear(2018);
		assertEquals(6, found.size());
	}

	@Test
	public void canFindDistillerysByRegions(){
		List<Distillery> found = distilleryRepository.findDistillerysByRegion("Highland");
		assertEquals(3, found.size());
	}

	@Test
	public void canFindWhiskysByDistilleryAndYear(){
		List<Whisky> found = whiskyRepository.findWhiskysByDistilleryIdAndYear(1L, 2018);
		assertEquals(2, found.size());
	}

	@Test
	public void canFindWhiskysByDistillerys(){
		Distillery foundDistillery = distilleryRepository.getOne(1L);
		List<Whisky> found = whiskyRepository.findWhiskysByDistillery(foundDistillery);
		assertEquals(2, found.size());
	}
}
