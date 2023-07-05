package com.wydnex.sapchws.configuracion.services.impl;

import com.wydnex.sapchws.configuracion.mappers.UsuarioMapper;
import com.wydnex.sapchws.configuracion.model.Usuario;
import com.wydnex.sapchws.configuracion.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UsuarioImpl implements UsuarioService {

    private UsuarioMapper usuarioMapper;

    public UsuarioImpl(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Integer registrarUsuario(Usuario usuario) {
        return  usuarioMapper.registrarUsuario(usuario);
    }

    @Override
    public Integer actualizarUsuario(Usuario usuario) {
        return usuarioMapper.actualizarUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioMapper.listarUsuarios();
    }

    @Override
    public  Usuario obtenerUsuariosPorId(Integer usuarioId) {
        return usuarioMapper.obtenerUsuarioPorId(usuarioId);
    }


}
