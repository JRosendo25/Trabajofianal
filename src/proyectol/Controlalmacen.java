/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectol;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;


/**
 *
 * @author Amado
 */

//aqui se declaran los campos para el control almacen junto con sus get y sets
public class Controlalmacen {
    
    private int    idProducto;
    private String NombreP;
    private String MarcaP;
    private String CategoriaP;
    private double PrecioP;
    private int    StockP; 

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreP() {
        return NombreP;
    }

    public void setNombreP(String NombreP) {
        this.NombreP = NombreP;
    }

    public String getMarcaP() {
        return MarcaP;
    }

    public void setMarcaP(String MarcaP) {
        this.MarcaP = MarcaP;
    }

    public String getCategoriaP() {
        return CategoriaP;
    }

    public void setCategoriaP(String CategoriaP) {
        this.CategoriaP = CategoriaP;
    }

    public double getPrecioP() {
        return PrecioP;
    }

    public void setPrecioP(double PrecioP) {
        this.PrecioP = PrecioP;
    }

    public int getStockP() {
        return StockP;
    }

    public void setStockP(int StockP) {
        this.StockP = StockP;
    }

//con este metodo se visualiza todo los productos de la tabla productos2
    
    public void Verproducto (JTable sltRegistrodealmacen){
        
    Conexion con = Conexion.getInstancia();
    String VerRegistro = "SELECT * FROM productos2";

    DefaultTableModel registro = new DefaultTableModel();
    registro.addColumn("idProducto");
    registro.addColumn("NombreProducto");
    registro.addColumn("MarcaProducto");
    registro.addColumn("CategoriaProducto");
    registro.addColumn("PrecioProducto");
    registro.addColumn("StockProducto");

    sltRegistrodealmacen.setModel(registro);

    String[] datos = new String[6];
    Statement st;

    try {
        st = con.conectar().createStatement();
        ResultSet rs = st.executeQuery(VerRegistro);

        while (rs.next()) {
            datos[0] = rs.getString("idProducto");
            datos[1] = rs.getString("NombreProducto");
            datos[2] = rs.getString("MarcaProducto");
            datos[3] = rs.getString("CategoriaProducto");
            datos[4] = rs.getString("PrecioProducto");
            datos[5] = rs.getString("StockProducto");
            
            registro.addRow(datos);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Fallo al alcanzar la base de datos");
    }
       
        
    }
    
    //con este metodo actualiza la vista que tenemos sobre la tabla cada vez que realizamos un cambio
    public void actualizarTabla(JTable sltRegistrodealmacen) {
    DefaultTableModel modelo = (DefaultTableModel) sltRegistrodealmacen.getModel();
    modelo.setRowCount(0); 

    String VerRegistro = "SELECT * FROM productos2";
    Conexion con = Conexion.getInstancia();

    try {
        PreparedStatement ps = con.conectar().prepareStatement(VerRegistro);
        ResultSet rs = ps.executeQuery(VerRegistro);

        while (rs.next()) {
            String[] datos = {
                rs.getString("IdProducto"),
                rs.getString("NombreProducto"),
                rs.getString("MarcaProducto"),
                rs.getString("CategoriaProducto"),
                rs.getString("PrecioProducto"),
                rs.getString("StockProducto")
            };
            
            modelo.addRow(datos);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Fallo al alcanzar la base de datos");
    }
}
    //aqui insertamos los datos que tenemos en los textfield 
    public void insertardatos(JTextField insNombreP, JTextField insMarcaP,JTextField insCategoriaP, JTextField insPrecioP, JTextField insStockP, JTable sltRegistrodealmacen) {
    setNombreP(insNombreP.getText());
    setMarcaP(insMarcaP.getText());
    setCategoriaP(insCategoriaP.getText());
    PrecioP = Double.parseDouble(insPrecioP.getText());
    StockP = Integer.parseInt(insStockP.getText());  
         
    Conexion con = Conexion.getInstancia();
     String insertar = "Insert into productos2 (NombreProducto,MarcaProducto,CategoriaProducto,PrecioProducto,StockProducto) VALUES(?,?,?,?,?)";
     
//aqui se ponen condiciones que si algunos de los campos estan vacios que salga un mensaje que te diga que los tienes que llegar

    if (NombreP.isEmpty()) {
        JOptionPane.showMessageDialog(null,"Introduzca el nombre del producto" , "Error", JOptionPane.ERROR_MESSAGE);
            
        }
         
    if (MarcaP.isEmpty()) {
        JOptionPane.showMessageDialog(null,"Introduzca la marca del producto" , "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    if (CategoriaP.isEmpty()) {
        JOptionPane.showMessageDialog(null,"Introduzca la Categoria del producto" , "Error", JOptionPane.ERROR_MESSAGE);
        }  
    if (PrecioP <  0) {
        JOptionPane.showMessageDialog(null,"Indique el precio del producto la cantidad que queda en el stock" , "Error", JOptionPane.ERROR_MESSAGE);
        }  
    if (StockP <  0) {
        JOptionPane.showMessageDialog(null,"Indique la cantidad que queda en el stock" , "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
            CallableStatement cs = con.conectar().prepareCall(insertar);
            
            cs.setString(1,getNombreP());
            cs.setString(2,getMarcaP());
            cs.setString(3,getCategoriaP());
            cs.setDouble(4,getPrecioP());
            cs.setInt(5,getStockP());
            cs.execute();
            
            JOptionPane.showMessageDialog(null , "Producto agregado exitosamente");
            actualizarTabla(sltRegistrodealmacen);

                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null , "Error al añadir producto"+e.toString());
            
        }   
}
    //metodo que al clickear una fila se ponen los valores de la fila a los textfield 
   public void SeleccionarProducto(JTable sltRegistrodealmacen,JTextField insidProducto , JTextField insNombreP, JTextField insMarcaP, JTextField insCategoriaP, JTextField insPrecioP, JTextField insStockP) {
    try {
        int fila = sltRegistrodealmacen.getSelectedRow();
        if (fila >= 0) {
            insidProducto.setText(sltRegistrodealmacen.getValueAt(fila, 0).toString());
            insNombreP.setText(sltRegistrodealmacen.getValueAt(fila, 1).toString());
            insMarcaP.setText(sltRegistrodealmacen.getValueAt(fila, 2).toString());
            insCategoriaP.setText(sltRegistrodealmacen.getValueAt(fila, 3).toString());
            insPrecioP.setText(sltRegistrodealmacen.getValueAt(fila, 4).toString());
            insStockP.setText(sltRegistrodealmacen.getValueAt(fila, 5).toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay fila seleccionada");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al seleccionar fila: " + e.toString());
    }
}
    
   

    
    //aqui nosotros podemos cambiar los datos de la base de dato usando este metodo 
   
    public void EditarProducto( JTextField insNombreP, JTextField insMarcaP, JTextField insCategoriaP, JTextField insPrecioP, JTextField insStockP,JTextField IdProducto ,  JTable sltRegistrodealmacen ) {
    setNombreP(insNombreP.getText());
    setMarcaP(insMarcaP.getText());
    setCategoriaP(insCategoriaP.getText());
     PrecioP = Double.parseDouble(insPrecioP.getText());
    StockP = Integer.parseInt(insStockP.getText());  
    
   

    Conexion con = Conexion.getInstancia();
    String editar = "UPDATE productos2 SET NombreProducto = ?, MarcaProducto = ?, CategoriaProducto = ?, PrecioProducto = ?, StockProducto = ? WHERE idProducto = ? ";

        try {
    PreparedStatement ps = con.conectar().prepareStatement(editar);
    ps.setString(1, getNombreP());
    ps.setString(2, getMarcaP());
    ps.setString(3, getCategoriaP());
    ps.setDouble(4, getPrecioP());
    ps.setInt(5, getStockP());
    ps.setInt(6, getIdProducto());
    
    ps.executeUpdate();
    
    
    JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente");
    actualizarTabla(sltRegistrodealmacen);
    
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + e.getMessage());
    } 
        
}
   //borrar los productos de la tabla
    public void BorrarProducto(JTextField DltidProducto,JTable sltRegistrodealmacen ) {
    try {
        int idProducto = Integer.parseInt(DltidProducto.getText()); // Convertir el texto a un entero
        Conexion con = Conexion.getInstancia();
        String eliminar = "DELETE FROM productos2 WHERE idProducto = ?";

        PreparedStatement ps = con.conectar().prepareStatement(eliminar);
        ps.setInt(1, idProducto);

        int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");
            actualizarTabla(sltRegistrodealmacen);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el producto con el ID especificado", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "ID de producto no válido", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el producto" + e.toString());
    }
}

}
    
    
    

