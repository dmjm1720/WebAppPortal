package mx.dao;

import java.util.List;
import mx.model.Usuario;

public interface LoginDao {

    public Usuario obternerDatosUsuario(Usuario usuario);

    public Usuario login(Usuario usuario);

    public List<Usuario> lista();
    
    public void actualizaClave(Usuario usuario);
    
    
}
