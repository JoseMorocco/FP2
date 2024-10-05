package LABORATORIO_01;
import java.util.*;

public class ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] soldados = new String[5];

        for (int i = 0; i < soldados.length; i++) {
            System.out.println("Ingrese el nombre del soldado " + (i + 1));
            soldados[i] = sc.nextLine();
        }

        System.out.println("Los nombres de los soldados son:");

        for (int i = 0; i < soldados.length; i++) {
            System.out.println("Soldado " + (i + 1) + " : " + soldados[i]);
        }
    }
}
