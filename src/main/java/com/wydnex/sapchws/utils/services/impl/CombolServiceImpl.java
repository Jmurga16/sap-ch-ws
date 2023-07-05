package com.wydnex.sapchws.utils.services.impl;


import com.wydnex.sapchws.utils.mappers.UtilMapper;
import com.wydnex.sapchws.utils.model.ResponseCombo;
import com.wydnex.sapchws.utils.services.ComboService;
import org.springframework.stereotype.Service;

@Service
public class CombolServiceImpl implements ComboService {

    private UtilMapper utilMapper;

    public CombolServiceImpl(UtilMapper utilMapper) {
        this.utilMapper = utilMapper;
    }

    @Override
    public ResponseCombo listarCombo(String comboRequest) {
        return utilMapper.listarCombo(comboRequest);
    }
}
