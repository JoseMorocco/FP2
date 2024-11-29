package LABORATORIO_08;

// CLASE QUE REPRESENTA A UN SOLDADO EN EL JUEGO O SISTEMA
public class Soldado {

    // ATRIBUTOS PRIVADOS PARA ALMACENAR EL NOMBRE, VIDA Y POSICIÓN DEL SOLDADO
    private String nombre; // NOMBRE DEL SOLDADO
    private int vida; // PUNTOS DE VIDA DEL SOLDADO
    private int fila; // POSICIÓN EN LA FILA DEL TABLERO O ESCENARIO
    private int columna; // POSICIÓN EN LA COLUMNA DEL TABLERO O ESCENARIO

    // CONSTRUCTOR QUE INICIALIZA LOS ATRIBUTOS DEL SOLDADO
    public Soldado(String nombre, int puntosVida, int fila, int columna) {
        this.nombre = nombre; // ASIGNA EL NOMBRE AL SOLDADO
        this.vida = puntosVida; // ASIGNA LOS PUNTOS DE VIDA INICIALES
        this.fila = fila; // ASIGNA LA FILA DONDE SE UBICA EL SOLDADO
        this.columna = columna; // ASIGNA LA COLUMNA DONDE SE UBICA EL SOLDADO
    }

    // MÉTODO PARA OBTENER EL NOMBRE DEL SOLDADO
    public String getNombre() {
        return nombre; 
    }

    // MÉTODO PARA OBTENER LOS PUNTOS DE VIDA DEL SOLDADO
    public int getVida() {
        return vida; 
    }

    // MÉTODO PARA OBTENER LA FILA DONDE ESTÁ UBICADO EL SOLDADO
    public int getFila() {
        return fila; 
    }

    // MÉTODO PARA OBTENER LA COLUMNA DONDE ESTÁ UBICADO EL SOLDADO
    public int getColumna() {
        return columna; 
    }

    // MÉTODO QUE DEVUELVE UNA REPRESENTACIÓN EN TEXTO DEL SOLDADO
    public String toString() {
        // IMPRIME EL NOMBRE, PUNTOS DE VIDA Y POSICIÓN EN UNA CADENA
        return nombre + " (Vida: " + vida 
        + " | Pos: [" + (fila + 1) + "," + (columna + 1) + "])";
    }
}





