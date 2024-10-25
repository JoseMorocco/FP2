package LABORATORIO_06;

public class Soldado {
	  private String nombre;
	  private int vida;
	  private int fila;
	  private int columna;

	    public Soldado(String nombre, int puntosVida, int fila, int columna) {
	        this.nombre = nombre;
	        this.vida = puntosVida;
	        this.fila = fila;
	        this.columna = columna;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public int getVida() {
	        return vida;
	    }

	    public int getFila() {
	        return fila;
	    }

	    public int getColumna() {
	        return columna;
	    }

	    public String toString() {
	        return nombre + " (Vida: " + vida + ", Pos: [" + (fila+1) + "," + (columna+1) + "])";
	    }    
	}


