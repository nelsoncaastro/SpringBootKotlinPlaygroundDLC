package com.uca.capas.crudthymeleaf.domain

import javax.persistence.*

@Entity
data class Student(
        @Id
        @GeneratedValue(generator="student_id_student_seq", strategy= GenerationType.AUTO)
        @SequenceGenerator(name="student_id_student_seq", sequenceName="public.student_id_student_seq", allocationSize=1)
        @Column(name = "id_student")
        var cStudent: Int = 0,

        @Column(name = "s_name")
        var sName: String = "",

        @Column(name = "s_lname")
        var lName: String = "",

        @Column(name = "s_age")
        var sAge: Int = 0,

        @Column(name = "b_active")
        var bActivo: Boolean = false
){
        override fun toString(): String = "User{id = $cStudent , name = $sName, last name = $lName, age = $sAge, isActive = $bActivo}"
}