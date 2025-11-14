package SERVICIO;

import DAO.AlumnoDAO;
import DAO.impl.AlumnoDAOImpl;
import MODELO.Alumno;
import java.util.List;

/**
 *
 * @author TRON2
 */
public class AlumnoService {
    private final AlumnoDAO dao = new AlumnoDAOImpl();
    
    // Método para guardar un nuevo alumno
    public void guardarNuevo(String nombre, String email, int edad) throws Exception {
        if (nombre == null || nombre.isBlank()) 
            throw new IllegalArgumentException("Nombre requerido");
        dao.insertar(new Alumno(nombre, email, edad));
    }
    
    // Método para listar todos los alumnos
    public List<Alumno> listarTodos() throws Exception {
        AlumnoDAOImpl daoImpl = new AlumnoDAOImpl();
        return daoImpl.listar();
    }
    
    public void actualizarAlumno(int id, String nombre, String email, int edad) throws Exception {
    if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre requerido");
    dao.actualizar(new Alumno(id, nombre, email, edad));
    }

    public void eliminarAlumno(int id) throws Exception {
        dao.eliminar(id);
    }

}
