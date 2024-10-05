package LABORATORIO_01;
import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String soldado1, soldado2, soldado3, soldado4, soldado5;
        
        System.out.println("Ingrese el nombre del primer soldado: ");
        soldado1 = sc.nextLine();

        System.out.println("Ingrese el nombre del segundo soldado:");
        soldado2 = sc.nextLine();

        System.out.println("Ingrese el nombre del tercer soldado:");
        soldado3 = sc.nextLine();

        System.out.println("Ingrese el nombre del cuarto soldado:");
        soldado4 = sc.nextLine();

        System.out.println("Ingrese el nombre del quinto soldado:");
        soldado5 = sc.nextLine();

        System.out.println("Los nombres de los soldados son: ");
        System.out.println("1.- " + soldado1);
        System.out.println("2.- " + soldado2);
        System.out.println("3.- " + soldado3);
        System.out.println("4.- " + soldado4);
        System.out.println("5.- " + soldado5);
    }
}
