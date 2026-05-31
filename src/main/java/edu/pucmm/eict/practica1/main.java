package edu.pucmm.eict.practica1;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la url: ");

        String url = scanner.nextLine();

        scanner.close();



        try{
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            HttpHeaders responseHeaders = response.headers();

            String tipoRecurso = responseHeaders.firstValue("Content-type").orElse("Error");

            System.out.println("[El tipo de recurso es " + tipoRecurso + "]");

            if (!tipoRecurso.contains("text/html")){
                System.out.println("El recurso no es HTML, abortando el programa...");
                return;
            }

            String body = response.body();

            Document doc =  Jsoup.parse(body, "UTF-8");

            String contenidoHtml = doc.toString();

            System.out.println("1- Cantidad de lineas del recurso retornado: " + contenidoHtml.split("\n").length);

            Elements parrafos = doc.select("p");

            System.out.println("2- Cantidad de parrafos del recurso retornado: " + parrafos.size());


        } catch (Throwable t){
            System.out.println("Ha ocurrido un error utilizando la url " + url);
        }




        //HttpRequest.newBuilder(request, (name, value) -> !name.equalsIgnoreCase("Foo-Bar"));

    }
}
