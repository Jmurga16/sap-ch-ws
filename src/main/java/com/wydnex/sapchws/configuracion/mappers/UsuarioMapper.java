package com.wydnex.sapchws.configuracion.mappers;


import com.wydnex.sapchws.configuracion.model.Usuario;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface UsuarioMapper {

    Integer registrarUsuario(@Param("usuario") Usuario usuario);

    Integer actualizarUsuario(@Param("usuario") Usuario usuario);

    List<Usuario> listarUsuarios();

    Usuario obtenerUsuarioPorId(@Param("usuarioId") Integer usuarioId);


}
