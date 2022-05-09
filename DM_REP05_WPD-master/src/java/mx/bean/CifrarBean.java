package mx.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import mx.dao.LoginDao;
import mx.dao.LoginDaoImpl;
import mx.model.Usuario;

@Named(value = "cifrar")
@ViewScoped
public class CifrarBean implements Serializable {

    private Usuario usuario;
    private List<Usuario> listaUsuario;

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    public CifrarBean() {
    }

    public void cifrar() {
        LoginDao dao = new LoginDaoImpl();
        this.listaUsuario = new ArrayList<>();
        this.listaUsuario = dao.lista();
        listaUsuario.forEach((u) -> {
            LoginDao udao = new LoginDaoImpl();
            udao.actualizaClave(u);
        });
        
    }

}
