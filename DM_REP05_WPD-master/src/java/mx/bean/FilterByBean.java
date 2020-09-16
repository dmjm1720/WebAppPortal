package mx.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import mx.dao.DAO;
import mx.dao.FacturaDao;
import mx.dao.FacturaDaoImpl;
import mx.model.Factura;

@Named(value = "filterByBean")
@ViewScoped
public class FilterByBean extends DAO implements Serializable {

    List<String> listarTodo = new ArrayList();
    private List<Factura> listaCompleta;

    private String filterRFC;
    private String filterFactura;
    private Date filterFec1;
    private Date filterFec2;
    private Date filterFec3;
    private Date filterFec4;
    private String filterNoRec;
    private String filterFolio;
    private String filterEstatus;
    private String resultadoRFC;
    private String resultadoFactura;
    private String resultadoRecepcion;
    private String resultadoFolio;
    private String resultadoEstatus;
    private String f1;
    private String f2;
    private String f3;
    private String f4;

    private Factura factura;

    public FilterByBean() {
        factura = new Factura();

    }

    public String getFilterRFC() {
        return filterRFC;
    }

    public void setFilterRFC(String filterRFC) {
        this.filterRFC = filterRFC;
    }

    public String getFilterFactura() {
        return filterFactura;
    }

    public void setFilterFactura(String filterFactura) {
        this.filterFactura = filterFactura;
    }

    public Date getFilterFec1() {
        return filterFec1;
    }

    public void setFilterFec1(Date filterFec1) {
        this.filterFec1 = filterFec1;
    }

    public Date getFilterFec2() {
        return filterFec2;
    }

    public void setFilterFec2(Date filterFec2) {
        this.filterFec2 = filterFec2;
    }

    public String getFilterNoRec() {
        return filterNoRec;
    }

    public void setFilterNoRec(String filterNoRec) {
        this.filterNoRec = filterNoRec;
    }

    public String getFilterFolio() {
        return filterFolio;
    }

    public void setFilterFolio(String filterFolio) {
        this.filterFolio = filterFolio;
    }

    public String getFilterEstatus() {
        return filterEstatus;
    }

    public void setFilterEstatus(String filterEstatus) {
        this.filterEstatus = filterEstatus;
    }

    public String getResultadoRFC() {
        return resultadoRFC;
    }

