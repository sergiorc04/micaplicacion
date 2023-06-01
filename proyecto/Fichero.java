import java.io.*;
import java.util.*;

public class Fichero extends Caracteristicas{
	
	public static void escribir() {
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\usuario\\Escritorio\\personajes.obj"));

	        for (Avatar personaje : personajes) {
	            writer.write(personaje.toString());
	            writer.newLine();
	        }

	        writer.close();
	        System.out.println("Los objetos se han escrito en el archivo correctamente.");
	    } catch (IOException e) {
	        System.out.println("Error al escribir en el archivo: " + e.getMessage());
	    }
	}
	
	public static void leer() {
		try {
	        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\usuario\\Escritorio\\personajes.obj");
	        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

	        try {
	        	Object objeto = objectInputStream.readObject();
	            System.out.println(objeto.toString());
	        } catch (ClassNotFoundException e) {
	            System.out.println("Error al leer el objeto: clase no encontrada");
	        } catch (IOException e) {
	            System.out.println("Fin de archivo alcanzado.");
	        }
	   
	        objectInputStream.close();
	        fileInputStream.close();
	        System.out.println("Archivo leído correctamente.");
	    } catch (IOException e) {
	        System.out.println("Error al leer el archivo: " + e.getMessage());
	    }
	}
	
}
