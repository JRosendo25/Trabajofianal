package proyectol;

import Formularios.registroalmacen;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPasswordField;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.sql.Statement;



public class usuarios

// atributos de la clase con sus get y set
{
    String usuario;
    String nombre;
    String apellido;
    String email;
    String telefono; 
    String contra;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
  
    
    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getContra() {
        return contra;
    }
    
 
    

    
    //metodo para insertar datos a la tabla usuario 
    public void insertardatos2(JTextField insUsuario, JTextField insNombre, JTextField insApellido, JTextField insEmail, JTextField insTelefono, JPasswordField insContra) {
        
        setUsuario (insUsuario.getText());
        setNombre  (insNombre.getText());
        setApellido (insApellido.getText());
        setEmail (insEmail.getText());
        setTelefono (insTelefono.getText());
        setContra (insContra.getText());
        
         Conexion con = Conexion.getInstancia();
        String insertar = "Insert into usuarios(UserName,Nombre,Apellido,Telefono,Email,Password) VALUES(?,?,?,?,?,?)";
        
         if (usuario.isEmpty()) {
        JOptionPane.showMessageDialog(null,"El campo usuario está vacío" , "Error", JOptionPane.ERROR_MESSAGE);
            
        }
         
        if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(null,"El campo Nombre está vacío" , "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        if (apellido.isEmpty()) {
        JOptionPane.showMessageDialog(null,"El campo Apellido está vacío" , "Error", JOptionPane.ERROR_MESSAGE);
        }
       
        if (telefono.isEmpty()) {
        JOptionPane.showMessageDialog(null,"El campo Telefono está vacío" , "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if (email.isEmpty()) {
        JOptionPane.showMessageDialog(null,"El campo Email está vacío" , "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if (contra.isEmpty()) {
        JOptionPane.showMessageDialog(null,"El campo Contraseña está vacío" , "Error", JOptionPane.ERROR_MESSAGE);
        }
      
        
        try {
            CallableStatement cs = con.conectar().prepareCall(insertar);
            
            cs.setString(1, getUsuario());
            cs.setString(2, getNombre());
            cs.setString(3, getApellido());
            cs.setString(4, getTelefono());
            cs.setString(5, getEmail());
            cs.setString(6, getContra());
            
            cs.execute();
            JOptionPane.showMessageDialog(null , "Usuario creado exitosamente");
            
        } catch (Exception e){
          JOptionPane.showMessageDialog(null , "No se ha creado el usuario creado"+e.toString());  
        }
       
    
    }
     
   //metodo para verificar si las contraseñas son iguales 
    public boolean verificarCredenciales(JTextField lgnusuario, JPasswordField lgncontra) {

    try {
       Conexion con = Conexion.getInstancia();
        String sql = "SELECT * FROM usuarios WHERE UserName = ? AND Password = ?";
        
        PreparedStatement ps = con.conectar().prepareStatement(sql);
        ps.setString(1, lgnusuario.getText()); // Obtén el usuario del campo de entrada
        ps.setString(2, lgncontra.getText());  // Obtén la contraseña del campo de entrada
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Usuario correctamente insertado ");
            
             registroalmacen r = new registroalmacen();
            r.setVisible(true);
            
            
            return true;
        } else {
            // Si no encontró un resultado, las credenciales son incorrectas
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
            return false;
        }
    } catch (Exception e) {
        // Manejo de excepciones
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error en la verificación de credenciales");
        return false;
      
         }
    
    
}
    //metodo para cambiar contraseña
   public void cambiarContra(JTextField insusuario, JPasswordField insContraActual, JPasswordField insNuevaContra, JPasswordField insConfirmarNuevaContra) {
    String usuario = insusuario.getText();
    String contraActual = new String(insContraActual.getPassword());
    String nuevaContra = new String(insNuevaContra.getPassword());
    String confirmarNuevaContra = new String(insConfirmarNuevaContra.getPassword());

    // Realizar verificaciones y validaciones necesarias
    if (contraActual.isEmpty() || nuevaContra.isEmpty() || confirmarNuevaContra.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Todos los campos son requeridos", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (!nuevaContra.equals(confirmarNuevaContra)) {
        JOptionPane.showMessageDialog(null, "Las contraseñas nuevas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Conexion con = Conexion.getInstancia();
    String actualizar = "UPDATE usuarios SET Password = ? WHERE UserName = ?";

    try {
        PreparedStatement ps = con.conectar().prepareStatement(actualizar);
        ps.setString(1, nuevaContra);
        ps.setString(2, usuario);
        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Contraseña cambiada exitosamente");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cambiar la contraseña: " + e.getMessage());
        e.printStackTrace();
    } finally {
        try {
            con.conectar().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    //usar la tabla para ver los usuarios de la base de datos
   public void VerUsuarios(JTable slttablaUsuarios) {
    Conexion con = Conexion.getInstancia();
    String verUsuarios = "SELECT * FROM usuarios"; 
    
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("idUser");
    modelo.addColumn("UserName");
    modelo.addColumn("Nombre");
    modelo.addColumn("Apellido");
    modelo.addColumn("Telefono");
    modelo.addColumn("Email");
    modelo.addColumn("Password"); 
    
    slttablaUsuarios.setModel(modelo);

    String[] datos = new String[7];
    Statement st;

    try {
        st = con.conectar().createStatement();
        ResultSet rs = st.executeQuery(verUsuarios);

        while (rs.next()) {
            datos[0] = rs.getString("idUser");
            datos[1] = rs.getString("UserName");
            datos[2] = rs.getString("Nombre");
            datos[3] = rs.getString("Apellido");
            datos[4] = rs.getString("Telefono");
            datos[5] = rs.getString("Email");
            datos[6] = rs.getString("Password");
            
            modelo.addRow(datos);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Fallo al alcanzar la base de datos");
    }
}

   //actualizar los datos cada vez que se realize una accion 
public void actualizarTablaUsuarios(JTable slttablaUsuarios) {
    DefaultTableModel modelo = (DefaultTableModel) slttablaUsuarios.getModel();
    modelo.setRowCount(0);

    String verUsuarios = "SELECT * FROM usuarios"; // Cambiar la consulta SQL según la estructura de tu base de datos de usuarios
   Conexion con = Conexion.getInstancia();

    try {
        Statement st = con.conectar().createStatement();
        ResultSet rs = st.executeQuery(verUsuarios);

        while (rs.next()) {
            String[] datos = {
            
            rs.getString("idUser"),
            rs.getString("UserName"),
            rs.getString("Nombre"),
            rs.getString("Apellido"),
            rs.getString("Telefono"),
            rs.getString("Email"),
            rs.getString("Password"),
            
            };
            
            modelo.addRow(datos);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Fallo al alcanzar la base de datos");
    }
}
 
//metodo que al clickear una fila se ponen los valores de la fila a los textfield 
public void SeleccionarUsuario(JTable sltRegistrodealmacen,JTextField insidUsuario,JTextField insUser , JTextField insNombreU, JTextField insApellidoU, JTextField insTelefonoU, JTextField insEmailU, JTextField insContrasenaU) {
    try {
        int fila = sltRegistrodealmacen.getSelectedRow();
        if (fila >= 0) {
            insidUsuario.setText(sltRegistrodealmacen.getValueAt(fila, 0).toString());
            insUser.setText(sltRegistrodealmacen.getValueAt(fila, 1).toString());
            insNombreU.setText(sltRegistrodealmacen.getValueAt(fila, 2).toString());
            insApellidoU.setText(sltRegistrodealmacen.getValueAt(fila, 3).toString());
            insTelefonoU.setText(sltRegistrodealmacen.getValueAt(fila, 4).toString());
            insEmailU.setText(sltRegistrodealmacen.getValueAt(fila, 5).toString());
            insContrasenaU.setText(sltRegistrodealmacen.getValueAt(fila, 6).toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay fila seleccionada");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al seleccionar fila: " + e.toString());
    }
}

//este se encarga de borrar los usuarios 
public void BorrarUsuario(JTextField DltidUsuario,JTable sltRegistrodealmacen ) {
    try {
        String username = DltidUsuario.getText(); // Convertir el texto a un string
        Conexion con = Conexion.getInstancia();
        String eliminar = "DELETE FROM usuarios WHERE UserName = ?";

        PreparedStatement ps = con.conectar().prepareStatement(eliminar);
        ps.setString(1, username);

        int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");
            actualizarTablaUsuarios(sltRegistrodealmacen);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el usuario con el nombre de usuario especificado", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Nombre de usuario no válido", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el usuario" + e.toString());
    }
}

       
    //con este se insertan datos en el formulario de registrousuarios
    public void insertardatos(JTextField insUsuario, JTextField insNombre,JTextField insApellido, JTextField insEmail, JTextField insTelefono,JPasswordField  insContra, JPasswordField insComfimarContra) {
        
        setUsuario (insUsuario.getText());
        setNombre  (insNombre.getText());
        setApellido (insApellido.getText());
        setEmail (insEmail.getText());
        setTelefono (insTelefono.getText());
        setContra (insContra.getText());
        
         Conexion con = Conexion.getInstancia();
        String insertar = "Insert into usuarios(UserName,Nombre,Apellido,Telefono,Email,Password) VALUES(?,?,?,?,?,?)";
        
         if (usuario.isEmpty()) {
        JOptionPane.showMessageDialog(null,"El campo usuario está vacío" , "Error", JOptionPane.ERROR_MESSAGE);
            
        }
         
        if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(null,"El campo Nombre está vacío" , "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        if (apellido.isEmpty()) {
        JOptionPane.showMessageDialog(null,"El campo Apellido está vacío" , "Error", JOptionPane.ERROR_MESSAGE);
        }
       
        if (telefono.isEmpty()) {
        JOptionPane.showMessageDialog(null,"El campo Telefono está vacío" , "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if (email.isEmpty()) {
        JOptionPane.showMessageDialog(null,"El campo Email está vacío" , "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if (contra.isEmpty()) {
        JOptionPane.showMessageDialog(null,"El campo Contraseña está vacío" , "Error", JOptionPane.ERROR_MESSAGE);
        }
        
       if (!getContra().equals(new String(insComfimarContra.getPassword()))) {
        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
            
        return; 
        }
        
      
        
        try {
            CallableStatement cs = con.conectar().prepareCall(insertar);
            
            cs.setString(1, getUsuario());
            cs.setString(2, getNombre());
            cs.setString(3, getApellido());
            cs.setString(4, getTelefono());
            cs.setString(5, getEmail());
            cs.setString(6, getContra());
            
            cs.execute();
            JOptionPane.showMessageDialog(null , "Usuario creado exitosamente");
            
        } catch (Exception e){
          JOptionPane.showMessageDialog(null , "No se ha creado el usuario creado"+e.toString());  
        }
       
    
    }
}



    

    
   