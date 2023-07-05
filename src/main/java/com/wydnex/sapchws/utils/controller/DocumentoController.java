package com.wydnex.sapchws.utils.controller;

import com.wydnex.sapchws.utils.exceptions.BusinessException;
import com.wydnex.sapchws.utils.model.Documento;
import com.wydnex.sapchws.utils.model.GrupoDocumento;
import com.wydnex.sapchws.utils.model.ResponseApi;
import com.wydnex.sapchws.utils.services.DocumentosService;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.wydnex.sapchws.utils.config.PathsUtil.*;

@RestController
@RequestMapping(ROOT_API + FILES + VERSION)
public class DocumentoController {


    private DocumentosService documentosService;

    public DocumentoController(DocumentosService documentosService) {
        this.documentosService = documentosService;
    }

    @PostMapping(LOAD_FILE)
    public ResponseApi<GrupoDocumento> cargarArchivos(
            @RequestBody MultipartFile[] files
    ) {

        return ResponseApi.build(documentosService.load(files));

    }


    @GetMapping(DOWNLOAD_FILE)
    public ResponseEntity<Resource> descargarArchivo(@PathVariable Integer idDocumento) throws MalformedURLException {

        Documento documento = documentosService.download(idDocumento);

        return ResponseEntity.ok()
                .headers(httpHeaders -> {
                    httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + documento.getNombreOriginal());
                    httpHeaders.add("ms-filename", documento.getNombreOriginal());
                })
                .contentType(MediaType.parseMediaType(documento.getContentType()))
                .body(documento.getDocumento());


    }
}
