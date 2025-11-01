package com.example.accesdades.ra2.ac1.acess_dades.Controler;

import org.springframework.web.bind.annotation.RestController;

import com.example.accesdades.ra2.ac1.acess_dades.Model.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.accesdades.ra2.ac1.acess_dades.Repository.studentRepository;


@RestController
@RequestMapping("/api")
public class studentControler {

    @Autowired
    studentRepository studentRepository;


    @GetMapping("/students")
    //Retorna una llista de student
    public List<student> getStudent() {
        //Utiliza el métode findAll que esta en Respository i el retorna 
        return studentRepository.findAll();
    }

    @PostMapping("/students/batch")
    //Retorn un Strinf de Student 
    public String addStudent() {
        //Guarda el student segun el seu id 
        int numReg = studentRepository.save();
        return "has afegit " + numReg +" registre.";
    }

}
