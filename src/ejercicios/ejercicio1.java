package ejercicios;
//Laboratorio N° 02 -Ejercicio1
//Autor:Jose Manuel Morocco Saico
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
    	//Etapas el ahorcado: 
        String ahor1 = " +---+ \n" +
                " |   | \n" +
                "     | \n" +
                "     | \n" +
                "     | \n" +
                "     | \n" +
                "========= ";
        String ahor2 = " +---+ \n" +
                " |   | \n" +
                " O   | \n" +
                "     | \n" +
                "     | \n" +
                "     | \n" +
                "=========";

        String ahor3 = " +---+ \n" +
                " |   | \n" +
                " O   | \n" +
                " |   | \n" +
                "     | \n" +
                "     | \n" +
                "=========";

        String ahor4 = " +---+ \n" +
                " |   | \n" +
                " O   | \n" +
                " /|  | \n" +
                "     | \n" +
                "     | \n" +
                "=========";

        String ahor5 = " +---+ \n" +
                " |   | \n" +
                " O   | \n" +
                "/|\\  | \n" +
                "     | \n" +
                "     | \n" +
                "=========";

        String ahor6 = " +---+ \n" +
                " |   | \n" +
                " O   | \n" +
                "/|\\  | \n" +
                " /   | \n" +
                "     | \n" +
                "=========";

        String ahor7 = " +---+ \n" +
                " |   | \n" +
                " O   | \n" +
                "/|\\  | \n" +
                "/ \\  | \n" +
                "     | \n" +
                "=========";
        
        // Arreglo con todas las figuras del ahorcado
        String[] figuras = { ahor1, ahor2, ahor3, ahor4, ahor5, ahor6, ahor7 };
        
        int contador = 0; // Contador de errores
        String letra;  // Variable para la letra ingresada por el usuario
        
        // Lista de palabras que pueden ser seleccionadas para el juego
        String[] palabras = { "programacion", "java", "indentacion", "clases", "objetos", "desarrollador", "pruebas" };
        
        // Seleccionar una palabra secreta al azar
        String palSecreta = getPalabraSecreta(palabras);
        
        System.out.println(figuras[0]);

        // Mostrar guiones con el tamaño de la palabra secreta
        String palabraPorAdivinar = generarBlancos(palSecreta.length());
        System.out.println(palabraPorAdivinar);
        System.out.println("\n");

        // Bucle principal del juego: se repite mientras no se supere el límite de 
        //errores y no se haya adivinado la palabra
        while (contador < 6 && palabraPorAdivinar.contains("_")) {
            letra = ingreseLetra();
            
            // Verificar si la letra está en la palabra secreta
            if (letraEnPalabraSecreta(letra, palSecreta)) {
                // Actualizar la palabra por adivinar con la letra encontrada
                palabraPorAdivinar = actualizarBlancos(letra, palabraPorAdivinar, palSecreta);
            } else {
                contador++;  // Incrementar el contador de errores
            }

            // Mostrar la figura y el progreso después de cada intento
            System.out.println(figuras[contador]);  // Mostrar la figura correcta
            System.out.println(palabraPorAdivinar); // Mostrar la palabra con guiones y letras adivinadas
        }

        // Verificar si perdió o ganó
        if (palabraPorAdivinar.contains("_")) {
            System.out.println("Perdiste. La palabra secreta era: " + palSecreta);
        } else {
            System.out.println("¡Ganaste! Adivinaste la palabra en " + (contador + 1) + " turnos.");
        }
        System.out.println("\n");
    }
    
    // Método que selecciona una palabra secreta al azar del arreglo de palabras
    public static String getPalabraSecreta(String[] lasPalabras) {
        int ind;
        int indiceMayor = lasPalabras.length - 1;
        int indiceMenor = 0;
        ind = (int) ((Math.random() * (indiceMayor - indiceMenor + 1)) + indiceMenor);
        return lasPalabras[ind];
    }

    // Método que genera una cadena de guiones bajos del mismo tamaño que la palabra secreta
    public static String generarBlancos(int longitud) {
        String blancos = "";
        String blanco = "_";
        for (int i = 0; i < longitud; i++) {
            blancos += blanco;
        }
        return blancos;
    }
    
    // Método que solicita una letra válida al usuario
    public static String ingreseLetra() {
        String laLetra;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese letra: ");
        laLetra = sc.next();
        char letra = laLetra.charAt(0);
        
        // Asegurarse de que la entrada sea una única letra y no un número
        while (laLetra.length() != 1 || Character.isDigit(letra)) {
            System.out.println("Ingrese letra: ");
            laLetra = sc.next();
            letra = laLetra.charAt(0);
        }
        return laLetra;
    }
    
    // Método que verifica si la letra está en la palabra secreta
    public static boolean letraEnPalabraSecreta(String letra, String palSecreta) {
        for (int i = 0; i < palSecreta.length(); i++) {
            if (letra.charAt(0) == palSecreta.charAt(i))
                return true;
        }
        return false;
    }
    
    // Método que actualiza los guiones bajos de la palabra por adivinar con la letra correcta
    public static String actualizarBlancos(String letra, String palabraPorAdivinar, String palSecreta) {
        char[] blancosActualizados = palabraPorAdivinar.toCharArray();// Convertir palabra a adivinar en array de caracteres
        for (int i = 0; i < palSecreta.length(); i++) {
            if (palSecreta.charAt(i) == letra.charAt(0)) {
                blancosActualizados[i] = letra.charAt(0);// Actualizar las posiciones correctas con la letra ingresada
            }
        }
        return new String(blancosActualizados);// Devolver la palabra actualizada como cadena
    }
}