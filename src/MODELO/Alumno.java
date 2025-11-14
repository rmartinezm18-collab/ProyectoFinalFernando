/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author TRON2
 */
public class Alumno {
    private Integer id;
    private String nombre;
    private String email;
    private Integer edad;
    
 public Alumno() {}
 
 //cuando el Alumno sea nuevo
    public Alumno(Integer id, String nombre, String email, Integer edad) {
        this.id = id; this.nombre = nombre; this.email = email; this.edad = edad;
    }
    
    //cuando el alumno ya exista
    public Alumno(String nombre, String email, Integer edad) {
        this(null, nombre, email, edad);
    }   
    
    
    //nuestra propiedades
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }
    
}
