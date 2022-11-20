package co.develhope.crudTests.services;

import co.develhope.crudTests.entities.Student;
import co.develhope.crudTests.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//il service mischia il Repository(collega al database) con la logica di business

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student setStudentWorkingStatus(Long studentId, boolean isWorking){
        Optional<Student> student = studentRepository.findById(studentId);
        if(!student.isPresent()) return null;
       student.get().setWorking(isWorking);
        return studentRepository.save(student.get());
    }

}

