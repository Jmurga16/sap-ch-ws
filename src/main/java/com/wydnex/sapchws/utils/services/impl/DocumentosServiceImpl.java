package com.wydnex.sapchws.utils.services.impl;


import com.wydnex.sapchws.utils.config.FuncionesUtil;
import com.wydnex.sapchws.utils.exceptions.BusinessException;
import com.wydnex.sapchws.utils.mappers.UtilMapper;
import com.wydnex.sapchws.utils.model.Documento;
import com.wydnex.sapchws.utils.model.GrupoDocumento;
import com.wydnex.sapchws.utils.services.DocumentosService;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DocumentosServiceImpl implements DocumentosService {

    private UtilMapper utilMapper;
    private FuncionesUtil funcionesUtil;


    public DocumentosServiceImpl(UtilMapper utilMapper, FuncionesUtil funcionesUtil) {
        this.utilMapper = utilMapper;
        this.funcionesUtil = funcionesUtil;
    }

    @Override
    public GrupoDocumento load(MultipartFile[] multipartFiles) {

        List<Documento> documentos = Arrays.stream(multipartFiles)
                .filter(multipartFile -> !Objects.requireNonNull(multipartFile.getOriginalFilename()).isEmpty())
                .map(multipartFile -> {
                    Documento f = new Documento();
                    f.setMultipartFile(multipartFile);
                    f.setNombreOriginal(multipartFile.getOriginalFilename());
                    f.setContentType(multipartFile.getContentType());
                    f.setExtension(Objects.requireNonNull(multipartFile.getOriginalFilename()).substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1));
                    f.setTamano(multipartFile.getSize() + "");
                    f.setEstado("1");

                    //guardamos el documento y retornamos el nombre generado

                    try {
                        String nombreGenerado = funcionesUtil.copy(multipartFile);
                        f.setNombreGenerado(nombreGenerado);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (Exception e) {
                        throw new BusinessException(e.getMessage());
                    }
                    return f;
                }).collect(Collectors.toList());

        if (documentos.size() == 0) {
            throw new BusinessException("No se encontraron documentos");
        }
        return utilMapper.registrarDocumentos(documentos);
    }

    @Override
    public Documento download(Integer idFile) throws MalformedURLException {


        Documento documento = utilMapper.obtenerDocumento(idFile);
        if (documento != null) {
            Resource resource = funcionesUtil.load(documento.getNombreGenerado());
            documento.setDocumento(resource);

        } else {
            throw new BusinessException("No se encontraron documentos asociados");
        }

        return documento;


    }

    @Override
    public String delete(Integer idArchivo) {
        return null;
    }
}
