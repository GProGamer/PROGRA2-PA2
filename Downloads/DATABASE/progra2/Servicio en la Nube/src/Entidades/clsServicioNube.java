/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author GAMER
 */
public class clsServicioNube {

      private int idServicio;
      private String nombre;
      private double precio;

      public clsServicioNube(String nombre, double precio) {

            this.nombre = nombre;
            this.precio = precio;
      }

      public clsServicioNube(int idServicio, String nombre, double precio) {
            this.idServicio = idServicio;
            this.nombre = nombre;
            this.precio = precio;
      }

      public int getIdServicio() {
            return idServicio;
      }

      public String getNombre() {
            return nombre;
      }

      public double getPrecio() {
            return precio;
      }

}
