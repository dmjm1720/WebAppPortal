package mx.model;
// Generated 16/10/2020 01:37:09 PM by Hibernate Tools 4.3.1



/**
 * Cuentas generated by hbm2java
 */
public class Cuentas  implements java.io.Serializable {


     private int idCuenta;
     private String descripcion;
     private String nombre;
     private String cuenta;

    public Cuentas() {
    }

	
    public Cuentas(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    public Cuentas(int idCuenta, String descripcion, String nombre, String cuenta) {
       this.idCuenta = idCuenta;
       this.descripcion = descripcion;
       this.nombre = nombre;
       this.cuenta = cuenta;
    }
   
    public int getIdCuenta() {
        return this.idCuenta;
    }
    
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }




}


