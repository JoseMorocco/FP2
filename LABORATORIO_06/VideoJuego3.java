package LABORATORIO_06;
import java.util.*;
public class VideoJuego3 {
    public static void main(String[] args) {
        Random random = new Random();
        int tTablero = 10;

        // Inicializamos el número de soldados para cada ejército
        int nSoldados1 = random.nextInt(10) + 1;
        int nSoldados2 = random.nextInt(10) + 1;
        System.out.println("Se generarán " + nSoldados1 + " Soldados para el Ejército1");
        System.out.println("Se generarán " + nSoldados2 + " Soldados para el Ejército2");

		// Creamos el tablero vacío
		ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>();
		for (int i = 0; i < tTablero; i++) {
			ArrayList<Soldado> fila = new ArrayList<>();
			for (int j = 0; j < tTablero; j++) {
				fila.add(null); // Agregar null para cada posición de la fila
			}
			tablero.add(fila); // Agregar la fila completa al tablero
		}

        // Inicializamos los ejércitos
		ArrayList<Soldado> ejercito1 = new ArrayList<>();
		ArrayList<Soldado> ejercito2 = new ArrayList<>();

		// Colocamos soldados en el tablero
		ingresarSoldadosTablero(nSoldados1, tablero, ejercito1, 1);
		ingresarSoldadosTablero(nSoldados2, tablero, ejercito2, 2);

		// Mostramos el tablero con los soldados
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
	public static void ingresarSoldadosTablero(int nSoldados, ArrayList<ArrayList<Soldado>> tablero,
			ArrayList<Soldado> ejercito, int idEjercito) {
		Random random = new Random();
		int tTablero = tablero.size();

        for (int i = 0; i < nSoldados; i++) {
            int fila, columna;
            do {
                fila = random.nextInt(tTablero);
                columna = random.nextInt(tTablero);
            } while (tablero.get(fila).get(columna) != null);

            int vida = random.nextInt(5) + 1;
            String nombre = "Soldado" + i + "X" + idEjercito;
            Soldado soldado = new Soldado(nombre, vida, fila, columna);
            tablero.get(fila).set(columna, soldado);
            ejercito.add(soldado);
        }
    }

   
   
   
	// Método para mostrar el tablero
	public static void mostrarTablero(ArrayList<ArrayList<Soldado>> tablero) {
		// Mostrar las letras horizontales (A-J) 
		System.out.print("    ");
		for (char letra = 'A'; letra <= 'J'; letra++) {
			System.out.print("  " + letra + "  ");
		}
		System.out.println();

		// Mostrar el tablero con numeración vertical (1-10)
		for (int i = 0; i < tablero.size(); i++) {
			if (i + 1 < 10) {
				System.out.print(" " + (i + 1) + "  "); // Tres espacios para alinear los números de una cifra
			} else {
				System.out.print((i + 1) + "  "); // Dos espacios para los números de dos cifras
			}
			// Mostrar las celdas del tablero
	        for (int j = 0; j < tablero.get(i).size(); j++) {
	            Soldado soldado = tablero.get(i).get(j);
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

	    // Encontrar soldado con mayor vida 
	    Soldado soldadoMayorVida = null;
	    int sumaVida = 0;

	    for (Soldado soldado : ejercito) {
	        sumaVida += soldado.getVida();
	        
	        if (soldadoMayorVida == null) {
	            soldadoMayorVida = soldado;
	        } else if (soldado.getVida() > soldadoMayorVida.getVida()) {
	            soldadoMayorVida = soldado;
	        }
	    }

	    // Calcular promedio de vida 
	    double promedioVida;
	    if (ejercito.isEmpty()) {
	        promedioVida = 0;
	    } else {
	        promedioVida = (double) sumaVida / ejercito.size();
	        promedioVida = Math.round(promedioVida * 100.0) / 100.0;
	    }

	    System.out.println("Soldado con mayor vida: " + soldadoMayorVida);
	    System.out.println("Promedio de vida: " + promedioVida);

	    // Mostrar soldados en orden de creación
	    System.out.println("\nSoldados en orden de creación:");
	    for (Soldado soldado : ejercito) {
	        System.out.println(soldado);
	    }

	    // Ranking con burbuja
	    ArrayList<Soldado> ejercitoOrdenadoBurbuja = new ArrayList<>(ejercito);
	    ordenarPorVidaBurbuja(ejercitoOrdenadoBurbuja);
	    System.out.println("\nRanking de soldados (burbuja):");
	    for (Soldado soldado : ejercitoOrdenadoBurbuja) {
	        System.out.println(soldado);
	    }

	    // Ranking con selección
	    ArrayList<Soldado> ejercitoOrdenadoSeleccion = new ArrayList<>(ejercito);
	    ordenarPorVidaSeleccion(ejercitoOrdenadoSeleccion);
	    System.out.println("\nRanking de soldados (selección):");
	    for (Soldado soldado : ejercitoOrdenadoSeleccion) {
	        System.out.println(soldado);
	    }
	}
        
	   
   
    // Método para ordenar por vida usando burbuja
    public static void ordenarPorVidaBurbuja(ArrayList<Soldado>soldados) {
        for (int i = 0; i < soldados.size() - 1; i++) {
            for (int j = 0; j < soldados.size() - i - 1; j++) {
                if (soldados.get(j).getVida() < soldados.get(j+1).getVida()) {
                    Soldado temp = soldados.get(j);
                    soldados.set(j,soldados.get(j+1));
                    soldados.set(j+1, temp);                  
                }
            }
        }
    }
   
    // Método para ordenar por vida usando selección
    public static void ordenarPorVidaSeleccion(ArrayList<Soldado>soldados) {
        for (int i = 0; i < soldados.size() - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < soldados.size(); j++) {
                if (soldados.get(j).getVida() > soldados.get(maxIdx).getVida()) {
                    maxIdx = j;
                }
            }
            Soldado temp = soldados.get(maxIdx);
            soldados.set(maxIdx,soldados.get(i));
            soldados.set(i, temp);                  
        }
    }
}