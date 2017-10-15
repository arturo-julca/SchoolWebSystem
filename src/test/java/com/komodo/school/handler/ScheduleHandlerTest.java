package com.komodo.school.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.komodo.school.configuration.TestPersistenceConfiguration;
import com.komodo.school.model.Building;
import com.komodo.school.model.ClassEd;
import com.komodo.school.model.Course;
import com.komodo.school.model.Room;
import com.komodo.school.model.Schedule;
import com.komodo.school.model.Semester;
import com.komodo.school.model.Teacher;
import com.komodo.school.util.RandomModelCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestPersistenceConfiguration.class})
public class ScheduleHandlerTest {

	@Autowired
	private ScheduleHandler scheduleHandler;
	
	@Autowired
	private ClassEdHandler classEdHandler;
	
	@Autowired
	private CourseHandler courseHandler;
	
	@Autowired
	private TeacherHandler teacherHandler;
	
	@Autowired
	private SemesterHandler semesterHandler;
	
	@Autowired
	private RoomHandler roomHandler;
	
	@Autowired
	private BuildingHandler buildingHandler;
	
	private ClassEd createClassEd(){
		Course courseCreated = courseHandler.save(RandomModelCreator.createCourse());
		Teacher teacherCreated = teacherHandler.save(RandomModelCreator.createTeacher());
		Semester semesterCreated = semesterHandler.save(RandomModelCreator.createSemester());
		Building buildingCreated = buildingHandler.save(RandomModelCreator.createBuilding());
		Room roomCreated = roomHandler.save(RandomModelCreator.createRoom(), buildingCreated.getId());
		ClassEd classEd = classEdHandler.save(RandomModelCreator.createClassEd(), courseCreated.getId(), teacherCreated.getId(), semesterCreated.getId(), roomCreated.getId());
		return classEd;
	}
	
	@Test
	public void testUpdate(){
		ClassEd classEd = createClassEd();
		Schedule created = scheduleHandler.save(RandomModelCreator.createSchedule(), classEd.getId());
		created.setDayOfTheWeek("tuesday");
		created.setHourStart(1);
		created.setHourEnd(2);
		created.setTypeClass(2);
		Schedule result = scheduleHandler.update(created.getId(), created);
		assertNotNull(result);
		assertEquals(result.getDayOfTheWeek(), created.getDayOfTheWeek());
		assertEquals(result.getHourStart(), created.getHourStart());
		assertEquals(result.getHourEnd(), created.getHourEnd());
		assertEquals(result.getTypeClass(), created.getTypeClass());
	}

	
	@Test
	public void testSave(){
		ClassEd classEd = createClassEd();
		Schedule created = RandomModelCreator.createSchedule();
		Schedule result = scheduleHandler.save(created, classEd.getId());
		assertNotNull(result);
		assertNotNull(result.getId());
		assertEquals(result.getDayOfTheWeek(), created.getDayOfTheWeek());
		assertEquals(result.getHourStart(), created.getHourStart());
		assertEquals(result.getHourEnd(), created.getHourEnd());
		assertEquals(result.getTypeClass(), created.getTypeClass());
	}
	
	@Test
	public void testFindAll(){
		scheduleHandler.save(RandomModelCreator.createSchedule(), createClassEd().getId());
		List<Schedule> listRoom = scheduleHandler.findAll();
		assertNotNull(listRoom);
		assertTrue(!listRoom.isEmpty());
	}
	
	@Test
	public void testFindOne(){
		Schedule created = RandomModelCreator.createSchedule();
		Schedule saved = scheduleHandler.save(created, createClassEd().getId());
		Schedule result = scheduleHandler.findOne(saved.getId());
		assertNotNull(result);
		assertNotNull(result.getId());
		assertEquals(result.getDayOfTheWeek(), created.getDayOfTheWeek());
		assertEquals(result.getHourStart(), created.getHourStart());
		assertEquals(result.getHourEnd(), created.getHourEnd());
		assertEquals(result.getTypeClass(), created.getTypeClass());
	}
	
	@Test
	public void testDelete(){
		Schedule saved = scheduleHandler.save(RandomModelCreator.createSchedule(), createClassEd().getId());
		scheduleHandler.delete(saved.getId());
		Schedule result = scheduleHandler.findOne(saved.getId());
		assertNull(result);
	}
}
