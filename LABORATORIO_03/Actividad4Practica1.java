package LABORATORIO_03;
import java.util.Scanner;
public class Actividad4Practica1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear un arreglo para 5 objetos Soldado
        Soldado[] soldados = new Soldado[5];

        // Ingreso de datos
        for (int i = 0; i < soldados.length; i++) {
            System.out.println("Ingrese los datos del soldado " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nivel de vida: ");
            int nivelDeVida = sc.nextInt();            
            sc.nextLine(); 
            //Añadimos los datos arreglo soldado
            soldados[i] = new Soldado(nombre, nivelDeVida);
        }

        // Mostrar los datos de los soldados
        System.out.println("\nDatos de los soldados:");
        for (int i = 0; i < soldados.length; i++) {
            System.out.println("Soldado " + (i + 1) + ":"+"Nombre: " + soldados[i].getNombre()
            +"   | Nivel de vida: " + soldados[i].getNivelDeVida());
        }

    }
}
