package LABORATORIO_08;

import java.util.*;

public class VideoJuego5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al simulador de batalla!");

        // CICLO PRINCIPAL QUE PERMITE REPETIR EL PROCESO SEGÚN LA ELECCIÓN DEL USUARIO
        boolean continuar = true;
        while (continuar) {
            Random random = new Random();
            int tTablero = 10;

            // Generamos el número de soldados para cada ejército
            int nSoldados1 = random.nextInt(10) + 1;
            int nSoldados2 = random.nextInt(10) + 1;
            System.out.println("Se generarán " + nSoldados1 + " Soldados para el Ejército1");
            System.out.println("Se generarán " + nSoldados2 + " Soldados para el Ejército2");

            // Creamos el tablero vacío como un arreglo bidimensional
            Soldado[][] tablero = new Soldado[tTablero][tTablero];

            // Inicializamos los ejércitos como HashMap de soldados
            HashMap<Integer, Soldado> ejercito1 = new HashMap<>();
            HashMap<Integer, Soldado> ejercito2 = new HashMap<>();

            // Colocamos soldados en el tablero
            ingresarSoldadosTablero(nSoldados1, tablero, ejercito1, 1);
            ingresarSoldadosTablero(nSoldados2, tablero, ejercito2, 2);

            mostrarTablero(tablero);

            // Mostramos datos de los ejércitos
            mostrarEstadisticas(ejercito1, "Ejército 1");
            mostrarEstadisticas(ejercito2, "Ejército 2");

            // Determinamos el ejército ganador
            String ganador;
            if (sumaVida(ejercito1) > sumaVida(ejercito2)) {
                ganador = "Ejército 1";
            } else {
                ganador = "Ejército 2";
            }
            System.out.println("El ganador de la batalla es: " + ganador);

            // PREGUNTAR AL USUARIO SI DESEA REALIZAR OTRA SIMULACIÓN
            System.out.print("\n¿Desea realizar otra simulación? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();
            if (!respuesta.equals("s")) {
                continuar = false;
            }
        }

        System.out.println("¡Gracias por jugar! Hasta la próxima.");
        scanner.close();
    }

    // Método para sumar vida total de un ejército
    public static int sumaVida(HashMap<Integer, Soldado> ejercito) {
        int suma = 0;
        for (Soldado soldado : ejercito.values()) {
            suma += soldado.getVida();
        }
        return suma;
    }

    // Método para ingresar soldados al tablero y al ejército
    public static void ingresarSoldadosTablero(int nSoldados, Soldado[][] tablero, HashMap<Integer, Soldado> ejercito,
            int idEjercito) {
        Random random = new Random();
        int tTablero = tablero.length;

        for (int i = 0; i < nSoldados; i++) {
            int fila, columna;
            do {
                fila = random.nextInt(tTablero);
                columna = random.nextInt(tTablero);
            } while (tablero[fila][columna] != null); // Aseguramos que no haya dos soldados en la misma casilla

            int vida = random.nextInt(5) + 1;
            String nombre = "Soldado" + i + "X" + idEjercito;
            Soldado soldado = new Soldado(nombre, vida, fila, columna);
            tablero[fila][columna] = soldado;
            ejercito.put(i, soldado); // Usamos el índice como clave para el HashMap
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
    public static void mostrarEstadisticas(HashMap<Integer, Soldado> ejercito, String nombreEjercito) {
        System.out.println("\nEstadísticas de " + nombreEjercito + ":");

        Soldado soldadoMayorVida = null;
        int sumaVida = 0;

        // Encontrar el soldado con mayor vida y sumar las vidas
        for (Soldado soldado : ejercito.values()) {
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
        for (Soldado soldado : ejercito.values()) {
            System.out.println(soldado);
        }

        System.out.println("\nRanking de soldados (burbuja):");
        List<Soldado> soldadosOrdenadosBurbuja = new ArrayList<>(ejercito.values());
        ordenarPorVidaBurbuja(soldadosOrdenadosBurbuja);
        for (Soldado soldado : soldadosOrdenadosBurbuja) {
            System.out.println(soldado);
        }

        System.out.println("\nRanking de soldados (selección):");
        List<Soldado> soldadosOrdenadosSeleccion = new ArrayList<>(ejercito.values());
        ordenarPorVidaSeleccion(soldadosOrdenadosSeleccion);
        for (Soldado soldado : soldadosOrdenadosSeleccion) {
            System.out.println(soldado);
        }
    }

    // Método para ordenar por vida usando selección
    public static void ordenarPorVidaSeleccion(List<Soldado> soldados) {
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

    // Método para ordenar por vida usando burbuja
    public static void ordenarPorVidaBurbuja(List<Soldado> soldados) {
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


}