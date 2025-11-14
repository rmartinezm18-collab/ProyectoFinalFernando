/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import DAO.AlumnoDAO;
import DB.Conexion;
import MODELO.Alumno;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author TRON2
 */
public class AlumnoDAOImpl implements AlumnoDAO {

    @Override
    public int insertar(Alumno a) throws Exception {
    String sql = "INSERT INTO alumnos(nombre, email, edad) VALUES (?, ?, ?)";
    
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getEmail());
            ps.setInt(3, a.getEdad());
            
            int rows = ps.executeUpdate(); // donde se ejecuta mi consulta
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) a.setId(rs.getInt(1));
                }
            }
            return rows;
        }    
    
    }

    @Override
public int actualizar(Alumno a) throws Exception {
    String sql = "UPDATE alumnos SET nombre=?, email=?, edad=? WHERE id=?";
    
    try (Connection cn = Conexion.getConnection();
         PreparedStatement ps = cn.prepareStatement(sql)) {
        ps.setString(1, a.getNombre());
        ps.setString(2, a.getEmail());
        ps.setInt(3, a.getEdad());
        ps.setInt(4, a.getId());

        return ps.executeUpdate();
    }
}


    @Override
    public int eliminar(int id) throws Exception {
        String sql = "DELETE FROM alumnos WHERE id=?";
        try (Connection cn = Conexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }

    @Override
public Alumno obtenerPorId(int id) throws Exception {
    String sql = "SELECT id, nombre, email, edad FROM alumnos WHERE id = ?";
    try (Connection cn = Conexion.getConnection();
         PreparedStatement ps = cn.prepareStatement(sql)) {
        
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return new Alumno(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getInt("edad")
                );
            } else {
                return null; // no encontrado
            }
        }
    }
}


   @Override
public List<Alumno> listar() throws Exception {
    List<Alumno> lista = new ArrayList<>();
    String sql = "SELECT id, nombre, email, edad FROM alumnos";
    
    try (Connection cn = Conexion.getConnection();
         PreparedStatement ps = cn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            Alumno a = new Alumno(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("email"),
                rs.getInt("edad")
            );
            lista.add(a);
        }
    }
    return lista;
}

}
