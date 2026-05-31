package edu.pucmm.eict.practica1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la url: ");

        String url = scanner.nextLine();

        System.out.println("La url es " + url);

        scanner.close();
    }
}
