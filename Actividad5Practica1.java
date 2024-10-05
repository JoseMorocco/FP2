package LABORATORIO_03;
import java.util.Random;
public class Actividad5Practica1 {

    public static void main(String[] args) {
        Random aleatorio = new Random();
        // Generar  el número de soldados para los dos ejércitos
        int numeroEjercito1 = aleatorio.nextInt(5) + 1;
        int numeroEjercito2 = aleatorio.nextInt(5) + 1;

        // Inicializar los ejércitos con objetos Soldado
        Soldado[] ejercito1 = inicializarEjercito(numeroEjercito1);
        Soldado[] ejercito2 = inicializarEjercito(numeroEjercito2);

        System.out.println("Soldados del primer ejército:");
        mostrarEjercito(ejercito1);

        System.out.println("\nSoldados del segundo ejército:");
        mostrarEjercito(ejercito2);

        mostrarEjercitoGanador(numeroEjercito1, numeroEjercito2);
    }

    // Inicializar un ejército con un número de soldados dado
    public static Soldado[] inicializarEjercito(int numeroDeSoldados) {
        Soldado[] ejercito = new Soldado[numeroDeSoldados];
        Random aleatorio = new Random();
        // Generar nombre y nivel de vida
        for (int i = 0; i < ejercito.length; i++) {
            int nivelDeVida = aleatorio.nextInt(5) + 1; // Generar un número entre 1 y 5
            ejercito[i] = new Soldado("Soldado " + (i + 1), nivelDeVida);
        }
        return ejercito;
    }

    // Mostrar los datos de cada soldado del ejército
    public static void mostrarEjercito(Soldado[] ejercito) {
        for (int i = 0; i < ejercito.length; i++) {
            System.out.println("Nombre: " + ejercito[i].getNombre() + ", Nivel de vida: " + ejercito[i].getNivelDeVida());
        }
    }

    // Mostrar el ejército ganador en función de la cantidad de soldados
    public static void mostrarEjercitoGanador(int ejercito1, int ejercito2) {
        System.out.println("\nEl primer ejército tiene " + ejercito1 + " soldados.");
        System.out.println("El segundo ejército tiene " + ejercito2 + " soldados.");
        if (ejercito1 > ejercito2) {
            System.out.println("Ganó el primer ejército.");
        } else if (ejercito2 > ejercito1) {
            System.out.println("Ganó el segundo ejército.");
        } else {
            System.out.println("Hubo un empate.");
        }
    }
}
