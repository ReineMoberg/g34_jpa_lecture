package se.lexicon.jpa.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StudentTest {

    Student testObject;
    LocalDateTime currentDateTime;

    @BeforeEach
    public void setup() {
        currentDateTime = LocalDateTime.now();
        testObject = new Student(
                1,
                "Mehrdad",
                "Javan",
                "mehrdad.javan@lexicon.se",
                LocalDate.parse("2020-01-01"),
                false,
                currentDateTime);
    }

    @Test
    @DisplayName("Test 1: create student object")
    public void test_successfully_created(){
        Assertions.assertEquals(1,testObject.getStudentId());
        Assertions.assertEquals("Mehrdad",testObject.getFirstName());
        Assertions.assertEquals("Javan",testObject.getLastName());
        Assertions.assertEquals("mehrdad.javan@lexicon.se",testObject.getEmail());
    }

    @Test
    @DisplayName("Test 2: test equal method")
    public void test_equals(){
        Student expected = new Student(
                1,
                "Mehrdad",
                "Javan",
                "mehrdad.javan@lexicon.se",
                LocalDate.parse("2020-01-01"),
                false,
                currentDateTime);

        Student actual = testObject;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test 3: test hash codeof student object")
    public void test_hashCode(){
        Student expected = new Student(
                1,
                "Mehrdad",
                "Javan",
                "mehrdad.javan@lexicon.se",
                LocalDate.parse("2020-01-01"),
                false,
                currentDateTime);

        Student actual = testObject;
        Assertions.assertEquals(expected.hashCode(),actual.hashCode());

    }

}
