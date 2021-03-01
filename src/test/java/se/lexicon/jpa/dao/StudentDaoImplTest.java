package se.lexicon.jpa.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.jpa.entity.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentDaoImplTest {

    @Autowired
    StudentDao testObject;
    Student student1;

    @BeforeEach
    public void setup() {
        student1 = new Student("Mehrdad", "Javan", "mehrdad.javan@lxicon.se", LocalDate.parse("1989-01-01"), false, LocalDateTime.now());
    }

    //@Test
    @DisplayName("Test 1: test save student")
    public void test_save_student() {
        testObject.create(student1);
    }

    //@Test
    @DisplayName("Test 2: test find student by id")
    public void test_findById() {
        Student expected = testObject.create(student1);
        Student actual = testObject.findById(1);
        Assertions.assertEquals(expected, actual);
    }

    //@Test
    @DisplayName("Test 3: test save list of students")
    public void test_multiple_students(){
        List<Student> studentList= new ArrayList<>();
        Student student1 = new Student("Test1", "Test1", "test1@test.se", LocalDate.parse("1989-01-01"), false, LocalDateTime.now());
        Student student2 = new Student("Test2", "Test2", "test2@test.se", LocalDate.parse("1989-01-01"), false, LocalDateTime.now());
        Student student3 = new Student("Test3", "Test3", "test3@test.se", LocalDate.parse("1989-01-01"), false, LocalDateTime.now());
        //Student student4 = new Student(null, null, "test1@test.se", LocalDate.parse("1989-01-01"), false, LocalDateTime.now());
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        //studentList.add(student4);

        testObject.saveStudents(studentList);
    }

}
