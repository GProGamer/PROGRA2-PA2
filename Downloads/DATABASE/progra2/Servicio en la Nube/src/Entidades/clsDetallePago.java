/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author GAMER
 */
public class clsDetallePago {

      private int idPago;
      private String fecha;
      private double montoPagar;
      private int servicio_id;
      private int alquilerServicio_id;

      public clsDetallePago( String fecha, double montoPagar, int servicio_id, int alquilerServicio_id) {
            
            this.fecha = fecha;
            this.montoPagar = montoPagar;
            this.servicio_id = servicio_id;
            this.alquilerServicio_id = alquilerServicio_id;
      }
      
      public clsDetallePago(int idPago, String fecha, double montoPagar, int servicio_id, int alquilerServicio_id) {
            this.idPago = idPago;
            this.fecha = fecha;
            this.montoPagar = montoPagar;
            this.servicio_id = servicio_id;
            this.alquilerServicio_id = alquilerServicio_id;
      }

      public int getIdPago() {
            return idPago;
      }

      public String getFecha() {
            return fecha;
      }

      public double getMontoPagar() {
            return montoPagar;
      }

      public int getServicio_id() {
            return servicio_id;
      }

      public int getAlquilerServicio_id() {
            return alquilerServicio_id;
      }

}
