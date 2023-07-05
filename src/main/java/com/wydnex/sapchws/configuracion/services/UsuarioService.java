package com.wydnex.sapchws.configuracion.services;

import com.wydnex.sapchws.configuracion.model.Usuario;

import java.util.HashMap;
import java.util.List;


public interface UsuarioService {
    Integer registrarUsuario(Usuario usuario);

    Integer actualizarUsuario(Usuario usuario);

    List<Usuario> listarUsuarios();

    Usuario obtenerUsuariosPorId(Integer usuarioId);
}
