package mx.model;
// Generated 24/09/2020 09:46:10 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * PagoGto generated by hbm2java
 */
public class PagoGto  implements java.io.Serializable {


     private int id;
     private String fechapago;
     private String formadepago;
     private String monedapago;
     private BigDecimal monto;
     private String numoperacion;
     private String rfcemisorctaben;
     private String ctabeneficiario;
     private String uuid;

    public PagoGto() {
    }

	
    public PagoGto(int id) {
        this.id = id;
    }
    public PagoGto(int id, String fechapago, String formadepago, String monedapago, BigDecimal monto, String numoperacion, String rfcemisorctaben, String ctabeneficiario, String uuid) {
       this.id = id;
       this.fechapago = fechapago;
       this.formadepago = formadepago;
       this.monedapago = monedapago;
       this.monto = monto;
       this.numoperacion = numoperacion;
       this.rfcemisorctaben = rfcemisorctaben;
       this.ctabeneficiario = ctabeneficiario;
       this.uuid = uuid;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getFechapago() {
        return this.fechapago;
    }
    
    public void setFechapago(String fechapago) {
        this.fechapago = fechapago;
    }
    public String getFormadepago() {
        return this.formadepago;
    }
    
    public void setFormadepago(String formadepago) {
        this.formadepago = formadepago;
    }
    public String getMonedapago() {
        return this.monedapago;
    }
    
    public void setMonedapago(String monedapago) {
        this.monedapago = monedapago;
    }
    public BigDecimal getMonto() {
        return this.monto;
    }
    
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public String getNumoperacion() {
        return this.numoperacion;
    }
    
    public void setNumoperacion(String numoperacion) {
        this.numoperacion = numoperacion;
    }
    public String getRfcemisorctaben() {
        return this.rfcemisorctaben;
    }
    
    public void setRfcemisorctaben(String rfcemisorctaben) {
        this.rfcemisorctaben = rfcemisorctaben;
    }
    public String getCtabeneficiario() {
        return this.ctabeneficiario;
    }
    
    public void setCtabeneficiario(String ctabeneficiario) {
        this.ctabeneficiario = ctabeneficiario;
    }
    public String getUuid() {
        return this.uuid;
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }




}


