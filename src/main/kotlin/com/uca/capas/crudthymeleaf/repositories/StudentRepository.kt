package com.uca.capas.crudthymeleaf.repositories

import com.uca.capas.crudthymeleaf.domain.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CrudRepository<Student, Int> {
    fun findBySName(sName: String): List<Student>
}