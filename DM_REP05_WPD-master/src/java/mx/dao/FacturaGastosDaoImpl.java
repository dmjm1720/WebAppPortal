package mx.dao;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.model.FacturaGastos;
import mx.model.Usuario;
import mx.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FacturaGastosDaoImpl implements FacturaGastosDao {

    @Override
    public List<FacturaGastos> listaFactura() {
        List<FacturaGastos> lista = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM FacturaGastos where usuario='" + us.getCorreo() + "' order by id desc";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<FacturaGastos> listaFacRFC(String rfc) {
        List<FacturaGastos> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM FacturaGastos where rfcE='" + rfc + "' order by id desc";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<FacturaGastos> listarFact(String factura) {
        List<FacturaGastos> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM FacturaGastos where factura='" + factura + "' order by id desc";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<FacturaGastos> listarFechaRecep(String f1, String f2) {
        List<FacturaGastos> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM FacturaGastos where fechaRecepcion >= '" + f1 + "' AND fechaRecepcion <= '" + f2 + "' order by id desc";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<FacturaGastos> listarNoRecep(String recepcion) {
        List<FacturaGastos> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM FacturaGastos where referencia = '" + recepcion + "' order by id desc";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<FacturaGastos> listarFolioWCXP(String folio) {
        List<FacturaGastos> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "From FacturaGastos where foliowcxp = '" + folio + "' order by id desc";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<FacturaGastos> listarEstatus(String estatus) {
        List<FacturaGastos> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "From FacturaGastos where estatus='" + estatus + "' order by id desc";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<FacturaGastos> listaAdminFactura() {
        List<FacturaGastos> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM FacturaGastos order by id desc";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public void InsertFactura(FacturaGastos factura) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(factura);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "COLOIDALES DUCHÉ, S.A. DE C.V.", "Factura agregada correctamente"));

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @SuppressWarnings("null")
    public void UpdateFactura(FacturaGastos factura) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(factura);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "COLOIDALES DUCHÉ, S.A. DE C.V.", "Factura cancelada correctamente"));
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @SuppressWarnings("null")
    public void DeleteFactura(FacturaGastos factura) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(factura);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "COLOIDALES DUCHÉ, S.A. DE C.V.", "Factura borrada correctamente"));
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<FacturaGastos> listarAdministrador() {
        List<FacturaGastos> lista = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM FacturaGastos order by id desc";
        try {
            lista = session.createQuery(hql).setMaxResults(500).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

}
