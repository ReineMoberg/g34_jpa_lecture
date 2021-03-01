package se.lexicon.jpa.dao;

import se.lexicon.jpa.entity.Student;

import java.util.List;

public interface StudentDao {
    // basic CRUD operations

    Student create(Student student);

    Student findById(int studentId);

    List<Student> findAll();

    List<Student> findByFirstName(String firstName);

    void remove(int id);

    Student update(Student student);

    List<Student> saveStudents(List<Student> students);
    //update status
    //...


}
