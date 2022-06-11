package com.ceca.vitrasaapi.modl.scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Scrapper {

    public Scrapper() {
    }

    private Document getDoc() { //Devuelve un documento con el codigo recuperado de la pagina
        try {
            return Jsoup.connect("http://infobus.vitrasa.es:8002/Default.aspx?parada=1600").get();
        } catch (IOException ioEx) {
            System.out.println("getParada stop url not found");
            return new Document("");
        }
    }

    public List<String> getParadaData() { //Obtener datos de parada, devuelve una lista de Strings en orden con los valores
        List<String> textoValores = new ArrayList<>();
        boolean oneView = false;
        Elements todo = getDoc().getAllElements();
        for (Element span : todo) {
            if (span != null && !oneView) {
                try {  // nombre y numero de la parada
                    String nombreParada = Objects.requireNonNull(span.getElementById("lblNombre")).text();
                    textoValores.add(nombreParada.substring(0, 16));
                    textoValores.add(nombreParada.substring(18));
                } catch (NullPointerException NuEx) {
                    System.out.println("ScrapperClass-getParadaData: Error al recuperar nombre de la parada");
                }
                try {   // Cadena de hora (prescindible)
                    String horaCadena = Objects.requireNonNull(span.getElementById("lblHora")).text();
                    textoValores.add(horaCadena.substring(6, 8));
                    textoValores.add(horaCadena.substring(9, 11));
                    System.out.println("Comprobacion hora --> "+textoValores.toString());
                } catch (NullPointerException NuEx) {
                    System.out.println("ScrapperClass-getParadaData: Error al recuperar hora");
                }
                try {  //Autobus Y Minutos
                    int iBus = 0;
                    for (Element elemento : span.getElementsByTag("td")) {
                        if (iBus == 4) {
                            System.out.println(elemento.text().substring(13, 15));
                            textoValores.add(elemento.text().substring(13, 15));
                            String tiempoRestante = "";
                            Elements elementosTR= elemento.select("[align*=right]");
                            Boolean contTR= true;
                            for(Element elementoTR: elementosTR ){
                               if(contTR){
                                System.out.println(elementoTR.text());
                                tiempoRestante = elementoTR.text();
                               }
                                contTR= false;
                            }
                            textoValores.add(tiempoRestante);
                            System.out.println(textoValores.toString());
                        }
                        iBus++;
                    }
                } catch (NullPointerException NuEx) {
                    System.out.println("ScrapperClass-getParadaData: Error al recuperar nombre del autobus");
                }
                //Minutos restantes

                oneView = true;
            }
        }
        return textoValores;
    }
}
