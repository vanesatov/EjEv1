package org.example;
import java.util.List;



public class FiltroPeliculas {
    private List<Pelicula> peliculas;

    public void filtrarPorAño(Integer anho) {
        boolean encontrado = false;
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getAnho() >= anho) {
                System.out.println(pelicula.getTitulo() + " (" + pelicula.getAnho() + ")");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron películas a partir del año " + anho);
        }
    }
}
