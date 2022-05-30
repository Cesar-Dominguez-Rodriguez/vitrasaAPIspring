package com.ceca.vitrasaapispring.modl.parada;

import com.ceca.vitrasaapispring.modl.autobus.Autobus;
import com.ceca.vitrasaapispring.modl.hora.Hora;

public class Parada {

    private String nombre;
    private Integer numero;
    private Autobus autobus;
    private Hora hora;
    private Integer minutosRestantes;

    public Parada() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getMinutosRestantes() {
        return minutosRestantes;
    }

    public void setMinutosRestantes(Integer minutosRestantes) {
        this.minutosRestantes = minutosRestantes;
    }

    public Autobus getAutobus() {
        return autobus;
    }

    public void setAutobus(Autobus autobus) {
        this.autobus = autobus;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Parada{" +
                "nombre='" + nombre + '\'' +
                ", numero='" + numero + '\'' +
                ", autobus=" + autobus +
                ", horaDeLlegada=" + hora +
                ", minutosRestantes=" + minutosRestantes +
                '}';
    }
}
