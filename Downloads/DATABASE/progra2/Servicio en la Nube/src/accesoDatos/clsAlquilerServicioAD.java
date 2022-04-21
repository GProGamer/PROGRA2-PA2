/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import Entidades.clsAlquilerServicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author GAMER
 */
public class clsAlquilerServicioAD {

    private void RegistrarDeuda(clsAlquilerServicio obj) {
        clsDetallePagoAD detallePago = new clsDetallePagoAD();

        detallePago.registrarDetallePago(obj);
    }

    private void ActualizarDeuda(clsAlquilerServicio obj) {
        clsDetallePagoAD detallePago = new clsDetallePagoAD();

        detallePago.actualizarDetallePago(obj);
    }

    private String getFechaFinal(String fechaInicial, int duracionMeses) {
        Connection con = null;
        ResultSet resultado = null;
        String sentencia = "SELECT DATE_ADD('" + fechaInicial + "', INTERVAL  " + duracionMeses + " MONTH) AS fechaFinal";
        try {
            con = Conexion.getConexion();
            PreparedStatement pstm = con.prepareStatement(sentencia);
            resultado = pstm.executeQuery();

            if (resultado.next()) {
                String f = resultado.getString("fechaFinal");
                System.out.println(f);
                return f;

            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void agregar(clsAlquilerServicio obj) {

        
        Connection con = null;
        String fechaFinal = getFechaFinal(obj.getFechaInicio(), obj.getTiempoDeServicio());
        String sentencia = String.format("INSERT INTO Alquiler_De_Servicio(tiempoServicio, fechaInicio,fechaFinal, servicio_id, Usuario_id) VALUES(%d,'%s', '%s', %d, %d)", obj.getTiempoDeServicio(), obj.getFechaInicio(), fechaFinal, obj.getServicio_id(), obj.getUsuario_id());
        ArrayList<clsAlquilerServicio> lista;
        try {
            con = Conexion.getConexion();
            PreparedStatement pstm = con.prepareStatement(sentencia);
            pstm.execute();
            
            lista = listado(obj.getUsuario_id());
            int idAlquiler = lista.get(lista.size()-1).getIdAlquiler();
            obj.setIdAlquiler(idAlquiler);
            RegistrarDeuda(obj);
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void modificar(clsAlquilerServicio obj) {
        Connection con = null;
        String fechaFinal = getFechaFinal(obj.getFechaInicio(), obj.getTiempoDeServicio());
        obj.setFechaFinal(fechaFinal);
        String sentencia = "UPDATE Alquiler_De_Servicio SET tiempoServicio = " + obj.getTiempoDeServicio() + ", fechaInicio = '" + obj.getFechaInicio() + "', fechaFinal = '" + fechaFinal + "', servicio_id = " + obj.getServicio_id() + " WHERE idAlquiler = " + obj.getIdAlquiler();
        System.out.println(sentencia);
        try {
            con = Conexion.getConexion();
            PreparedStatement pstm = con.prepareStatement(sentencia);
            pstm.execute();
            ActualizarDeuda(obj);
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public ArrayList<clsAlquilerServicio> listado(int user_id) {
        ArrayList<clsAlquilerServicio> lista = new ArrayList();
        Connection con = null;
        ResultSet resultado = null;
        String sentencia = "SELECT * FROM Alquiler_De_Servicio WHERE Usuario_id = '" + user_id + "'";

        try {
            con = Conexion.getConexion();
            PreparedStatement pstm = con.prepareStatement(sentencia);
            resultado = pstm.executeQuery();
            // recorrer filas y columnas de regitros devueltos

            while (resultado.next()) {
                clsAlquilerServicio servicio = new clsAlquilerServicio(resultado.getInt("idAlquiler"), resultado.getInt("tiempoServicio"), resultado.getString("fechaInicio"), resultado.getInt("servicio_id"), resultado.getInt("Usuario_id"));
                servicio.setFechaFinal(resultado.getString("fechaFinal"));
                lista.add(servicio);
            }
            return lista;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

}
