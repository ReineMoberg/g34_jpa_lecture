package se.lexicon.jpa.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpa.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository // same to @Component
//@Transactional
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Student create(Student student) {
        entityManager.persist(student); // persist = save or create
        return student;
    }

    @Override
    public Student findById(int studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public List<Student> findAll() {
        Query query = entityManager.createQuery("Select s from Student s");
        List<Student> result = query.getResultList();
        return result;
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        Query query = entityManager.createQuery("select s FROM Student s where s.firstName = :firstName");
        query.setParameter("firstName", firstName);
        List<Student> studentList = query.getResultList();
        return studentList;
    }

    @Override
    public void remove(int id) {
        Student student = findById(id);
        entityManager.remove(student); // remove = delete
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student); // merge = update
    }

    @Override
    @Transactional
    public List<Student> saveStudents(List<Student> students) {
        for (Student student : students) {
            create(student);
        }
        return students;
    }
}
