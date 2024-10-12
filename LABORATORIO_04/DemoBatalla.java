package LABORATORIO_04;
import java.util.*;
public class DemoBatalla {
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[8];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;

        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.nextLine();
            System.out.print("Fila: ");
            fil = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Columna: ");
            col = sc.nextLine();
            System.out.print("Estado (true/false): ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();
            sc.nextLine(); 

            misNaves[i] = new Nave();
            
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }

        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        mostrarPorNombre(misNaves);
        mostrarPorPuntos(misNaves);
        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves).getNombre());

        
        System.out.println("Ingrese el nombre que desea buscar(Usando busqueda Lineal): ");
        String nombre = sc.nextLine();
        
        int pos = busquedaLinealNombre(misNaves, nombre);
        
        if (pos != -1) {
            System.out.println("Nave encontrada en la posicion: "+pos );
            System.out.println("Nombre: " + misNaves[pos].getNombre() + ", Fila: " + misNaves[pos].getFila() +
                    ", Columna: " + misNaves[pos].getColumna() + ", Estado: " + misNaves[pos].getEstado() +
                    ", Puntos: " + misNaves[pos].getPuntos());
        } else {
            System.out.println("Nave no encontrada.");
        }
        System.out.println("==========================================================");
        
        System.out.println("Ordenamiento burbuja por puntos(menor a mayor):");
        ordenarPorPuntosBurbuja(misNaves);
        mostrarNaves(misNaves);
        System.out.println("==========================================================");
        
        System.out.println("Ordenamiento burbuja por nombre(A a Z)");
        ordenarPorNombreBurbuja(misNaves);
        mostrarNaves(misNaves);      
        System.out.println("=========================================================="); 
       
        System.out.println("Ingrese el nombre que desea buscar(Usando busqueda Binaria): ");
        nombre = sc.nextLine();
        pos = busquedaBinariaNombre(misNaves, nombre);
        if (pos != -1) {
            System.out.println("Nave encontrada en la posicion: "+pos );
            System.out.println("Nombre: " + misNaves[pos].getNombre() + ", Fila: " + misNaves[pos].getFila() +
                    ", Columna: " + misNaves[pos].getColumna() + ", Estado: " + misNaves[pos].getEstado() +
                    ", Puntos: " + misNaves[pos].getPuntos());
        } else {
            System.out.println("Nave no encontrada.");
        }
        System.out.println("==========================================================");
        
        System.out.println("Ordenamiento por seleccion según puntos(menor a mayor)");
        ordenarPorPuntosSeleccion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("==========================================================");
        
        System.out.println("Ordenamiento por seleccion según nombres(A a Z)");
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("==========================================================");
        
        System.out.println("Ordenamiento por insercion según puntos(mayor a menor)");
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("==========================================================");
        
        System.out.println("Ordenamiento por insercion según nombres(Z a A)");
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);
    }

    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for (Nave nave : flota) {
            System.out.println("Nombre: " + nave.getNombre() + ", Fila: " + nave.getFila() +
                ", Columna: " + nave.getColumna() + ", Estado: " + nave.getEstado() +
                ", Puntos: " + nave.getPuntos());
        }
    }

    // Método para mostrar todas las naves por nombre solicitado
    public static void mostrarPorNombre(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el nombre de todas las naves a buscar: ");
        String nombreBuscado = sc.next();

        System.out.println("Naves con nombre '" + nombreBuscado + "':");
        for (Nave nave : flota) {
            if (nave.getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Nombre: " + nave.getNombre() + ", Fila: " + nave.getFila() +
                    ", Columna: " + nave.getColumna() + ", Estado: " + nave.getEstado() +
                    ", Puntos: " + nave.getPuntos());
            }
        }
    }

    // Método para mostrar todas las naves con puntos menores o iguales al solicitado
    public static void mostrarPorPuntos(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el número máximo de puntos: ");
        int puntosMaximos = sc.nextInt();

        System.out.println("Naves con puntos menores o iguales a " + puntosMaximos + ":");
        for (Nave nave : flota) {
            if (nave.getPuntos() <= puntosMaximos) {
                System.out.println("Nombre: " + nave.getNombre() + ", Fila: " + nave.getFila() +
                    ", Columna: " + nave.getColumna() + ", Estado: " + nave.getEstado() +
                    ", Puntos: " + nave.getPuntos());
            }
        }
    }

    // Método que devuelve la Nave con mayor número de puntos
    public static Nave mostrarMayorPuntos(Nave[] flota) {
        Nave naveMayorPuntos = flota[0];
        for (Nave nave : flota) {
            if (nave.getPuntos() > naveMayorPuntos.getPuntos()) {
                naveMayorPuntos = nave;
            }
        }
        return naveMayorPuntos;
    }
    
	// Método de búsqueda lineal por nombre
	// Recorre cada nave en la flota, compara su nombre con el nombre buscado y
	// retorna el índice si hay coincidencia.
	public static int busquedaLinealNombre(Nave[] flota, String s) {
		for (int i = 0; i < flota.length; i++) {
			if (flota[i].getNombre().equalsIgnoreCase(s)) {
				return i;
			}
		}
		return -1; // No se encontró el nombre
	}

	// Método de búsqueda binaria por nombre
	// Divide la flota en partes y compara el nombre del centro con el nombre
	// buscado para reducir el rango de búsqueda.
	public static int busquedaBinariaNombre(Nave[] flota, String s) {
		int izquierda = 0, derecha = flota.length - 1;

		while (izquierda <= derecha) {
			int medio = (izquierda + derecha) / 2;
			String nombreMedio = flota[medio].getNombre();

			int comparacion = s.compareToIgnoreCase(nombreMedio);
			if (comparacion == 0) {
				return medio; // Nombre encontrado
			} else if (comparacion < 0) {
				derecha = medio - 1; // Busca en la mitad izquierda
			} else {
				izquierda = medio + 1; // Busca en la mitad derecha
			}
		}
		return -1; // No se encontró el nombre
	}

	// Ordenar por puntos de menor a mayor (Burbuja)
	// Compara naves adyacentes por puntos y las intercambia si están en orden
	// incorrecto, repitiendo hasta ordenar.
	public static void ordenarPorPuntosBurbuja(Nave[] flota) {
		for (int i = 1; i < flota.length; i++) {
			for (int j = 0; j < flota.length - i; j++) {
				if (flota[j].getPuntos() > flota[j + 1].getPuntos()) {
					Nave temp = flota[j];
					flota[j] = flota[j + 1];
					flota[j + 1] = temp;
				}
			}
		}
	}

	// Ordenar por nombre de A a Z (Burbuja)
	// Compara naves adyacentes por nombre y las intercambia si están en orden
	// incorrecto, repitiendo hasta ordenar.
	public static void ordenarPorNombreBurbuja(Nave[] flota) {
		for (int i = 1; i < flota.length; i++) {
			for (int j = 0; j < flota.length - i; j++) {
				if (flota[j].getNombre().compareToIgnoreCase(flota[j + 1].getNombre()) > 0) {
					Nave temp = flota[j];
					flota[j] = flota[j + 1];
					flota[j + 1] = temp;
				}
			}
		}
	}

	// Ordenar por puntos (Selección)
	// Encuentra la nave con menos puntos en el rango restante y la coloca en su
	// posición correcta.
	public static void ordenarPorPuntosSeleccion(Nave[] flota) {
		for (int i = 0; i < flota.length - 1; i++) {
			int indiceMin = i;
			for (int j = i + 1; j < flota.length; j++) {
				if (flota[j].getPuntos() < flota[indiceMin].getPuntos()) {
					indiceMin = j;
				}
			}
			if (indiceMin != i) {
				Nave temp = flota[i];
				flota[i] = flota[indiceMin];
				flota[indiceMin] = temp;
			}
		}
	}
 
	// Ordenar por nombre (Selección)
	// Encuentra el nombre alfabéticamente menor en el rango restante y lo coloca en
	// su posición correcta.
	public static void ordenarPorNombreSeleccion(Nave[] flota) {
		for (int i = 0; i < flota.length - 1; i++) {
			int indiceMin = i;
			for (int j = i + 1; j < flota.length; j++) {
				if (flota[j].getNombre().compareToIgnoreCase(flota[indiceMin].getNombre()) < 0) {
					indiceMin = j;
				}
			}
			if (indiceMin != i) {
				Nave temp = flota[i];
				flota[i] = flota[indiceMin];
				flota[indiceMin] = temp;
			}
		}
	}

	// Ordenar por puntos (Inserción)
	// Inserta cada nave en la posición correcta dentro de la lista, comparando los
	// puntos de mayor a menor.
	public static void ordenarPorPuntosInsercion(Nave[] flota) {
		for (int i = 1; i < flota.length; i++) {
			Nave temp = flota[i];
			int j = i - 1;
			while (j >= 0 && flota[j].getPuntos() < temp.getPuntos()) {
				flota[j + 1] = flota[j];
				j--;
			}
			flota[j + 1] = temp;
		}
	}

	// Ordenar por nombre (Inserción)
	// Inserta cada nave en la posición correcta dentro de la lista, comparando los
	// nombres de Z a A.
	public static void ordenarPorNombreInsercion(Nave[] flota) {
		for (int i = 1; i < flota.length; i++) {
			Nave temp = flota[i];
			int j = i - 1;
			while (j >= 0 && flota[j].getNombre().compareToIgnoreCase(temp.getNombre()) < 0) {
				flota[j + 1] = flota[j];
				j--;
			}
			flota[j + 1] = temp;
		}
    }
}
