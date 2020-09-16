package mx.dao;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.model.Factura;
import mx.model.Usuario;
import mx.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

public class FacturaDaoImpl implements FacturaDao {

    RequestContext facesContext = RequestContext.getCurrentInstance();

    @Override
    public List<Factura> listaFactura() {
        List<Factura> lista = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura where rfcE='" + us.getRfc() + "' order by id desc";
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
    public void InsertFactura(Factura factura) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(factura);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "COLOIDALES DUCHÉ, S.A. DE C.V.", "Factura agregada correctamente"));
            facesContext.execute("Swal.fire({position: 'top-center', icon: 'success', showConfirmButton: false, timer: 4000, title: 'Validación XML con estatus Vigente', showClass: {popup: 'animate__animated animate__fadeInDown'},hideClass: {popup: 'animate__animated animate__fadeOutUp'}})");
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
    public void UpdateFactura(Factura factura) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(factura);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "COLOIDALES DUCHÉ, S.A. DE C.V.", "Fecha de pago actualizada correctamente"));
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
    public void DeleteFactura(Factura factura) {
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
    public List<Factura> listaAdminFactura() {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura order by id desc";
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
    public List<Factura> listaFacRFC(String rfc) {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura where rfcE='" + rfc + "' order by id desc";
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
    public List<Factura> listarFact(String factura) {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura where factura='" + factura + "' order by id desc";
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
    public List<Factura> listarFechaRecep(String f1, String f2) {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura where fechaRecepcion >= '" + f1 + "' AND fechaRecepcion <= '" + f2 + "' order by id desc";
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
    public List<Factura> listarNoRecep(String recepcion) {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura where referencia = '" + recepcion + "' order by id desc";
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
    public List<Factura> listarFolioWCXP(String folio) {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "From Factura where foliowcxp = '" + folio + "' order by id desc";
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
    public List<Factura> listarEstatus(String estatus) {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "From Factura where estatus='" + estatus + "' order by id desc";
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
    public List<Factura> listarFechaPago(String f3, String f4) {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura where fechaPago >= '" + f3 + "' AND fechaPago <= '" + f4 + "' order by id desc";
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
    public List<Factura> listaAdministrador() {
        List<Factura> lista = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura order by id desc";
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
