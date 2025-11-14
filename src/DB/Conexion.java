
package DB;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author TRON2
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/escuela2?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = ""; // clave de la base de datos
    
     public static Connection getConnection() throws Exception 
     {
        // El driver se registra automáticamente con Connector/J 8+
        return DriverManager.getConnection(URL, USER, PASS);
     }
}
