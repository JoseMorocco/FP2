package EJERCICIOS;
import java.util.*;
public class VideoJuego2 {
    public static void main(String[] args) {
        Random random = new Random();
        int nSoldados=random.nextInt(10)+1;
        int tTablero=10;
        System.out.println("Se generaran "+nSoldados+" Soldados");     
        
        Soldado[][] tablero = new Soldado[tTablero][tTablero];
        Soldado[] soldadosCreados = new Soldado[nSoldados];

        // Crear soldados y colocarlos en el tablero
        for (int i = 0; i < nSoldados; i++) {
            int fila, columna;          
            do {
                fila = random.nextInt(tTablero);
                columna = random.nextInt(tTablero);
            } while (tablero[fila][columna] != null);

            // Generar nivel de vida aleatorio          
            int nivelVida = random.nextInt(5) + 1; // Nivel de vida entre 1 y 5
            String nombre = "Soldado" + i;
            Soldado soldado = new Soldado(nombre, nivelVida, fila, columna);
            tablero[fila][columna] = soldado;
            soldadosCreados[i] = soldado;
        }
        

        // Mostrar el tablero
        mostrarTablero(tablero);
        
        // Encontrar el soldado con mayor nivel de vida
        Soldado soldadoMayorVida = soldadosCreados[0];
        int sumaTotalVida = 0;
        
        for (Soldado soldado : soldadosCreados) {
            sumaTotalVida += soldado.getVida();
            if (soldado.getVida() > soldadoMayorVida.getVida()) {
                soldadoMayorVida = soldado;
            }
        }

        double promedioVida = (double) sumaTotalVida / nSoldados;

        System.out.println("\nSoldado con mayor nivel de vida: " + soldadoMayorVida);
        System.out.println("Promedio de nivel de vida: " + promedioVida);
        System.out.println("Nivel de vida total del ejercito: " + sumaTotalVida);
        
        // Mostrar los soldados en el orden de creación
        System.out.println("\nSoldados creados en orden:");
        for (Soldado soldado : soldadosCreados) {
            System.out.println(soldado);
        }
        
        // Ordenar soldados por nivel de vida (burbuja) y mostrar ranking
        ordenarPorVidaBurbuja(soldadosCreados);
        System.out.println("\nRanking de soldados (burbuja):");
        for (Soldado soldado : soldadosCreados) {
            System.out.println(soldado);
        }
        
        // Ordenar soldados por nivel de vida (selección) y mostrar ranking
        ordenarPorVidaSeleccion(soldadosCreados);
        System.out.println("\nRanking de soldados (seleccion):");
        for (Soldado soldado : soldadosCreados) {
            System.out.println(soldado);
        }
    }
    // Método para mostrar el tablero
    public static void mostrarTablero(Soldado[][] tablero) {
        // Mostrar las letras horizontales (A-J) centradas
        System.out.print("    ");  
        for (char letra = 'A'; letra <= 'J'; letra++) {
            System.out.print("  " + letra + "  ");
        }
        System.out.println();    
        
        // Mostrar el tablero con numeración vertical (1-10)
        for (int i = 0; i < tablero.length; i++) {
            if (i + 1 < 10) {
                System.out.print(" " + (i + 1) + "  "); // Tres espacios para alinear los números de una cifra
            } else {
                System.out.print((i + 1) + "  "); // Dos espacios para los números de dos cifras
            }
            // Mostrar las celdas del tablero
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("|____");
                } else {
                    System.out.print("| S  ");
                }
            }
            System.out.println("|");
        }
    }
    
    // Método para ordenar por vida usando burbuja
    public static void ordenarPorVidaBurbuja(Soldado[] soldados) {
        for (int i = 0; i < soldados.length - 1; i++) {
            for (int j = 0; j < soldados.length - i - 1; j++) {
                if (soldados[j].getVida() < soldados[j + 1].getVida()) {
                    Soldado temp = soldados[j];
                    soldados[j] = soldados[j + 1];
                    soldados[j + 1] = temp;
                }
            }
        }
    }
    
    // Método para ordenar por vida usando selección
    public static void ordenarPorVidaSeleccion(Soldado[] soldados) {
        for (int i = 0; i < soldados.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < soldados.length; j++) {
                if (soldados[j].getVida() > soldados[maxIdx].getVida()) {
                    maxIdx = j;
                }
            }
            Soldado temp = soldados[maxIdx];
            soldados[maxIdx] = soldados[i];
            soldados[i] = temp;
        }
    }
}