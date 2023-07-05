package com.wydnex.sapchws.utils.services;



import com.wydnex.sapchws.utils.model.Documento;
import com.wydnex.sapchws.utils.model.GrupoDocumento;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.List;

@Service
public interface DocumentosService {

    GrupoDocumento load(MultipartFile[] files);

    Documento download(Integer idFile) throws MalformedURLException;

    String delete(Integer idArchivo);



}
