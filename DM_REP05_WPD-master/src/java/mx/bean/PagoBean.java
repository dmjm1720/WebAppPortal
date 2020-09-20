package mx.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import mx.dao.FacturaDao;
import mx.dao.FacturaDaoImpl;
import mx.dao.PagoDao;
import mx.dao.PagoDaoImpl;
import mx.model.DiasPago;
import mx.model.Factura;
import org.primefaces.context.RequestContext;

@Named(value = "pagoBean")
@ViewScoped
public class PagoBean implements Serializable {

    private DiasPago pago;
    private List<DiasPago> listaPago;
    private String fecha;
    private Date fecPago;
    private List<Factura> listaPagosPendientes;
    private String tipoOC;
    private String estatus;

    RequestContext facesContext = RequestContext.getCurrentInstance();

    public PagoBean() {
        pago = new DiasPago();
    }

    public DiasPago getPago() {
        return pago;
    }

    public void setPago(DiasPago pago) {
        this.pago = pago;
    }

    public List<DiasPago> getListaPago() {
        PagoDao pDao = new PagoDaoImpl();
        listaPago = pDao.lista();
        return listaPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Date getFecPago() {
        return fecPago;
    }

    public void setFecPago(Date fecPago) {
        this.fecPago = fecPago;
    }

    public void setListaPago(List<DiasPago> listaPago) {
        this.listaPago = listaPago;
    }

    public String getTipoOC() {
        return tipoOC;
    }

    public void setTipoOC(String tipoOC) {
        this.tipoOC = tipoOC;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void insertarPago() {
        PagoDao pDao = new PagoDaoImpl();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        this.fecha = formato.format(this.fecPago);
        System.out.println(fecha);
        this.pago.setFechaPago(fecha);
        pDao.InsertPago(pago);
        pago = new DiasPago();
        this.fecPago = null;
        this.fecha = null;
    }

    public void updatePago() {
        PagoDao pDao = new PagoDaoImpl();
        pDao.UpdatePago(pago);
        pago = new DiasPago();
    }

    public void deletePago() {
        PagoDao pDao = new PagoDaoImpl();
        pDao.DeletePago(pago);
        pago = new DiasPago();
    }

    public void validar() {
        if (estatus != null && tipoOC != null) {
            RequestContext.getCurrentInstance().execute("PF('dlgRepPago').show()");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "COLOIDALES DUCHÉ, S.A. DE C.V.", "Selecciona OC y Estatus"));
        }
    }

    public List<Factura> getListaPagosPendientes() {
        FacturaDao fDao = new FacturaDaoImpl();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String es = request.getParameter("frmEstatus:estatus");
        String oc = request.getParameter("frmOC:oc");
        listaPagosPendientes = fDao.listaPagosPendientes(pago.getFechaPago(), estatus, tipoOC);
        return listaPagosPendientes;
    }

}
