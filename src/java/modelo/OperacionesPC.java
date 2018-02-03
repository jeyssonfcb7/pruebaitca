package modelo;

import java.sql.*;
import java.util.*;
import javabeans.*;
import javax.sql.DataSource;

public class OperacionesPC {
    private String url;
    DataSource ds;
    PreparedStatement pstModificar;
    PreparedStatement pstEliminar;
    PreparedStatement pstInsertar;

    public OperacionesPC(String url) {
        //this.url=url;
        this.url = "jdbc:mysql://localhost:3306/favoritos?user=root&password=root";
    }

    public OperacionesPC(DataSource ds) {
        try {
            this.ds = ds;
            Connection cn = this.getConnection();
            pstModificar = cn.prepareStatement("Update computadoras set marca=?,procesador=?,"
                    + "memoria=?,disco=?,memoria_video=?,descripcion=? where id=?");
            pstEliminar = cn.prepareStatement("Delete from computadoras where id=?");
            pstInsertar = cn.prepareStatement("Insert into computadoras values(?,?,?,?,?,?,?,?)");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificaCompu(Computadora c){
        try {
          
            pstModificar.setString(2, c.getMarca());
            pstModificar.setString(3, c.getProcesador());
            pstModificar.setInt(4, c.getMemoria());
            pstModificar.setString(5, c.getDisco());
            pstModificar.setInt(6, c.getMemoria_video());
            pstModificar.setString(7,c.getDescripcion());
            pstModificar.setInt(8, c.getId());
            pstModificar.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void eliminaCompu(Computadora c){
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

    public ArrayList obtenerCompu() {
        Connection cn = null;
        ArrayList computadoras = null;
        Statement st;
        ResultSet rs;
        try {
            cn = getConnection();
            st = cn.createStatement();
            String tsql;
            tsql = "select * from computadoras order by id,marca";
            rs = st.executeQuery(tsql);
            computadoras = new ArrayList();
            //para cada registro encontrado crea un objeto computadora y lo añade a la coleccion ArrayList
            while (rs.next()) {
                Computadora m = new Computadora(rs.getInt("id"), rs.getString("marca"), rs.getString("procesador"),
                        rs.getInt("memoria"), rs.getString("disco"), rs.getInt("memoria_video"), 
                        rs.getString("descripcion"));
                       
                computadoras.add(m);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return computadoras;
    }
  
    public void insertaCompu(Computadora c){
        try {
            pstInsertar.setInt(1, c.getId());
            pstInsertar.setString(2, c.getMarca());
            pstInsertar.setString(3, c.getProcesador());
            pstInsertar.setInt(5, c.getMemoria());
            pstInsertar.setString(6, c.getDisco());
            pstInsertar.setInt(7, c.getMemoria_video());
            pstInsertar.setString(8, c.getDescripcion());
            pstInsertar.executeUpdate();
        } catch (Exception e) {
        }
    }
    
  
}
