package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String filePathOriginal = "peliculas.csv";
        Integer anhoFiltro = 2000;
        String filePathCopia = "PeliculasPosterioresA" + anhoFiltro + ".csv";

        ArrayList<Pelicula> peliculas = leer(filePathOriginal);

        ArrayList<Pelicula> peliculasFiltradas = filtrarPorAnho(peliculas, anhoFiltro);

        copiarCSV(peliculasFiltradas, filePathCopia);
    }

    public static ArrayList<Pelicula> leer(String filePath) {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {

                String[] datosPelicula = line.split(",");

                if (datosPelicula.length == 5) {
                    Integer id = Integer.parseInt(datosPelicula[0]);
                    String titulo = datosPelicula[1];
                    Integer anho = Integer.parseInt(datosPelicula[2]);
                    String director = datosPelicula[3];
                    String genero = datosPelicula[4];

                    Pelicula pelicula = new Pelicula(id, titulo, anho, director, genero);
                    peliculas.add(pelicula);
                } else {
                    System.out.println("Línea con formato incorrecto: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return peliculas;
    }

    public static ArrayList<Pelicula> filtrarPorAnho(ArrayList<Pelicula> peliculas, Integer anho) {
        ArrayList<Pelicula> peliculasFiltradas = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getAnho() >= anho) {
                peliculasFiltradas.add(pelicula);
            }
        }
        return peliculasFiltradas;
    }

    public static void copiarCSV(ArrayList<Pelicula> peliculas, String filePathCopia) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePathCopia))) {
            for (Pelicula pelicula : peliculas) {
                bw.write(pelicula.getId() + "," + pelicula.getTitulo() + "," + pelicula.getAnho() + "," +
                        pelicula.getDirector() + "," + pelicula.getGenero());
                bw.newLine();
            }
            System.out.println("El archivo ha sido copiado correctamente en " + filePathCopia);
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo: " + e.getMessage());
        }
    }
}















