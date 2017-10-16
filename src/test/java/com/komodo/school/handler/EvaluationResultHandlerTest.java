package com.komodo.school.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
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
import com.komodo.school.model.EvaluationResult;
import com.komodo.school.model.Room;
import com.komodo.school.model.Semester;
import com.komodo.school.model.Student;
import com.komodo.school.model.Teacher;
import com.komodo.school.util.RandomModelCreator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestPersistenceConfiguration.class})
public class EvaluationResultHandlerTest {

	@Autowired
	private EvaluationHandler evaluationHandler;
	
	@Autowired
	private EvaluationResultHandler evaluationResultHandler;
	
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
	
	@Autowired
	private StudentHandler studentHandler;
	
	private Evaluation getSavedEvaluation(){
		Course courseCreated = courseHandler.save(RandomModelCreator.createCourse());
		Teacher teacherCreated = teacherHandler.save(RandomModelCreator.createTeacher());
		Semester semesterCreated = semesterHandler.save(RandomModelCreator.createSemester());
		Building buildingCreated = buildingHandler.save(RandomModelCreator.createBuilding());
		Room roomCreated = roomHandler.save(RandomModelCreator.createRoom(), buildingCreated.getId());
		ClassEd classEd = classEdHandler.save(RandomModelCreator.createClassEd(), courseCreated.getId(), teacherCreated.getId(), semesterCreated.getId(), roomCreated.getId());
		Evaluation evaluation = evaluationHandler.save(RandomModelCreator.createEvaluation(), classEd.getId());
		return evaluation;
	}
	
	private Student getSavedStudent(){
		return studentHandler.save(RandomModelCreator.createStudent());
	}
	
	@Test
	public void testSave(){
		EvaluationResult created = RandomModelCreator.createEvaluationResult();
		EvaluationResult saved = evaluationResultHandler.save(created, getSavedEvaluation().getId(), getSavedStudent().getId());
		assertNotNull(saved);
		assertNotNull(saved.getId());
		assertEquals(created.getScore(), saved.getScore());
	}
	
	@Test
	public void testFindAll(){
		evaluationResultHandler.save(RandomModelCreator.createEvaluationResult(), getSavedEvaluation().getId(), getSavedStudent().getId());
		List<EvaluationResult> listSaved = evaluationResultHandler.findAll();
		assertNotNull(listSaved);
		assertTrue(!listSaved.isEmpty());
	}
	
	@Test
	public void testFindOne(){
		EvaluationResult saved = evaluationResultHandler.save(RandomModelCreator.createEvaluationResult(), getSavedEvaluation().getId(), getSavedStudent().getId());
		EvaluationResult finded = evaluationResultHandler.findOne(saved.getId());
		assertNotNull(finded);
		assertNotNull(finded.getId());
		assertEquals(finded.getScore().intValue(), saved.getScore().intValue());
	}
	
	@Test
	public void testUpdate(){
		EvaluationResult saved = evaluationResultHandler.save(RandomModelCreator.createEvaluationResult(), getSavedEvaluation().getId(), getSavedStudent().getId());
		saved.setScore(new BigDecimal(15));
		EvaluationResult updated = evaluationResultHandler.update(saved.getId(), saved);
		assertNotNull(updated);
		assertEquals(saved.getScore().intValue(), updated.getScore().intValue());
	}
	
	@Test
	public void testDelete(){
		EvaluationResult saved = evaluationResultHandler.save(RandomModelCreator.createEvaluationResult(), getSavedEvaluation().getId(), getSavedStudent().getId());
		evaluationResultHandler.delete(saved.getId());
		EvaluationResult finded = evaluationResultHandler.findOne(saved.getId());
		assertNull(finded);
	}

}
