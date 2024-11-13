package LABORATORIO_07;

public class VideoJuego4 {
    package LABORATORIO_07;
import java.util.*;

public class VideoJuego4 {
    public static void main(String[] args) {
        Random random = new Random();
        int tTablero = 10;

        // Generamos el número de soldados para cada ejército
        int nSoldados1 = random.nextInt(10) + 1;
        int nSoldados2 = random.nextInt(10) + 1;
        System.out.println("Se generarán " + nSoldados1 + " Soldados para el Ejército1");
        System.out.println("Se generarán " + nSoldados2 + " Soldados para el Ejército2");

        // Creamos el tablero vacío como un arreglo bidimensional
        Soldado[][] tablero = new Soldado[tTablero][tTablero];

        // Inicializamos los ejércitos como ArrayList de soldados
        ArrayList<Soldado> ejercito1 = new ArrayList<>();
        ArrayList<Soldado> ejercito2 = new ArrayList<>();

        // Colocamos soldados en el tablero
        ingresarSoldadosTablero(nSoldados1, tablero, ejercito1, 1);
        ingresarSoldadosTablero(nSoldados2, tablero, ejercito2, 2);

        mostrarTablero(tablero);

        // Mostramos datos de los ejércitos
        mostrarEstadisticas(ejercito1, "Ejército 1");
        mostrarEstadisticas(ejercito2, "Ejército 2");

    }
    // Método para ingresar soldados al tablero y al ejército
    public static void ingresarSoldadosTablero(int nSoldados, Soldado[][] tablero, ArrayList<Soldado> ejercito, int idEjercito) {
        Random random = new Random();
        int tTablero = tablero.length;

        for (int i = 0; i < nSoldados; i++) {
            int fila, columna;
            do {
                fila = random.nextInt(tTablero);
                columna = random.nextInt(tTablero);
            } while (tablero[fila][columna] != null);

            int vida = random.nextInt(5) + 1;
            String nombre = "Soldado" + i + "X" + idEjercito;
            Soldado soldado = new Soldado(nombre, vida, fila, columna);
            tablero[fila][columna] = soldado;
            ejercito.add(soldado);  
        }
    }

    // Método para mostrar el tablero
    public static void mostrarTablero(Soldado[][] tablero) {
        System.out.print("    ");
        for (char letra = 'A'; letra < 'A' + tablero.length; letra++) {
            System.out.print("  " + letra + "  ");
        }
        System.out.println();

        for (int i = 0; i < tablero.length; i++) {
            System.out.printf("%2d  ", i + 1);
            for (int j = 0; j < tablero[i].length; j++) {
                Soldado soldado = tablero[i][j];
                if (soldado == null) {
                    System.out.print("|____");
                } else if (soldado.getNombre().contains("X1")) {
                    System.out.print("| S1 ");
                } else {
                    System.out.print("| S2 ");
                }
            }
            System.out.println("|");
        }
    }    
    
}
