/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import Entidades.clsUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author GAMER
 */
public class clsUsuarioAD {

      public void agregar(clsUsuario obj) {
            Connection con = null;
            String sentencia = String.format("INSERT INTO Usuario(email, nombre, contrasena, telefono) VALUES('%s', '%s', '%s', '%s')", obj.getEmail(), obj.getNombre(), obj.getContraseña(), obj.getTelefono());
            try {
                  con = Conexion.getConexion();
                  PreparedStatement pstm = con.prepareStatement(sentencia);
                  pstm.execute();

            } catch (Exception e) {
                  System.out.println(e);

            }
      }

      public void modificar(clsUsuario obj) {
            Connection con = null;
            String sentencia = String.format("UPDATE Usuario SET nombre = '%s', email = '%s', contrasena = '%s', telefono = '%s' WHERE idUsuario = %d", obj.getNombre(), obj.getEmail(), obj.getContraseña(), obj.getTelefono(), obj.getIdUsuario());
            try {
                  con = Conexion.getConexion();
                  PreparedStatement pstm = con.prepareStatement(sentencia);
                  pstm.execute();

            } catch (Exception e) {
                  System.out.println(e);

            }
      }

      public ArrayList<clsUsuario> listado() {
            ArrayList<clsUsuario> lista = new ArrayList();
            Connection con = null;
            ResultSet resultado = null;
            String sentencia = "SELECT * FROM Usuario";

            try {
                  con = Conexion.getConexion();
                  PreparedStatement pstm = con.prepareStatement(sentencia);
                  resultado = pstm.executeQuery();
                  // recorrer filas y columnas de regitros devueltos

                  while (resultado.next()) {
                        clsUsuario usuario = new clsUsuario(resultado.getInt("idUsuario"), resultado.getString("email"), resultado.getString("nombre"), resultado.getString("contrasena"), resultado.getString("telefono"));
                        lista.add(usuario);
                  }
                  return lista;
            } catch (Exception e) {
                  System.out.println(e);
                  return null;
            }

      }

      public int getIdByEmail(String email) {
            Connection con = null;
            ResultSet resultado = null;
            String sentencia = "SELECT * FROM Usuario WHERE email = '" + email + "'";
            try {
                  con = Conexion.getConexion();
                  PreparedStatement pstm = con.prepareStatement(sentencia);
                  resultado = pstm.executeQuery();
                  // recorrer filas y columnas de regitros devueltos

                  if (resultado.next()) {
                        return resultado.getInt("idUsuario");
                  } else {
                        return 0;
                  }

            } catch (Exception e) {
                  System.out.println(e);
                  return 0;
            }
      }
}
