package Entidades;

/**
 *
 * @author ivans
 */
public class clsUsuario {

      private int idUsuario;    
      private String email;          
      private String nombre;
      private String contraseña;
      private String telefono;              

      public clsUsuario(String email, String nombre, String contraseña, String telefono) {

            this.email = email;
            this.nombre = nombre;
            this.contraseña = contraseña;
            this.telefono = telefono;
      }

      public clsUsuario(int idUsuario, String email, String nombre, String contraseña, String telefono) {
            this.idUsuario = idUsuario;
            this.email = email;
            this.nombre = nombre;
            this.contraseña = contraseña;
            this.telefono = telefono;
      }

      public int getIdUsuario() {
            return idUsuario;
      }

      public String getEmail() {
            return email;
      }

      public String getNombre() {
            return nombre;
      }

      public String getContraseña() {
            return contraseña;
      }

      public String getTelefono() {
            return telefono;
      }

      @Override
      public String toString() {
            return idUsuario + " - " + email + " - " + nombre
                    + " - " + contraseña + " - " + telefono;
      }
}
