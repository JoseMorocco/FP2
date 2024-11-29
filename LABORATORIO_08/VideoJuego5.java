package LABORATORIO_08;
import java.util.*;
public class VideoJuego5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // BIENVENIDA AL USUARIO
        System.out.println("¡Bienvenido al simulador de batalla!");

        // CICLO PRINCIPAL QUE PERMITE REPETIR EL PROCESO SEGÚN LA ELECCIÓN DEL USUARIO
        boolean continuar = true;
        while (continuar) {
            Random random = new Random();
            int tTablero = 10; // TAMAÑO DEL TABLERO (10x10)

            // GENERAMOS NÚMERO ALEATORIO DE SOLDADOS PARA CADA EJÉRCITO
            int nSoldados1 = random.nextInt(10) + 1; // SOLDADOS EJÉRCITO 1
            int nSoldados2 = random.nextInt(10) + 1; // SOLDADOS EJÉRCITO 2
            System.out.println("Se generarán " + nSoldados1 + " Soldados para el Ejército1");
            System.out.println("Se generarán " + nSoldados2 + " Soldados para el Ejército2");

            // CREACIÓN DEL TABLERO COMO ARREGLO BIDIMENSIONAL VACÍO
            Soldado[][] tablero = new Soldado[tTablero][tTablero];

            // INICIALIZACIÓN DE EJÉRCITOS COMO HASHMAPS
            HashMap<Integer, Soldado> ejercito1 = new HashMap<>();
            HashMap<Integer, Soldado> ejercito2 = new HashMap<>();

            // COLOCAMOS LOS SOLDADOS EN EL TABLERO Y LOS ASIGNAMOS A SUS EJÉRCITOS
            ingresarSoldadosTablero(nSoldados1, tablero, ejercito1, 1);
            ingresarSoldadosTablero(nSoldados2, tablero, ejercito2, 2);

            // MOSTRAMOS EL ESTADO DEL TABLERO
            mostrarTablero(tablero);

            // MOSTRAMOS LAS ESTADÍSTICAS DE CADA EJÉRCITO
            mostrarEstadisticas(ejercito1, "Ejército 1");
            mostrarEstadisticas(ejercito2, "Ejército 2");

            // COMPARAMOS LAS VIDAS TOTALES PARA DETERMINAR EL GANADOR
            String ganador;
            if (sumaVida(ejercito1) > sumaVida(ejercito2)) {
                ganador = "Ejército 1";
            } else {
                ganador = "Ejército 2";
            }
            System.out.println("El ganador de la batalla es: " + ganador);

            // PREGUNTAMOS SI EL USUARIO QUIERE REALIZAR OTRA SIMULACIÓN
            System.out.print("\n¿Desea realizar otra simulación? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();
            if (!respuesta.equals("s")) {
                continuar = false; // TERMINAMOS EL CICLO SI LA RESPUESTA NO ES "s"
            }
        }
        // DESPEDIDA
        System.out.println("¡Gracias por jugar! Hasta la próxima.");
    }

    // ---> MÉTODO PARA SUMAR LA VIDA TOTAL DE UN EJÉRCITO
    public static int sumaVida(HashMap<Integer, Soldado> ejercito) {
        int suma = 0;
        for (Soldado soldado : ejercito.values()) {
            suma += soldado.getVida(); // SUMAMOS LA VIDA DE CADA SOLDADO
        }
        return suma;
    }

    // ---> MÉTODO PARA INGRESAR SOLDADOS EN EL TABLERO Y EJÉRCITO
    public static void ingresarSoldadosTablero(int nSoldados, Soldado[][] tablero, HashMap<Integer, Soldado> ejercito,
            int idEjercito) {
        Random random = new Random();
        int tTablero = tablero.length; // TAMAÑO DEL TABLERO

        for (int i = 0; i < nSoldados; i++) {
            int fila, columna;
            do {
                fila = random.nextInt(tTablero); // GENERAMOS COORDENADAS ALEATORIAS
                columna = random.nextInt(tTablero);
            } while (tablero[fila][columna] != null); // VERIFICAMOS QUE LA CASILLA ESTÉ VACÍA

            int vida = random.nextInt(5) + 1; // ASIGNAMOS UNA VIDA ALEATORIA (1-5)
            String nombre = "Soldado" + i + "X" + idEjercito;
            Soldado soldado = new Soldado(nombre, vida, fila, columna);
            tablero[fila][columna] = soldado; // COLOCAMOS AL SOLDADO EN EL TABLERO
            ejercito.put(i, soldado); // AÑADIMOS AL SOLDADO AL EJÉRCITO
        }
    }

    // ---> MÉTODO PARA MOSTRAR EL TABLERO 
    public static void mostrarTablero(Soldado[][] tablero) {
        // MOSTRAMOS LAS LETRAS DE LAS COLUMNAS
        System.out.print("    ");
        for (char letra = 'A'; letra < 'A' + tablero.length; letra++) {
            System.out.print("  " + letra + "  ");
        }
        System.out.println();

        // RECORREMOS FILAS Y COLUMNAS DEL TABLERO
        for (int i = 0; i < tablero.length; i++) {
            System.out.printf("%2d  ", i + 1); // NÚMERO DE FILA
            for (int j = 0; j < tablero[i].length; j++) {
                Soldado soldado = tablero[i][j];
                if (soldado == null) { // CASILLA VACÍA
                    System.out.print("|____");
                } else if (soldado.getNombre().contains("X1")) { // SOLDADO DEL EJÉRCITO 1
                    System.out.print("| S1 ");
                } else { // SOLDADO DEL EJÉRCITO 2
                    System.out.print("| S2 ");
                }
            }
            System.out.println("|"); // CERRAMOS LA FILA
        }
    }

    // ---> MÉTODO PARA MOSTRAR ESTADÍSTICAS DE UN EJÉRCITO
    public static void mostrarEstadisticas(HashMap<Integer, Soldado> ejercito, String nombreEjercito) {
        System.out.println("\nEstadísticas de " + nombreEjercito + ":");

        Soldado soldadoMayorVida = null; // SOLDADO CON MAYOR VIDA
        int sumaVida = 0; // SUMA TOTAL DE VIDAS

        // RECORREMOS TODOS LOS SOLDADOS DEL EJÉRCITO
        for (Soldado soldado : ejercito.values()) {
            sumaVida += soldado.getVida(); // SUMAMOS LAS VIDAS
            if (soldadoMayorVida == null || soldado.getVida() > soldadoMayorVida.getVida()) {
                soldadoMayorVida = soldado; // ACTUALIZAMOS AL SOLDADO CON MÁS VIDA
            }
        }

        double promedioVida = (ejercito.size() > 0) ? (double) sumaVida / ejercito.size() : 0; // PROMEDIO DE VIDAS
        promedioVida = Math.round(promedioVida * 100.0) / 100.0; // REDONDEO A 2 DECIMALES

        // MOSTRAMOS LOS RESULTADOS
        System.out.println("Soldado con mayor vida: " + soldadoMayorVida);
        System.out.println("Promedio de vida: " + promedioVida);

        // ORDENAMOS Y MOSTRAMOS SOLDADOS
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

    // ---> MÉTODO BURBUJA PARA ORDENAR SOLDADOS POR VIDA
    public static void ordenarPorVidaBurbuja(List<Soldado> soldados) {
        for (int i = 0; i < soldados.size() - 1; i++) {
            for (int j = 0; j < soldados.size() - i - 1; j++) {
                if (soldados.get(j).getVida() < soldados.get(j + 1).getVida()) {
                    Soldado temp = soldados.get(j); // INTERCAMBIAMOS POSICIONES
                    soldados.set(j, soldados.get(j + 1));
                    soldados.set(j + 1, temp);
                }
            }
        }
    }

    // --> ESTE MÉTODO ENCUENTRA EL SOLDADO CON LA VIDA MÁS ALTA EN CADA ITERACIÓN Y LO COLOCA EN LA POSICIÓN CORRECTA.
public static void ordenarPorVidaSeleccion(List<Soldado> soldados) {
    // --> ITERAMOS SOBRE TODOS LOS SOLDADOS (EXCEPTO EL ÚLTIMO, YA QUE QUEDARÁ ORDENADO AUTOMÁTICAMENTE)
    for (int i = 0; i < soldados.size() - 1; i++) {
        // --> ASUMIMOS QUE EL SOLDADO EN LA POSICIÓN ACTUAL TIENE LA VIDA MÁS ALTA
        int maxIdx = i;

        // --> COMPARAR EL SOLDADO EN maxIdx CON LOS SOLDADOS RESTANTES
        for (int j = i + 1; j < soldados.size(); j++) {
            // --> SI ENCONTRAMOS UN SOLDADO CON MAYOR VIDA, ACTUALIZAMOS maxIdx
            if (soldados.get(j).getVida() > soldados.get(maxIdx).getVida()) {
                maxIdx = j; // --> NUEVA POSICIÓN DEL SOLDADO CON MAYOR VIDA
            }
        }

        // --> INTERCAMBIAMOS EL SOLDADO EN maxIdx CON EL SOLDADO EN LA POSICIÓN ACTUAL (i)
        Soldado temp = soldados.get(maxIdx);
        soldados.set(maxIdx, soldados.get(i));
        soldados.set(i, temp);
    }
}
}
