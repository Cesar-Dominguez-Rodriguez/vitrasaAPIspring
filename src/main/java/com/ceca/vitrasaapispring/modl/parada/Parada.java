package com.ceca.vitrasaapispring.modl.parada;

import com.ceca.vitrasaapispring.modl.autobus.Autobus;
import com.ceca.vitrasaapispring.modl.hora.Hora;

public class Parada {

    private String nombre;
    private String numero;
    private Autobus autobus;
    private Hora horaDeLlegada;

    public Parada() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Autobus getAutobus() {
        return autobus;
    }

    public void setAutobus(Autobus autobus) {
        this.autobus = autobus;
    }

    public Hora getHoraDeLlegada() {
        return horaDeLlegada;
    }

    public void setHoraDeLlegada(Hora horaDeLlegada) {
        this.horaDeLlegada = horaDeLlegada;
    }

    @Override
    public String toString() {
        return "Parada{" +
                "nombre='" + nombre + '\'' +
                ", numero='" + numero + '\'' +
                ", autobus=" + autobus +
                ", horaDeLlegada=" + horaDeLlegada +
                '}';
    }
}
