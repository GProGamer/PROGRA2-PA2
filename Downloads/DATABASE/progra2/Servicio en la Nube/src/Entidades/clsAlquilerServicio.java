/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author GAMER
 */
public class clsAlquilerServicio {

      private int idAlquiler;
      private int tiempoDeServicio;
      private String fechaInicio;
      private String fechaFinal;
      private int servicio_id;
      private int usuario_id;

      public clsAlquilerServicio(int tiempoDeServicio, String fechaInicio, int servicio_id, int usuario_id) {

            this.tiempoDeServicio = tiempoDeServicio;
            this.fechaInicio = fechaInicio;

            this.usuario_id = usuario_id;
            this.servicio_id = servicio_id;
      }

      public clsAlquilerServicio(int idAlquiler, int tiempoDeServicio, String fechaInicio, int servicio_id, int usuario_id) {
            this.idAlquiler = idAlquiler;
            this.tiempoDeServicio = tiempoDeServicio;
            this.fechaInicio = fechaInicio;

            this.usuario_id = usuario_id;
            this.servicio_id = servicio_id;
      }

      public int getIdAlquiler() {
            return idAlquiler;
      }

      public int getTiempoDeServicio() {
            return tiempoDeServicio;
      }

      public String getFechaInicio() {
            return fechaInicio;
      }

      public String getFechaFinal() {
            return fechaFinal;
      }

      public int getUsuario_id() {
            return usuario_id;
      }

      public int getServicio_id() {
            return servicio_id;
      }

      public void setFechaFinal(String ff) {
            this.fechaFinal = ff;
      }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }
      
      

}
