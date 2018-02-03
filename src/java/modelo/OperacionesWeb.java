package modelo;

import java.sql.*;
import java.util.*;
import javabeans.*;
import javax.sql.DataSource;

public class OperacionesWeb {
    private String url;
    DataSource ds;
    PreparedStatement pstModificar;
    PreparedStatement pstEliminar;
    PreparedStatement pstInsertar;

    public OperacionesWeb(String url) {
        //this.url=url;
        this.url = "jdbc:mysql://localhost:3306/favoritos?user=root&password=adminadmin";
    }

    public OperacionesWeb(DataSource ds) {
        try {
            this.ds = ds;
            Connection cn = this.getConnection();
            pstModificar = cn.prepareStatement("UPDATE webs SET "
                    + "fecha_inserccion=?, direccion_website=?, nombre_website=?, "
                    + "categoria=?, subcategoria=?, puntuacion=?, idioma=? WHERE id=?;");
            pstEliminar = cn.prepareStatement("Delete from webs where id=?");
            pstInsertar = cn.prepareStatement("Insert into webs values(?,?,?,?,?,?,?,?)");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificaWeb(Web c){
        try {
            pstModificar.setString(1, c.getFecha_inserccion());
            pstModificar.setString(2, c.getDireccion_website());
            pstModificar.setString(3, c.getNombre_website());
            pstModificar.setString(4, c.getCategoria());
            pstModificar.setString(5, c.getSubcategoria());
            pstModificar.setInt(6, c.getPuntuacion());
            pstModificar.setString(7, c.getIdioma());
            pstModificar.setInt(8, c.getId());
            pstModificar.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminaWeb(Web c){
        try {
            pstEliminar.setInt(1, c.getId());
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

    public ArrayList obtenerWebs() {
        Connection cn = null;
        ArrayList webs = null;
        Statement st;
        ResultSet rs;
        try {
            cn = getConnection();
            st = cn.createStatement();
            String tsql;
            tsql = "select * from webs order by direccion_website,nombre_website";
            rs = st.executeQuery(tsql);
            webs = new ArrayList();
            //para cada registro encontrado crea un objeto Contacto y lo añade a la coleccion ArrayList
            while (rs.next()) {
                Web m = new Web(rs.getInt("id"), rs.getString("fecha_inserccion"), rs.getString("direccion_website"),
                        rs.getString("nombre_website"), rs.getString("categoria"), rs.getString("subcategoria"),
                        rs.getInt("puntuacion"),
                        rs.getString("idioma"));
                webs.add(m);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webs;
    }

    public void insertaWeb(Web c){
        try {
            pstInsertar.setInt(1,    c.getId());
            pstInsertar.setString(2, c.getFecha_inserccion());
            pstInsertar.setString(3, c.getDireccion_website());
            pstInsertar.setString(4, c.getNombre_website());
            pstInsertar.setString(5, c.getCategoria());
            pstInsertar.setString(6, c.getSubcategoria());
            pstInsertar.setInt(7,    c.getPuntuacion());
            pstInsertar.setString(8, c.getIdioma());
            pstInsertar.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void grabaWeb(Web c) {
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
            tsql = "Insert into webs values('";
            tsql += c.getId() + "','" + c.getFecha_inserccion()+ "','" + c.getDireccion_website()+ "','" + c.getNombre_website()+ "','"
                    + c.getCategoria()+ "','" + c.getSubcategoria()+ "','" + c.getPuntuacion()+ "','" + c.getIdioma()+ "')";
            st.execute(tsql);
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
