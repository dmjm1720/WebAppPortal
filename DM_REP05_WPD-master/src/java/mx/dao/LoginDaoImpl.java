package mx.dao;

import java.util.List;
import mx.model.Usuario;
import mx.util.Cifrado;
import mx.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginDaoImpl implements LoginDao {

    @Override
    public Usuario obternerDatosUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Usuario WHERE RFC=:RFC and CLAVE=:CLAVE";
        Query q = session.createQuery(hql).setMaxResults(1);
        q.setParameter("RFC", usuario.getRfc());
        q.setParameter("CLAVE",Cifrado.sha512(usuario.getClave()));
        return (Usuario) q.uniqueResult();
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario user = this.obternerDatosUsuario(usuario);
        if (user != null) {
            if (!user.getClave().equals(user.getClave())) {
                user = null;
            }
        }
        return user;
    }

    @Override
    public List<Usuario> lista() {
        List<Usuario> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Usuario";
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
    public void actualizaClave(Usuario usuario) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "UPDATE Usuario SET clave=:clave WHERE id=:id";
        Query q = session.createQuery(hql);
        q.setParameter("id", usuario.getId());
        q.setParameter("clave", Cifrado.sha512(usuario.getClave()));
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        } 
    }

}
