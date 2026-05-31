package edu.pucmm.eict.practica1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la url: ");

        String url = scanner.nextLine();

        System.out.println("La url es " + url);

        scanner.close();

        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://postman-echo.com/get")).GET().build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        HttpHeaders responseHeaders = response.headers();

        System.out.println(responseHeaders);

        //HttpRequest.newBuilder(request, (name, value) -> !name.equalsIgnoreCase("Foo-Bar"));

    }
}
