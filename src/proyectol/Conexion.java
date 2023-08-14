package proyectol;

/**
 *
 * @author Amado
 */

import java.sql.*;
import javax.swing.JOptionPane;

//Creando la conexion de la base de datos 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;




public class Conexion {
    private static Conexion instancia;
    private Connection conectar;

    private Conexion() {
        // Constructor privado para evitar la creación directa de instancias
    }
 // patron singleton 
    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/almacenitlafinal", "estuditlafinal", "itla1234");
        } catch (ClassNotFoundException u) {
            JOptionPane.showMessageDialog(null, "Conexion no encontrada " + u, "Estado de conexion", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexion Erronea " + e, "Estado de conexion", JOptionPane.ERROR_MESSAGE);
        }
        return conectar;
    }
}
