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
import com.komodo.school.model.Evaluation;
import com.komodo.school.model.Room;
import com.komodo.school.model.Semester;
import com.komodo.school.model.Teacher;
import com.komodo.school.util.RandomModelCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestPersistenceConfiguration.class})
public class EvaluationHandlerTest {

	@Autowired
	private EvaluationHandler evaluationHandler;
	
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
	
	private ClassEd getSavedClassEd(){
		Course courseCreated = courseHandler.save(RandomModelCreator.createCourse());
		Teacher teacherCreated = teacherHandler.save(RandomModelCreator.createTeacher());
		Semester semesterCreated = semesterHandler.save(RandomModelCreator.createSemester());
		Building buildingCreated = buildingHandler.save(RandomModelCreator.createBuilding());
		Room roomCreated = roomHandler.save(RandomModelCreator.createRoom(), buildingCreated.getId());
		ClassEd classEd = classEdHandler.save(RandomModelCreator.createClassEd(), courseCreated.getId(), teacherCreated.getId(), semesterCreated.getId(), roomCreated.getId());
		return classEd;
	}
	
	@Test
	public void testSave(){
		Evaluation created = RandomModelCreator.createEvaluation();
		Evaluation saved = evaluationHandler.save(created, getSavedClassEd().getId());
		assertNotNull(saved);
		assertNotNull(saved.getId());
		assertEquals(created.getTypeEvaluation(), saved.getTypeEvaluation());
		assertEquals(created.getWeight(), saved.getWeight());
	}
	
	@Test
	public void testFindAll(){
		evaluationHandler.save(RandomModelCreator.createEvaluation(), getSavedClassEd().getId());
		List<Evaluation> listSaved = evaluationHandler.findAll();
		assertNotNull(listSaved);
		assertTrue(!listSaved.isEmpty());
	}
	
	@Test
	public void testFindOne(){
		Evaluation saved = evaluationHandler.save(RandomModelCreator.createEvaluation(), getSavedClassEd().getId());
		Evaluation finded = evaluationHandler.findOne(saved.getId());
		assertNotNull(finded);
		assertNotNull(finded.getId());
		assertEquals(finded.getTypeEvaluation(), saved.getTypeEvaluation());
		assertEquals(finded.getWeight(), saved.getWeight());
	}
	
	@Test
	public void testUpdate(){
		Evaluation saved = evaluationHandler.save(RandomModelCreator.createEvaluation(), getSavedClassEd().getId());
		saved.setTypeEvaluation(2);
		saved.setWeight(4);
		Evaluation updated = evaluationHandler.update(saved.getId(), saved);
		assertNotNull(updated);
		assertEquals(saved.getTypeEvaluation(), updated.getTypeEvaluation());
		assertEquals(saved.getWeight(), updated.getWeight());
	}
	
	@Test
	public void testDelete(){
		Evaluation saved = evaluationHandler.save(RandomModelCreator.createEvaluation(), getSavedClassEd().getId());
		evaluationHandler.delete(saved.getId());
		Evaluation finded = evaluationHandler.findOne(saved.getId());
		assertNull(finded);
	}

}
