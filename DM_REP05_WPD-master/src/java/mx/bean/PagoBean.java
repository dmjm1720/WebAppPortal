package mx.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import mx.dao.PagoDao;
import mx.dao.PagoDaoImpl;
import mx.model.DiasPago;

@Named(value = "pagoBean")
@ViewScoped
public class PagoBean implements Serializable {

    private DiasPago pago;
    private List<DiasPago> listaPago;
    private String fecha;
    private Date fecPago;


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

}
