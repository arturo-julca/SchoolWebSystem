package com.komodo.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.komodo.school.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

}
