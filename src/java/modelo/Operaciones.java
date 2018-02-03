package modelo;

import java.sql.*;
import java.util.*;
import javabeans.*;
import javax.sql.DataSource;

public class Operaciones {
    private String url;
    DataSource ds;
    PreparedStatement pstModificar;
    PreparedStatement pstEliminar;
    PreparedStatement pstInsertar;

    public Operaciones(String url) {
        //this.url=url;
        this.url = "jdbc:mysql://localhost:3306/favoritos?user=root&password=root";
    }

    public Operaciones(DataSource ds) {
        try {
            this.ds = ds;
            Connection cn = this.getConnection();
            pstModificar = cn.prepareStatement("Update clientes set nombres=?,apellido1=?,"
                    + "apellido2=?,direccion=?,telefono=?,celular=?,email=? where id=?");
            pstEliminar = cn.prepareStatement("Delete from clientes where id=?");
            pstInsertar = cn.prepareStatement("Insert into clientes values(?,?,?,?,?,?,?,?)");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificaContacto(Contacto c){
        try {
            pstModificar.setString(1, c.getNombre());
            pstModificar.setString(2, c.getApellido1());
            pstModificar.setString(3, c.getApellido2());
            pstModificar.setString(4, c.getDireccion());
            pstModificar.setString(5, c.getTelefono());
            pstModificar.setString(6, c.getCelular());
            pstModificar.setString(7, c.getEmail());
            pstModificar.setString(8, c.getId());
            pstModificar.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void eliminaContacto(Contacto c){
        try {
            pstEliminar.setString(1, c.getId());
            pstEliminar.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Connection getConnection() {
        Connection cn = null;
        try {
//      Class.forName("com.mysql.jdbc.Driver").newInstance();
//      cn=DriverManager.getConnection(this.url);
            cn = this.ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }

    public ArrayList obtenerContactos() {
        Connection cn = null;
        ArrayList contactos = null;
        Statement st;
        ResultSet rs;
        try {
            cn = getConnection();
            st = cn.createStatement();
            String tsql;
            tsql = "select * from clientes order by apellido1,apellido2";
            rs = st.executeQuery(tsql);
            contactos = new ArrayList();
            //para cada registro encontrado crea un objeto Contacto y lo añade a la coleccion ArrayList
            while (rs.next()) {
                Contacto m = new Contacto(rs.getString("Id"), rs.getString("nombres"), rs.getString("apellido1"),
                        rs.getString("apellido2"), rs.getString("Direccion"), rs.getString("Telefono"), 
                        rs.getString("Celular"),
                        rs.getString("Email"));
                contactos.add(m);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactos;
    }
  
    public void insertaContacto(Contacto c){
        try {
            pstInsertar.setString(1, c.getId());
            pstInsertar.setString(2, c.getNombre());
            pstInsertar.setString(3, c.getApellido1());
            pstInsertar.setString(4, c.getApellido2());
            pstInsertar.setString(5, c.getDireccion());
            pstInsertar.setString(6, c.getTelefono());
            pstInsertar.setString(7, c.getCelular());
            pstInsertar.setString(8, c.getEmail());
            pstInsertar.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void grabaContacto(Contacto c) {
        Connection cn;
        Statement st;
        //ResultSet rs;
        try {
            cn = getConnection();
            st = cn.createStatement();
            String tsql;
      //a partir de los datos del mensaje construye
            //la cadena SQL para realizar su inseri�n
            // Insert into clientes values(?,?,?,?,?,?,?,?)
            tsql = "Insert into clientes values('";
            tsql += c.getId() + "','" + c.getNombre() + "','" + c.getApellido1() + "','" + c.getApellido2() + "','"
                    + c.getDireccion() + "','" + c.getTelefono() + "','" + c.getCelular() + "','" + c.getEmail() + "')";
            st.execute(tsql);
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
