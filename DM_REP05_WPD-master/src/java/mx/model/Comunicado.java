package mx.model;
// Generated 28/09/2020 09:59:44 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Comunicado generated by hbm2java
 */
public class Comunicado  implements java.io.Serializable {


     private int id;
     private Date fecha;
     private String ruta;
     private String ruta2;
     private String ruta3;

    public Comunicado() {
    }

	
    public Comunicado(int id) {
        this.id = id;
    }
    public Comunicado(int id, Date fecha, String ruta, String ruta2, String ruta3) {
       this.id = id;
       this.fecha = fecha;
       this.ruta = ruta;
       this.ruta2 = ruta2;
       this.ruta3 = ruta3;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getRuta() {
        return this.ruta;
    }
    
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    public String getRuta2() {
        return this.ruta2;
    }
    
    public void setRuta2(String ruta2) {
        this.ruta2 = ruta2;
    }
    public String getRuta3() {
        return this.ruta3;
    }
    
    public void setRuta3(String ruta3) {
        this.ruta3 = ruta3;
    }




}