    public void setResultadoRFC(String resultadoRFC) {
        this.resultadoRFC = resultadoRFC;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Factura> getListaCompleta() {
        return listaCompleta;
    }

    public void setListaCompleta(List<Factura> listaCompleta) {
        this.listaCompleta = listaCompleta;
    }

    public String getResultadoFactura() {
        return resultadoFactura;
    }

    public void setResultadoFactura(String resultadoFactura) {
        this.resultadoFactura = resultadoFactura;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getResultadoRecepcion() {
        return resultadoRecepcion;
    }

    public void setResultadoRecepcion(String resultadoRecepcion) {
        this.resultadoRecepcion = resultadoRecepcion;
    }

    public String getResultadoFolio() {
        return resultadoFolio;
    }

    public void setResultadoFolio(String resultadoFolio) {
        this.resultadoFolio = resultadoFolio;
    }

    public String getResultadoEstatus() {
        return resultadoEstatus;
    }

    public void setResultadoEstatus(String resultadoEstatus) {
        this.resultadoEstatus = resultadoEstatus;
    }

    public Date getFilterFec3() {
        return filterFec3;
    }

    public void setFilterFec3(Date filterFec3) {
        this.filterFec3 = filterFec3;
    }

    public Date getFilterFec4() {
        return filterFec4;
    }

    public void setFilterFec4(Date filterFec4) {
        this.filterFec4 = filterFec4;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }

    public String getF4() {
        return f4;
    }

    public void setF4(String f4) {
        this.f4 = f4;
    }

//**LISTAS POR RFC **//
    public List<String> completeRFC(String rfc) throws SQLException {
        List<String> resultRFC = new ArrayList<>();
        this.Conectarprov();
        PreparedStatement st = this.getCnprov().prepareStatement("SELECT DISTINCT (RFC_E) FROM FACTURA WHERE  RFC_E LIKE '" + rfc + "%'");
        ResultSet rs = st.executeQuery();
        listarTodo = new ArrayList<>();
        if (!rs.isBeforeFirst()) {
            listarTodo.add("No hay resultados para tu búsqueda");
        } else {
            while (rs.next()) {
                listarTodo.add(this.resultadoRFC = rs.getString("RFC_E"));
            }
        }
        for (int i = 0; i < listarTodo.size(); i++) {
            resultRFC.add(listarTodo.get(i));
        }

        this.Cerrarprov();
        return resultRFC;
    }

    public List<String> completeFactura(String factura) throws SQLException {
        List<String> resultFactura = new ArrayList<>();
        this.Conectarprov();
        PreparedStatement st = this.getCnprov().prepareStatement("SELECT DISTINCT (FACTURA) FROM FACTURA WHERE FACTURA LIKE '" + factura + "%'");
        ResultSet rs = st.executeQuery();
        listarTodo = new ArrayList<>();
        if (!rs.isBeforeFirst()) {
            listarTodo.add("No hay resultados para tu búsqueda");
        } else {
            while (rs.next()) {
                listarTodo.add(this.resultadoFactura = rs.getString("FACTURA"));
            }
        }
        for (int i = 0; i < listarTodo.size(); i++) {
            resultFactura.add(listarTodo.get(i));
        }

        this.Cerrarprov();
        return resultFactura;
    }

    public List<String> completeRecepcion(String recepcion) throws SQLException {
        List<String> resultRecepcion = new ArrayList<>();
        this.Conectarprov();
        PreparedStatement ps = this.getCnprov().prepareStatement("SELECT DISTINCT (REFERENCIA) FROM FACTURA WHERE REFERENCIA LIKE '" + recepcion + "%'");
        ResultSet rs = ps.executeQuery();
        listarTodo = new ArrayList<>();
        if (!rs.isBeforeFirst()) {
            listarTodo.add("No hay resultados para tu búsqueda");
        } else {
            while (rs.next()) {
                listarTodo.add(this.resultadoRecepcion = rs.getString("REFERENCIA"));
            }
        }
        for (int i = 0; i < listarTodo.size(); i++) {
            resultRecepcion.add(listarTodo.get(i));
        }
        this.Cerrarprov();
        return resultRecepcion;
    }

    public List<String> completeFolio(String folio) throws SQLException {
        List<String> resultFolio = new ArrayList<>();
        this.Conectarprov();
        PreparedStatement ps = this.getCnprov().prepareStatement("SELECT DISTINCT (FOLIOWCXP) FROM FACTURA WHERE FOLIOWCXP LIKE '" + folio + "%'");
        ResultSet rs = ps.executeQuery();
        listarTodo = new ArrayList<>();
        if (!rs.isBeforeFirst()) {
            listarTodo.add("No hay resultados para tu búesqueda");
        } else {
            while (rs.next()) {
                listarTodo.add(this.resultadoFolio = rs.getString("FOLIOWCXP"));
            }
        }
        for (int i = 0; i < listarTodo.size(); i++) {
            resultFolio.add(listarTodo.get(i));
        }
        this.Cerrarprov();
        return resultFolio;
    }

    public List<String> completeEstatus(String estatus) throws SQLException {
        List<String> resultEstatus = new ArrayList<>();
        this.Conectarprov();
        PreparedStatement ps = this.getCnprov().prepareStatement("SELECT DISTINCT (ESTATUS) FROM FACTURA WHERE ESTATUS LIKE '" + estatus + "%'");
        ResultSet rs = ps.executeQuery();
        listarTodo = new ArrayList<>();
        if (!rs.isBeforeFirst()) {
            listarTodo.add("No har resultados para tu búsqueda");
        } else {
            while (rs.next()) {
                listarTodo.add(this.resultadoEstatus = rs.getString("ESTATUS"));
            }

        }
        for (int i = 0; i < listarTodo.size(); i++) {
            resultEstatus.add(listarTodo.get(i));
        }
        this.Cerrarprov();
        return resultEstatus;
    }

    public List<Factura> listarAll() {
        FacturaDao fDao = new FacturaDaoImpl();
        if (filterRFC != null) {
            listaCompleta = fDao.listaFacRFC(filterRFC);
        } else if (filterFactura != null) {
            listaCompleta = fDao.listarFact(filterFactura);
        } else if (filterFec1 != null && filterFec2 != null) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            f1 = formato.format(filterFec1);
            f2 = formato.format(filterFec2);
            listaCompleta = fDao.listarFechaRecep(f1, f2);
        } else if (filterFec3 != null && filterFec4 != null) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            f3 = formato.format(filterFec3);
            f4 = formato.format(filterFec4);
            listaCompleta = fDao.listarFechaPago(f3, f4);
        } else if (filterNoRec != null) {
            listaCompleta = fDao.listarNoRecep(filterNoRec);
        } else if (filterFolio != null) {
            listaCompleta = fDao.listarFolioWCXP(filterFolio);
        } else if (filterEstatus != null) {
            listaCompleta = fDao.listarEstatus(filterEstatus);
        }
        filterRFC = null;
        filterFactura = null;
        filterFec1 = null;
        filterFec2 = null;
        filterFec3 = null;
        filterFec4 = null;
        filterNoRec = null;
        filterFolio = null;
        filterEstatus = null;
        f1 = null;
        f2 = null;
        f3 = null;
        f4 = null;
        return listaCompleta;

    }
    //**LISTAS POR RFC **//

    public void actualizarFechaPago() {
        FacturaDao fDao = new FacturaDaoImpl();
        fDao.UpdateFactura(factura);
        factura = new Factura();
    }

    public List<Factura> listarUltRecep() {
        FacturaDao fDao = new FacturaDaoImpl();
        listaCompleta = fDao.listaAdministrador();
        return listaCompleta;
    }

}
