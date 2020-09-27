package mx.model;
// Generated 24/09/2020 09:46:10 PM by Hibernate Tools 4.3.1



/**
 * ConceptoPagosCompGto generated by hbm2java
 */
public class ConceptoPagosCompGto  implements java.io.Serializable {


     private int id;
     private String iddocumento;
     private String serie;
     private String folio;
     private String monedadr;
     private String metododepagodr;
     private String numparcialidad;
     private String impsaldoant;
     private String imppagado;
     private String impsaldoinsoluto;
     private String factura;

    public ConceptoPagosCompGto() {
    }

	
    public ConceptoPagosCompGto(int id) {
        this.id = id;
    }
    public ConceptoPagosCompGto(int id, String iddocumento, String serie, String folio, String monedadr, String metododepagodr, String numparcialidad, String impsaldoant, String imppagado, String impsaldoinsoluto, String factura) {
       this.id = id;
       this.iddocumento = iddocumento;
       this.serie = serie;
       this.folio = folio;
       this.monedadr = monedadr;
       this.metododepagodr = metododepagodr;
       this.numparcialidad = numparcialidad;
       this.impsaldoant = impsaldoant;
       this.imppagado = imppagado;
       this.impsaldoinsoluto = impsaldoinsoluto;
       this.factura = factura;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getIddocumento() {
        return this.iddocumento;
    }
    
    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }
    public String getSerie() {
        return this.serie;
    }
    
    public void setSerie(String serie) {
        this.serie = serie;
    }
    public String getFolio() {
        return this.folio;
    }
    
    public void setFolio(String folio) {
        this.folio = folio;
    }
    public String getMonedadr() {
        return this.monedadr;
    }
    
    public void setMonedadr(String monedadr) {
        this.monedadr = monedadr;
    }
    public String getMetododepagodr() {
        return this.metododepagodr;
    }
    
    public void setMetododepagodr(String metododepagodr) {
        this.metododepagodr = metododepagodr;
    }
    public String getNumparcialidad() {
        return this.numparcialidad;
    }
    
    public void setNumparcialidad(String numparcialidad) {
        this.numparcialidad = numparcialidad;
    }
    public String getImpsaldoant() {
        return this.impsaldoant;
    }
    
    public void setImpsaldoant(String impsaldoant) {
        this.impsaldoant = impsaldoant;
    }
    public String getImppagado() {
        return this.imppagado;
    }
    
    public void setImppagado(String imppagado) {
        this.imppagado = imppagado;
    }
    public String getImpsaldoinsoluto() {
        return this.impsaldoinsoluto;
    }
    
    public void setImpsaldoinsoluto(String impsaldoinsoluto) {
        this.impsaldoinsoluto = impsaldoinsoluto;
    }
    public String getFactura() {
        return this.factura;
    }
    
    public void setFactura(String factura) {
        this.factura = factura;
    }




}


