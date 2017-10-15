package com.komodo.school.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.komodo.school.model.ClassEd;
import com.komodo.school.model.Schedule;
import com.komodo.school.repository.ClassEdRepository;
import com.komodo.school.repository.ScheduleRepository;
import com.komodo.school.util.ControllerUtil;

@Component
public class ScheduleHandler{

	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Autowired
	ClassEdRepository classEdRepository;
	
	public Schedule save(Schedule schedule, Long idClass){
		ClassEd classEd = classEdRepository.getOne(idClass);
		schedule.setClassEd(classEd);
		return scheduleRepository.saveAndFlush(schedule);
	}
	
	public List<Schedule> findAll(){
		return scheduleRepository.findAll();
	}
	
	public Schedule findOne(Long idSchedule){
		return scheduleRepository.findOne(idSchedule);
	}
	
	public Schedule update(Long idSchedule, Schedule schedule){
		return (Schedule) ControllerUtil.update(scheduleRepository, schedule, idSchedule);
	}
	
	public Schedule delete(Long idSchedule){
		return (Schedule) ControllerUtil.delete(scheduleRepository, idSchedule);
	}
}
