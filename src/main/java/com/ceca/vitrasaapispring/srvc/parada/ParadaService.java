package com.ceca.vitrasaapispring.srvc.parada;

import com.ceca.vitrasaapispring.modl.autobus.Autobus;
import com.ceca.vitrasaapispring.modl.parada.Parada;
import com.ceca.vitrasaapispring.modl.scrapper.Scrapper;
import com.ceca.vitrasaapispring.modl.hora.Hora;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParadaService {

    public Parada crearParadaObject(){
        List<String> textoValores = new Scrapper().getParadaData();
        Parada parada = new Parada();
        parada.setNombre(textoValores.get(0));
        parada.setNumero(Integer.valueOf(textoValores.get(1)));
        Hora hora= new Hora();
        hora.setHor(Integer.valueOf(textoValores.get(2)));
        hora.setMin(Integer.valueOf(textoValores.get(3)));
        parada.setHora(hora);
        parada.setAutobus(new Autobus(textoValores.get(4)));
        parada.setMinutosRestantes(Integer.valueOf(textoValores.get(5)));
        return parada;
    }



}
