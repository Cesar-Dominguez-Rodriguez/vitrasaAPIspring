package com.ceca.vitrasaapispring.modl.scrapper;

import com.ceca.vitrasaapispring.modl.hora.Hora;
import com.ceca.vitrasaapispring.modl.parada.Parada;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Scrapper {

    private int id;

    private String url;

    private Document contenido;

    private String contenidoTexto;

    public Scrapper() {
    }

    public Scrapper(String url, String contenidoTexto) {
        this.url = url;
        this.contenidoTexto = contenidoTexto;
    }

    public Scrapper(Document contenido) {
        this.contenido = contenido;
    }


    //example
    public Document getTitleDocument() throws IOException {
        Document doc = Jsoup.connect("http://stackoverflow.com").userAgent("Mozilla").get();
        for (Element e : doc.select("a.question-hyperlink")) {
            System.out.println(e.attr("abs:href"));
            System.out.println(e.text());
            System.out.println();
        }
        return doc;
    }

    public Document getExample() throws IOException {
        Document doc = Jsoup.connect("http://infobus.vitrasa.es:8002/Default.aspx?parada=1600").get();

        System.out.println("Titulo ---->" + doc.title());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\c3s4r\\IdeaProjects\\vitrasaAPIspring\\src\\main\\resources\\templates\\salida.html"));
        boolean oneView = false;
        Elements tds = new Elements();
        Hora hora = new Hora();
        Parada parada= new Parada();
        String nombreParada= "";
        String horaCadena="";
        Elements todo = doc.getAllElements();
        for (Element span : todo) {
            if (span != null && oneView==false) {
                tds = span.getElementsContainingOwnText("COIA");
                try {
                    horaCadena = span.getElementById("lblHora").text();
                    hora.setHor(Integer.valueOf(horaCadena.substring(6,8)));
                    hora.setMin(Integer.valueOf(horaCadena.substring(9,11)));
                } catch (NullPointerException NuEx) {
                    horaCadena = "Error en hora";
                }
                try {
                    nombreParada = span.getElementById("lblNombre").text();
                    //0 15

                    //18 20
                    parada.setNombre(nombreParada.substring(0,16));
                    parada.setNumero(nombreParada.substring(18));
                    parada.toString();

                    ;
                } catch (NullPointerException NuEx){
                    nombreParada = "Error en nombre de parada";
                }
                if (tds.size() != 0 || tds != null) {
                    for (Element td : tds) {
                        System.out.println(String.valueOf("Parada -> " + td.text()));
                        if(hora.getMin()==0)
                        System.out.println(hora.getHor()+":"+hora.getMin());
                        System.out.println("Parada \n      Nombre: "+parada.getNombre()+" Numero: "+parada.getNumero());
                        oneView= true;
                    }
                }
            }
        }

        oos.writeObject(contenido);
        oos.close();
        return doc;

    }
}
