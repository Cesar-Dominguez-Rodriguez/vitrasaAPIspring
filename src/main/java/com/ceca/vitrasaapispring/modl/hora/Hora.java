package com.ceca.vitrasaapispring.modl.hora;

public class Hora {
    private Integer hor;
    private Integer min;

    public Hora() {
    }

    public Integer getHor() {
        return hor;
    }

    public void setHor(Integer hor) {
        this.hor = hor;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return ""+hor + min+"";
    }
}
