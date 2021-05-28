package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.dao.LogModel;
import com.application.service.LogService;


@RestController
public class Controller_application {
	
	@Autowired
	private LogService ls;
	
	@GetMapping("/checkIn")
	public void addCheckIn(@RequestParam("name") String name)
	{
		ls.checkIn(name);
	}
	
	@GetMapping("/checkOut")
	public void addCheckOut(@RequestParam("name") String name)
	{
		ls.checkOut(name);
	}
	
	@GetMapping("/getLog")
	public List<LogModel> getLogByDate(@RequestParam("date") String date)
	{
		
		return ls.logByDate(date);
		
	}
	
	@GetMapping("/getAllLog")
	public List<LogModel> getAllLog()
	{
		return ls.allLogs();
		
	}

}
