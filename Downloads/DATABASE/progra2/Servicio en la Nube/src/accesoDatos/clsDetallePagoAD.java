/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import Entidades.clsAlquilerServicio;
import Entidades.clsDetallePago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GAMER
 */
public class clsDetallePagoAD {

    private double getMontoAPagarPorServicio(int serId, int tiempoServicio) {
        clsServicioNubeAD servicioAD = new clsServicioNubeAD();
        double monto = servicioAD.getPrecioServicioById(serId) * tiempoServicio;
        return monto;
    }


    public void actualizarDetallePago(clsAlquilerServicio obj) {
        double montoPagarPorServicio = getMontoAPagarPorServicio(obj.getServicio_id(), obj.getTiempoDeServicio());
        Connection con = null;
        String sentencia = "UPDATE Detalles_De_Pago SET montoPagar = " + montoPagarPorServicio + ", Servicios_Nube_id =" + obj.getServicio_id() + " WHERE Alquiler_De_Servicio_id = " + obj.getIdAlquiler();
        try {
            con = Conexion.getConexion();
            PreparedStatement pstm = con.prepareStatement(sentencia);
            pstm.execute();

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void modificar(int idPago) {
        Connection con = null;
        String sentencia = "UPDATE Detalles_De_Pago SET Pagado = 'SI', fecha = NOW() WHERE idPago = " + idPago;
        try {
            con = Conexion.getConexion();
            PreparedStatement pstm = con.prepareStatement(sentencia);
            pstm.execute();

        } catch (Exception e) {
            System.out.println(e);

        }
    }
    
    public Double modificarTodo(int userId){
        Connection con = null;
        ResultSet resultado = null;
        String sentencia = "SELECT idPago, detalles_de_pago.Pagado, detalles_de_pago.montoPagar\n"
                + "FROM servicios_nube\n"
                + "     INNER JOIN alquiler_de_servicio\n"
                + "ON alquiler_de_servicio.servicio_id = servicios_nube.idServicios\n"
                + "     INNER JOIN detalles_de_pago\n"
                + "ON alquiler_de_servicio.idAlquiler = detalles_de_pago.Alquiler_De_Servicio_id\n"
                + "     INNER JOIN usuario\n"
                + "ON alquiler_de_servicio.Usuario_id = usuario.idUsuario\n"
                + "WHERE usuario.idUsuario =" + userId +" && detalles_de_pago.Pagado = 'NO'";

        try {
            con = Conexion.getConexion();
            PreparedStatement pstm = con.prepareStatement(sentencia);
            resultado = pstm.executeQuery();
            double montoTotal = 0; 
            while(resultado.next()){
                montoTotal += resultado.getDouble("detalles_de_pago.montoPagar");
                modificar(resultado.getInt("idPago"));
                
            }
            return montoTotal;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public void registrarDetallePago(clsAlquilerServicio obj) {

        double montoPagarPorServicio = getMontoAPagarPorServicio(obj.getServicio_id(), obj.getTiempoDeServicio());
        System.out.println(obj.getServicio_id() + " - " + obj.getIdAlquiler());
        Connection con = null;
        String sentencia = "INSERT INTO Detalles_De_Pago(montoPagar, Servicios_Nube_id, Alquiler_De_Servicio_id) VALUES( " + montoPagarPorServicio + ", " + obj.getServicio_id() + ", " + obj.getIdAlquiler() + ")";
        try {
            con = Conexion.getConexion();
            PreparedStatement pstm = con.prepareStatement(sentencia);
            pstm.execute();

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public ResultSet listado(int user_id) {

        Connection con = null;
        ResultSet resultado = null;
        String sentencia = "SELECT idPago, IFNULL(fecha, '-') AS fecha, usuario.nombre, servicios_nube.nombre, servicios_nube.precio, alquiler_de_servicio.tiempoServicio,detalles_de_pago.montoPagar, detalles_de_pago.Pagado\n"
                + "FROM servicios_nube\n"
                + "     INNER JOIN alquiler_de_servicio\n"
                + "ON alquiler_de_servicio.servicio_id = servicios_nube.idServicios\n"
                + "     INNER JOIN detalles_de_pago\n"
                + "ON alquiler_de_servicio.idAlquiler = detalles_de_pago.Alquiler_De_Servicio_id\n"
                + "     INNER JOIN usuario\n"
                + "ON alquiler_de_servicio.Usuario_id = usuario.idUsuario\n"
                + "WHERE usuario.idUsuario =" + user_id;

        try {
            con = Conexion.getConexion();
            PreparedStatement pstm = con.prepareStatement(sentencia);
            resultado = pstm.executeQuery();

            return resultado;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
