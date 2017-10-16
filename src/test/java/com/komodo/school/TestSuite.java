package com.komodo.school;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.komodo.school.handler.BuildingHandlerTest;
import com.komodo.school.handler.ClassEdHandlerTest;
import com.komodo.school.handler.CourseHandlerTest;
import com.komodo.school.handler.EvaluationHandlerTest;
import com.komodo.school.handler.EvaluationResultHandlerTest;
import com.komodo.school.handler.RoomHandlerTest;
import com.komodo.school.handler.ScheduleHandlerTest;
import com.komodo.school.handler.SemesterHandlerTest;
import com.komodo.school.handler.StudentHandlerTest;
import com.komodo.school.handler.TeacherHandlerTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   BuildingHandlerTest.class,
   ClassEdHandlerTest.class,
   CourseHandlerTest.class,
   EvaluationHandlerTest.class,
   EvaluationResultHandlerTest.class,
   RoomHandlerTest.class,
   ScheduleHandlerTest.class,
   SemesterHandlerTest.class,
   StudentHandlerTest.class,
   TeacherHandlerTest.class,
})


public class TestSuite {

}
