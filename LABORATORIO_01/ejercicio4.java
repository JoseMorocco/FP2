package LABORATORIO_01;
import java.util.*;

public class ejercicio4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] soldados = new String[5];

        for (int i = 0; i < soldados.length; i++) {
            System.out.println("Ingrese el nombre del soldado " + (i + 1));
            soldados[i] = sc.nextLine();
        }

        int[] vidas = new int[5];

        for (int i = 0; i < vidas.length; i++) {
            System.out.println("Ingrese la vida del soldado " + (i + 1));
            vidas[i] = sc.nextInt();
        }

        System.out.println("Los datos de los soldados son:");

        for (int i = 0; i < soldados.length; i++) {
            System.out.println((i + 1) + ".- Nombre: " + soldados[i] + " Vida: " + vidas[i]);
        }
    }
}
