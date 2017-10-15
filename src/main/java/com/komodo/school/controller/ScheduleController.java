package com.komodo.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.komodo.school.handler.ScheduleHandler;
import com.komodo.school.model.Schedule;

@RestController
@RequestMapping("api/v1/schedule")
public class ScheduleController {

	@Autowired
	ScheduleHandler scheduleHandler;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Schedule> list(){
		return scheduleHandler.findAll();
	}
	
	@RequestMapping(value = "/class/{idClass}", method = RequestMethod.POST)
	public Schedule create(@RequestBody Schedule schedule, @PathVariable Long idClass){
		return scheduleHandler.save(schedule, idClass);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Schedule get(@PathVariable Long id){
		return scheduleHandler.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Schedule update(@PathVariable Long id, @RequestBody Schedule schedule){
		return scheduleHandler.update(id, schedule);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Schedule delete(@PathVariable Long id){
		return scheduleHandler.delete(id);
	}
}
