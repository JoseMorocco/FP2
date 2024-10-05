package LABORATORIO_01;
import java.util.*;

public class ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String soldado1, soldado2, soldado3, soldado4, soldado5;
        int vida1, vida2, vida3, vida4, vida5;

        Random aleatorio = new Random();

        System.out.println("Ingrese el nombre del primer soldado");
        soldado1 = sc.nextLine();

        System.out.println("Ingrese el nombre del segundo soldado");
        soldado2 = sc.nextLine();

        System.out.println("Ingrese el nombre del tercer soldado");
        soldado3 = sc.nextLine();

        System.out.println("Ingrese el nombre del cuarto soldado");
        soldado4 = sc.nextLine();

        System.out.println("Ingrese el nombre del quinto soldado");
        soldado5 = sc.nextLine();

        vida1 = aleatorio.nextInt(5) + 1;
        vida2 = aleatorio.nextInt(5) + 1;
        vida3 = aleatorio.nextInt(5) + 1;
        vida4 = aleatorio.nextInt(5) + 1;
        vida5 = aleatorio.nextInt(5) + 1;

        System.out.println("Los datos de los soldados son:");
        System.out.println("1.- Nombre: " + soldado1 + " Vida: " + vida1);
        System.out.println("2.- Nombre: " + soldado2 + " Vida: " + vida2);
        System.out.println("3.- Nombre: " + soldado3 + " Vida: " + vida3);
        System.out.println("4.- Nombre: " + soldado4 + " Vida: " + vida4);
        System.out.println("5.- Nombre: " + soldado5 + " Vida: " + vida5);
    }
}
