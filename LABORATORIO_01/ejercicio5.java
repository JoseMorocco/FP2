package LABORATORIO_01;
import java.util.*;

public class ejercicio5 {

    public static void main(String[] args) {

        Random aleatorio = new Random();

        int numeroEjercito1 = aleatorio.nextInt(5) + 1;
        int numeroEjercito2 = aleatorio.nextInt(5) + 1;

        String[] ejercito1 = inicializarEjercito(numeroEjercito1);
        String[] ejercito2 = inicializarEjercito(numeroEjercito2);

        System.out.println("Soldados del primer ejercito:");
        mostrarEjercito(ejercito1);
        
        System.out.println("Soldados del segundo ejercito:");
        mostrarEjercito(ejercito2);

        mostrarEjercitoGanador(numeroEjercito1, numeroEjercito2);
    }

    public static String[] inicializarEjercito(int numeroDeSoldados) {
        String[] ejercito = new String[numeroDeSoldados];

        for (int i = 0; i < ejercito.length; i++) {
            ejercito[i] = "Soldado " + (i + 1);
        }

        return ejercito;
    }

    public static void mostrarEjercito(String[] ejercito) {
        for (int i = 0; i < ejercito.length; i++) {
            System.out.println(ejercito[i]);
        }
    }

    public static void mostrarEjercitoGanador(int ejercito1, int ejercito2) {
        System.out.println("El primer ejercito tiene " + ejercito1 + " soldados");
        System.out.println("El segundo ejercito tiene " + ejercito2 + " soldados");
        
        if (ejercito1 > ejercito2) {
            System.out.println("Gano el primer ejercito");
        } else if (ejercito2 > ejercito1) {
            System.out.println("Gano el segundo ejercito");
        } else {
            System.out.println("Hubo un empate");
        }
    }
}
