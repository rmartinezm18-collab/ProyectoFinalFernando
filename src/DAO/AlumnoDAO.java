/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import MODELO.Alumno;
import java.util.List;

/**
 *
 * @author TRON2
 */
public interface AlumnoDAO 
{
    int insertar(Alumno a) throws Exception;
    int actualizar (Alumno a) throws Exception;
    int eliminar (int id) throws Exception;
    
    Alumno obtenerPorId(int id) throws Exception;
    List<Alumno> listar() throws Exception;
}
