package com.schedular.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedular.backend.model.Shift;
import com.schedular.backend.service.ShiftService;

@RestController
@RequestMapping(value = "/shift/")
public class ShiftController {
	
	@Autowired
	ShiftService shiftService;
	
	public ShiftController() {
		
	}
	
	
	@GetMapping("/")
	public List<Shift> getShiftsOftheWeek() {
		return shiftService.getAllShift();
	}
	
	
}
