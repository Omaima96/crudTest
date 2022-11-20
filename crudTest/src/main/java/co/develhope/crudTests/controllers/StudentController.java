package co.develhope.crudTests.controllers;


import co.develhope.crudTests.entities.Student;
import co.develhope.crudTests.repositories.StudentRepository;
import co.develhope.crudTests.services.StudentService;
import org.springframework.stereotype.Controller;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

        @Autowired
        private StudentRepository studentRepository;

        @Autowired
        private StudentService studentService;

        @PostMapping("")
        public @ResponseBody Student create(@RequestBody  Student student){
            return studentRepository.save(student);
        }

        @GetMapping("/")
        public @ResponseBody List<Student> getList(){
            return studentRepository.findAll();
        }

        @GetMapping("/{id}")
        public @ResponseBody  Student getSingle(@PathVariable long id){
            Optional<Student> student =  studentRepository.findById(id);
            if(student.isPresent()){
                return student.get();
            }else{
                return null;
            }
        }

        @PutMapping("/{id}")
        public @ResponseBody Student update(@PathVariable long id, @RequestBody  @NotNull Student student){
            student.setId(id);
            return studentRepository.save(student);
        }

        @PutMapping("/{id}/working")
        public @ResponseBody Student setStudentWorking(@PathVariable long id, @RequestParam("working") boolean working){
            return studentService.setStudentWorkingStatus(id, working);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable long id){
            studentRepository.deleteById(id);
        }


    }

