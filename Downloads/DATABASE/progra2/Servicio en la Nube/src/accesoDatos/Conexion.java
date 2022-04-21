/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author GAMER
 */
public class Conexion {

    public static void main(String[] args) {
        getConexion();
    }

    public static Connection getConexion() {
        Connection con = null;
//            String usuario = "servicioNube";
//            String clave = "servicioNube";
        String usuario = "root";
        String clave = "";
        String url = "jdbc:mysql://localhost:3306/ALQUILER_DE_SERVICIOS_EN_NUBE";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, clave);
            System.out.println("conectado!!! :)");
        } catch (Exception e) {
            System.out.println("NO conectado :(");
        }
        return con;
    }
}
