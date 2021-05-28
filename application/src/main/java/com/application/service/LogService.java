package com.application.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dao.LogModel;
import com.application.repo.RepositoryClass;

@Service
public class LogService {
	
	@Autowired
	private RepositoryClass repo;
	
	LogModel logModel= new LogModel();
	
	public void checkIn(String name)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String[] s = dtf.format(now).split(" ");
        logModel.setLogType("IN");
        logModel.setDate(s[0]);
        logModel.setTime(s[1]);
        logModel.setName(name+s[1]);
        //logModel.setName(name);
        repo.save(logModel);
	}
	
	public void checkOut(String name)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String[] s = dtf.format(now).split(" ");
        logModel.setLogType("OUT");
        logModel.setDate(s[0]);
        logModel.setTime(s[1]);
        logModel.setName(name+s[1]);
        //logModel.setName(name);
        repo.save(logModel);
	}
	
	public List<LogModel> logByDate(String date)
	{
		return repo.findByDate(date);
		
	}
	
	public List<LogModel> allLogs()
	{
		return repo.findAll();
	}
	
	
	
	

}
