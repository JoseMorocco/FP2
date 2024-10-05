package LABORATORIO_03;

public class Soldado {
    public String nombre;
    public int nivelDeVida;


    public Soldado(String nombre, int nivelDeVida) {
        this.nombre = nombre;
        this.nivelDeVida = nivelDeVida;
    }
   
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setNivelDeVida(int nivelDeVida){
        this.nivelDeVida=nivelDeVida;
    }
    public String getNombre() {
        return nombre;
    }

    public int getNivelDeVida() {
        return nivelDeVida;
    }
}

