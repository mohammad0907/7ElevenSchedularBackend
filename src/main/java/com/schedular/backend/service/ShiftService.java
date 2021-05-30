package com.schedular.backend.service;

import java.sql.Date;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.GeneratedValue;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedular.backend.model.Shift;
import com.schedular.backend.repository.ShiftRepository;
import com.schedular.backend.utils.Constants;

import javassist.tools.framedump;


@Service
public class ShiftService {

	@Autowired
	ShiftRepository shiftRepository;
	
	public ShiftService() {
		
	}
	
	public Shift getShiftById(int id) throws Exception{
		return shiftRepository.findById(id).orElseThrow(() -> new Exception("Shift not found"));
	}
	
	public List<Shift>getAllShift(){
		//change this 
		List<Shift>shifts = new ArrayList<>();
		shiftRepository.findAll().forEach(shift -> shifts.add(shift));
		return shifts;
	}
	
	public void updateShift(int id, Shift shift) throws Exception {
		Shift updateShift = getShiftById(id);
		updateShift.setEmployeeId(shift.getEmployeeId());
		updateShift.setEmployeeFirstName(shift.getEmployeeFirstName());
		updateShift.setEmployeeLastName(shift.getEmployeeLastName());
		shiftRepository.save(updateShift);
	}
	
	public void insertShift(Shift shift) throws Exception {
		shiftRepository.save(shift);
	}
	
	public void generateShiftForNextWeek(String Date) {
		Calendar calendar = getNextSunday();
		Shift shift = new Shift();
		for(int i = 0; i < 7;  i++) {
			for (int j = 0; j < 3; j++){
				shift.setSession(Constants.session[j]);
				shift.setDate((java.sql.Date)calendar.getTime());
				shift.setDay(Constants.DAY[calendar.getTime().getDay()]);
				try {
					insertShift(shift);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private Calendar getNextSunday() {
		Calendar calendar = Calendar.getInstance();
		int dayOfTheWeek = Calendar.DAY_OF_WEEK;
		calendar.set(Calendar.DAY_OF_WEEK, 7 - dayOfTheWeek);
		return calendar;
	}
}
