package com.uca.capas.crudthymeleaf.controller

import com.uca.capas.crudthymeleaf.domain.Student
import com.uca.capas.crudthymeleaf.repositories.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class StudentController {

    @Autowired
    lateinit var studentRepository: StudentRepository

    @GetMapping("/signup")
    fun showSignUpForm(student: Student) = "add-user"

    @PostMapping("/adduser")
    fun addUser(@Valid student: Student, result: BindingResult, model: Model) : String {
        if (result.hasErrors()) {
            return "add-user"
        }

        studentRepository.save(student)
        model.addAttribute("students", studentRepository.findAll())
        return "index"
    }

    @GetMapping("/edit/{id}")
    fun showUpdateForm(@PathVariable("id") id: Int, model: Model) : String {
        val student = studentRepository.findById(id)
                .orElseThrow { IllegalArgumentException("Invalid student Id: + $id") }
        model.addAttribute("student", student)
        return "update-user"
    }

    @PostMapping("/update/{id}")
    fun updateUser(@PathVariable("id") id: Int, @Valid student: Student, result: BindingResult, model: Model) : String {
        if (result.hasErrors()){
            student.cStudent = id
            return "update-user"
        }

        studentRepository.save(student)
        model.addAttribute("students", studentRepository.findAll())
        return "index"
    }

    @GetMapping("/delete/{id}")
    fun deleteuser(@PathVariable("id") id: Int, model: Model): String {
        val student = studentRepository.findById(id)
                .orElseThrow { IllegalArgumentException("Invalid student Id: $id") }

        studentRepository.delete(student)
        model.addAttribute("students", studentRepository.findAll())
        return "index"
    }

}