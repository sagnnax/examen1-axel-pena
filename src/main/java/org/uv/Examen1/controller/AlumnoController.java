/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Examen1.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mxaxe
 */
@RestController
@RequestMapping("/api")
public class AlumnoController {
    @Autowired
    private RepositoryAlumno repositoryAlumno;
    
     @GetMapping("/msg")
    public String holaMundo() {
        return "hola mundo";
    }
    
       @GetMapping("/alumno/{id}")
    public DTOAlumno obteneAlumno(@PathVariable("id") long id){
        DTOAlumno alumno = null;
        if (id ==10){
        alumno = new DTOAlumno();
        alumno.setClave(10);
        alumno.setNombre("sag");
        alumno.setDireccion("Av 1");
        alumno.setTelefono("1234");
    }
       return alumno;
    }
    
     @GetMapping("/alumno")
     public List<DTOAlumno> obtenerTodosLosAlumnos(){
     List<DTOAlumno> lstAlumnos=new ArrayList<>();
     DTOAlumno alumn1 = new DTOAlumno();
        alumn1.setClave(10);
        alumn1.setNombre("Sag 2");
        alumn1.setDireccion("Av 1");
        alumn1.setTelefono("12345");
        
       
       lstAlumnos.add(alumn1);
        DTOAlumno alumn2= new DTOAlumno();
        alumn2.setClave(10);
        alumn2.setNombre("sagnax");
        alumn2.setDireccion("Av 1");
        alumn2.setTelefono("1234");
        lstAlumnos.add(alumn2);
        
        return lstAlumnos;
     }
     
     @PostMapping("/alumno")
     public DTOAlumno crearAlumno(@RequestBody DTOAlumno alumnoDTO){
         Alumno alumnoPojo = new Alumno();
         alumnoPojo.setNombre(alumnoDTO.getNombre());
         alumnoPojo.setDireccion(alumnoDTO.getDireccion());
         alumnoPojo.setTelefono(alumnoDTO.getTelefono());
         
         Alumno alumnoPojoNew=repositoryAlumno.save(alumnoPojo);
         
         DTOAlumno alumnoDTONew = new DTOAlumno();
         alumnoDTONew.setClave(alumnoPojoNew.getClave());
         alumnoDTONew.setNombre(alumnoPojoNew.getNombre());
         alumnoDTONew.setDireccion(alumnoPojoNew.getDireccion());
         alumnoDTONew.setTelefono(alumnoPojoNew.getTelefono());
                  
         //Se guardaria
         return alumnoDTONew;
     
     }
     
     @DeleteMapping("/alumno/{id}")
     public void borrarAlumno(@PathVariable Long id){
         //borrar
         return;
     }
    
    @PutMapping("/alumno/{id}") 
    public DTOAlumno modificarAlumno(@PathVariable("id") Long id,
        @RequestBody DTOAlumno empleado){
        //mapeo
        //buscar id
        //update
        return empleado;
    }
}
