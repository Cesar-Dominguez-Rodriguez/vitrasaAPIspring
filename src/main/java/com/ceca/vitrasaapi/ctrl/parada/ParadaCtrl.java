package com.ceca.vitrasaapi.ctrl.parada;

import com.ceca.vitrasaapi.srvc.parada.ParadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class ParadaCtrl {

    @Autowired
    ParadaService paradaService;

    @GetMapping("/mostrarparada")
    public ResponseEntity mostrarParada() throws IOException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paradaService.crearParadaObject());
    }


}

