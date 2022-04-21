/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import Entidades.clsServicioNube;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author GAMER
 */
public class clsServicioNubeAD {

      public void agregar(clsServicioNube obj) {
            Connection con = null;
            String sentencia = "INSERT INTO Servicios_Nube (nombre, precio) VALUES('" + obj.getNombre() + "', " + obj.getPrecio() + ")";

            try {
                  con = Conexion.getConexion();
                  PreparedStatement pstm = con.prepareStatement(sentencia);
                  pstm.execute();

            } catch (Exception e) {
                  System.out.println(e);

            }
      }

      public void modificar(clsServicioNube obj) {
            Connection con = null;
            String sentencia = "UPDATE Servicios_Nube SET nombre = '" + obj.getNombre() + "', precio =" + obj.getPrecio() + " WHERE idServicios = " + obj.getIdServicio();
            System.out.println(sentencia);
            try {
                  con = Conexion.getConexion();
                  PreparedStatement pstm = con.prepareStatement(sentencia);
                  pstm.execute();

            } catch (Exception e) {
                  System.out.println(e);

            }
      }

      public ArrayList<clsServicioNube> listado() {
            ArrayList<clsServicioNube> lista = new ArrayList();
            Connection con = null;
            ResultSet resultado = null;
            String sentencia = "SELECT * FROM Servicios_Nube";

            try {
                  con = Conexion.getConexion();
                  PreparedStatement pstm = con.prepareStatement(sentencia);
                  resultado = pstm.executeQuery();
                  // recorrer filas y columnas de regitros devueltos

                  while (resultado.next()) {
                        clsServicioNube servicio = new clsServicioNube(resultado.getInt("idServicios"), resultado.getString("nombre"), resultado.getDouble("precio"));
                        lista.add(servicio);
                  }
                  return lista;
            } catch (Exception e) {
                  System.out.println(e);
                  return null;
            }

      }

      public Double getPrecioServicioById(int serId) {
            Connection con = null;
            ResultSet resultado = null;
            String sentencia = "SELECT * FROM Servicios_Nube WHERE idServicios = '" + serId + "'";
            try {
                  con = Conexion.getConexion();
                  PreparedStatement pstm = con.prepareStatement(sentencia);
                  resultado = pstm.executeQuery();
                  // recorrer filas y columnas de regitros devueltos

                  if (resultado.next()) {
                        return resultado.getDouble("precio");
                  } else {
                        return 0.0;
                  }

            } catch (Exception e) {
                  System.out.println(e);
                  return 0.0;
            }
      }

      public int getServicioIdByNombre(String nombreServicio) {
            Connection con = null;
            ResultSet resultado = null;
            String sentencia = "SELECT * FROM Servicios_Nube WHERE nombre = '" + nombreServicio + "'";
            try {
                  con = Conexion.getConexion();
                  PreparedStatement pstm = con.prepareStatement(sentencia);
                  resultado = pstm.executeQuery();
                  // recorrer filas y columnas de regitros devueltos

                  if (resultado.next()) {
                        return resultado.getInt("idServicios");
                  } else {
                        return 0;
                  }

            } catch (Exception e) {
                  System.out.println(e);
                  return 0;
            }
      }

      public String getNombreServicioByServicioId(int servicioId) {
            Connection con = null;
            ResultSet resultado = null;
            String sentencia = "SELECT * FROM Servicios_Nube WHERE idServicios = '" + servicioId + "'";
            try {
                  con = Conexion.getConexion();
                  PreparedStatement pstm = con.prepareStatement(sentencia);
                  resultado = pstm.executeQuery();
                  // recorrer filas y columnas de regitros devueltos

                  if (resultado.next()) {
                        return resultado.getString("nombre");
                  } else {
                        return null;
                  }

            } catch (Exception e) {
                  System.out.println(e);
                  return null;
            }
      }

      public ArrayList<String> mostrarServicio() {
            ArrayList<String> servicios = new ArrayList();
            Connection con = null;
            ResultSet resultado = null;
            String sentencia = "SELECT * FROM Servicios_Nube";

            try {
                  con = Conexion.getConexion();
                  PreparedStatement pstm = con.prepareStatement(sentencia);
                  resultado = pstm.executeQuery();
                  // recorrer filas y columnas de regitros devueltos

                  while (resultado.next()) {
                        String servicio = resultado.getString("nombre");
                        servicios.add(servicio);
                  }
                  return servicios;
            } catch (Exception e) {
                  System.out.println(e);
                  return null;
            }
      }
}
