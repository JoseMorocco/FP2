package LABORATORIO_03;
import java.util.*;
public class DemoBatalla {
    public static void main(String[] args) {
        Nave[] misNaves = new Nave[4];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;

        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.print("Fila: ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado (true/false): ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();

            misNaves[i] = new Nave(); // Se crea un objeto Nave y se asigna su referencia a misNaves

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
        
        String respuesta;
        do {
            System.out.println("Desea desordenar las naves? (s/n)");

            respuesta = sc.nextLine().toLowerCase();

            if (respuesta.equals("s")) {
                Nave[] navesDesordenadas = desordenarNaves(misNaves);
                System.out.println("\nNaves desordenadas aleatoriamente:");
                mostrarNaves(navesDesordenadas);
            } else if (!respuesta.equals("n")) {
                System.out.println("Respuesta no válida. Por favor ingrese 's' o 'n'.");
            }

        } while (!respuesta.equals("n"));
    }

    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for (Nave nave : flota) {
            System.out.println("Nombre: " + nave.getNombre() + ", Fila: " + nave.getFila() + 
                ", Columna: " + nave.getColumna() + ", Estado: " + nave.getEstado() + 
                ", Puntos: " + nave.getPuntos());
        }
    }

    // Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave[] flota) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el nombre de la nave a buscar: ");
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

    // Método para mostrar todas las naves con un número de puntos inferior o igual
    // al número de puntos que se pide por teclado
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

    // Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave[] flota) {
        Nave naveMayorPuntos = flota[0];
        for (Nave nave : flota) {
            if (nave.getPuntos() > naveMayorPuntos.getPuntos()) {
                naveMayorPuntos = nave;
            }
        }
        return naveMayorPuntos;
    }
    // Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos 
    //     previamente ingresados pero aleatoriamente desordenados
    public static void desordenarNavesRecursivo(Nave[] flota, int n) {
        //si n es 1, no hay más elementos para intercambiar
        if (n == 1) {
            return;
        }

        // Elegir un índice aleatorio entre 0 y n-1
        Random aleatorio = new Random();
        int j = aleatorio.nextInt(n);

        // Intercambiar flota[n-1] con flota[j]
        Nave temp = flota[n - 1];
        flota[n - 1] = flota[j];
        flota[j] = temp;

        // Llamada recursiva para desordenar los primeros n-1 elementos
        desordenarNavesRecursivo(flota, n - 1);
    }
    public static Nave[] desordenarNaves(Nave[] flota) {
        // Crear una copia del arreglo original 
        Nave[] navesDesordenadas = new Nave[flota.length];
        System.arraycopy(flota, 0, navesDesordenadas, 0, flota.length);
        
        // Desordenamos el arreglo
        desordenarNavesRecursivo(navesDesordenadas, flota.length);
        return navesDesordenadas;
    }
}