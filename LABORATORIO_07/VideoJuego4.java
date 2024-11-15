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

        // Determinamos el ejército ganador
        String ganador = (sumaVida(ejercito1) > sumaVida(ejercito2)) ? "Ejército 1" : "Ejército 2";
        System.out.println("El ganador de la batalla es (según la suma total de vida de ambos ejércitos): " + ganador);
    }

    

    // Método para sumar vida total de un ejército
    public static int sumaVida(ArrayList<Soldado> ejercito) {
        int suma = 0;
        for (Soldado soldado : ejercito) {
            suma += soldado.getVida();
        }
        return suma;
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
    // Método para mostrar estadísticas del ejército
    public static void mostrarEstadisticas(ArrayList<Soldado> ejercito, String nombreEjercito) {
        System.out.println("\nEstadísticas de " + nombreEjercito + ":");

        Soldado soldadoMayorVida = null;
        int sumaVida = 0;

        for (Soldado soldado : ejercito) {
            sumaVida += soldado.getVida();
            if (soldadoMayorVida == null || soldado.getVida() > soldadoMayorVida.getVida()) {
                soldadoMayorVida = soldado;
            }
        }

        double promedioVida = (ejercito.size() > 0) ? (double) sumaVida / ejercito.size() : 0;
        promedioVida = Math.round(promedioVida * 100.0) / 100.0;

        System.out.println("Soldado con mayor vida: " + soldadoMayorVida);
        System.out.println("Promedio de vida: " + promedioVida);

        System.out.println("\nSoldados en orden de creación:");
        for (Soldado soldado : ejercito) {
            System.out.println(soldado);
        }

        System.out.println("\nRanking de soldados (burbuja):");
        ArrayList<Soldado> ejercitoOrdenadoBurbuja = new ArrayList<>(ejercito);
        ordenarPorVidaBurbuja(ejercitoOrdenadoBurbuja);
        for (Soldado soldado : ejercitoOrdenadoBurbuja) {
            System.out.println(soldado);
        }

        System.out.println("\nRanking de soldados (selección):");
        ArrayList<Soldado> ejercitoOrdenadoSeleccion = new ArrayList<>(ejercito);
        ordenarPorVidaSeleccion(ejercitoOrdenadoSeleccion);
        for (Soldado soldado : ejercitoOrdenadoSeleccion) {
            System.out.println(soldado);
        }
    }
    // Método para ordenar por vida usando burbuja
    public static void ordenarPorVidaBurbuja(ArrayList<Soldado> soldados) {
        for (int i = 0; i < soldados.size() - 1; i++) {
            for (int j = 0; j < soldados.size() - i - 1; j++) {
                if (soldados.get(j).getVida() < soldados.get(j + 1).getVida()) {
                    Soldado temp = soldados.get(j);
                    soldados.set(j, soldados.get(j + 1));
                    soldados.set(j + 1, temp);
                }
            }
        }
    }

    // Método para ordenar por vida usando selección
    public static void ordenarPorVidaSeleccion(ArrayList<Soldado> soldados) {
        for (int i = 0; i < soldados.size() - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < soldados.size(); j++) {
                if (soldados.get(j).getVida() > soldados.get(maxIdx).getVida()) {
                    maxIdx = j;
                }
            }
            Soldado temp = soldados.get(maxIdx);
            soldados.set(maxIdx, soldados.get(i));
            soldados.set(i, temp);
        }
    }    
    
}
