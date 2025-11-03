package alquilervehiculos.service;

import java.sql.Connection;
import java.util.List;

import alquilervehiculos.dao.ConexionSQLite;
import alquilervehiculos.dao.UsuarioDAO;
import alquilervehiculos.model.dto.ListarUsuariosDTO;
import alquilervehiculos.model.dto.ObtenerUsuarioParaEdicionDTO;
import alquilervehiculos.model.entities.Sesion;

public class UsuarioService {
    private final UsuarioDAO usuarioDAO;
    private Sesion sesionActual;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public boolean login(String username, String password) throws Exception {
        Sesion sesion = usuarioDAO.login(username, password);

        if (sesion != null) {
            this.sesionActual = sesion;
            return true;
        }

        return false;
    }

    public void logout() {
        this.sesionActual = null;
    }

    public boolean existeSesionActiva() {
        return this.sesionActual != null;
    }

    public Sesion getSesionActual() {
        return this.sesionActual;
    }

    public List<ListarUsuariosDTO> listarUsuarios() throws Exception {
        return usuarioDAO.listarUsuarios();
    }

    public ObtenerUsuarioParaEdicionDTO obtenerParaEdicion(int idUsuario) throws Exception {
        return usuarioDAO.obtenerParaEdicion(idUsuario);
    }
}
