package com.ceca.vitrasaapi.modl.scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Scrapper {

    public Scrapper() {
    }

    private Document getDocSiamAvdaGalicia() { //Devuelve un documento con el codigo recuperado de la pagina
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
        Elements todo = getDocSiamAvdaGalicia().getAllElements();
        for (Element span : todo) {
            if (span != null && oneView == false) {
                try {  // nombre y numero de la parada
                    String nombreParada = span.getElementById("lblNombre").text();
                    textoValores.add(nombreParada.substring(0, 16));
                    textoValores.add(nombreParada.substring(18));
                } catch (NullPointerException NuEx) {
                    System.out.println("ScrapperClass-getParadaData: Error al recuperar nombre de la parada");
                }
                try {   // Cadena de hora (prescindible)
                    String horaCadena = span.getElementById("lblHora").text();
                    textoValores.add(horaCadena.substring(6, 8));
                    textoValores.add(horaCadena.substring(9, 11));
                } catch (NullPointerException NuEx) {
                    System.out.println("ScrapperClass-getParadaData: Error al recuperar hora");
                }
                try {  //Autobus Y Minutos
                    int iBus = 0;
                    for (Element elemento : span.getElementsByTag("td")) {
                        if (iBus == 4) {
                            textoValores.add(elemento.text().substring(13, 15));
                            String tiempoRestante = "";
                            if (elemento.text().substring(16, 17).compareTo("C") == 0) {
                                tiempoRestante = elemento.text().substring(35, 37).replace(" ", "");
                            } else if (elemento.text().substring(16, 17).compareTo("B") == 0) {
                                tiempoRestante = elemento.text().substring(37, 39).replace(" ", "");
                            }
                            textoValores.add(tiempoRestante);
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


//    public Document getDocMoov(){
//        String url = "https://moovitapp.com/vigo-3841/lines/31/784701/3529152/es?customerId=4908&ref=2&poiType=line";
//        try {
//            return Jsoup.connect(url).get();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public void viewDocMoov() {
//
//    }
}
