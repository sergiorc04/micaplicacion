import java.util.*;
import java.io.*;

public class Caracteristicas {

	static ArrayList<Avatar> personajes = new ArrayList<Avatar>(); //se crea una lista de tipo Avatar, la clase constructor
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in); //segundo scanner ya que el primero da fallo cuando se usa con String
	int cantpers = 5, puntos;
	Avatar añadido = new Avatar();

	
	public void informar() {  //un método para que no haya mucho texto en pantalla al iniciar el programa
		System.out.println("---------Información----------");
		System.out.println("¡CREA TU EQUIPO PARA JUGAR!");
		System.out.println("Puedes crear hasta 5 personajes, \nse recomienda subir diferentes atributos"
				+ " en cada uno para lograr un equipo equilibrado.\n Dispones de 36 puntos para repartir entre los 4 atributos");
		System.out.println("*Este es un personaje de ejemplo que te sirve como guía para crear tus propios personajes*");
		Avatar base = new Avatar("Pedro", 9, 9, 9, 9);
		base.DatosPersonaje();
		System.out.println("--------Fin información--------");
	}

	public Avatar añadir() {
		if (cantpers>0){  //el método solo funciona si no se ha llegado al límite de personajes creables
			do {
				puntos = 36; //los puntos se resetean a 36 cada vez, para asegurar que no se quede sin
				System.out.println("Introduce los datos del nuevo personaje:");
				System.out.print("Nombre -> ");
				String nombre = sc2.nextLine();
				System.out.print("Fuerza -> ");
				int fuerza = sc.nextInt();
				puntos = puntos - fuerza;
				System.out.print("Defensa -> ");
				int defensa = sc.nextInt();
				puntos = puntos - defensa;
				System.out.print("Velocidad -> ");
				int velocidad = sc.nextInt();
				puntos = puntos - velocidad;
				System.out.print("Inteligencia -> ");
				int inteligencia = sc.nextInt();
				puntos = puntos - inteligencia;
				añadido = new Avatar(nombre, fuerza, defensa, velocidad, inteligencia);
				
				if (puntos >= 0) {  //si no se ha quedado sin puntos tras introducir los datos el personaje se añade a la lista
					añadido.constPersonaje();
					personajes.add(añadido);
					cantpers--; //se resta un personaje
					puntos = 0;
					System.out.println("Te quedan " + cantpers + " personajes para completar el equipo");
				} else {
					System.out.println("Has pasado el límite de puntos, vuelve a introducirlos");
				};
			} while (puntos != 0 && cantpers > 0);
		} else {
			System.out.println("No puedes crear más personajes");
		}
		return añadido;
	}

	public void borrar() {
		if (cantpers<5){  //si no hay ningún personaje creado no funcionará
			System.out.print("Introduce el nombre del personaje que deseas borrar: ");
    	String nombreBorrar = sc2.nextLine();
   	 	Iterator<Avatar> lista = personajes.iterator(); //creamos un iterator para que recorra la lista personajes
    	boolean encontrado = false;
    
    	while (lista.hasNext() && encontrado == false) {
        	Avatar personaje = lista.next();
        
        	if (personaje.getNombre().equals(nombreBorrar)) { //se comparan el nombre que introduce el usuario con los 
				//nombres de los personajes que el iterator recorre de la lista
            	lista.remove();
            	encontrado = true; //si los nombres coinciden el booleano encontrado pasa a ser true y el bucle se detiene
				cantpers++; //se suma un personaje
        	}
			if (encontrado) {
				System.out.println("El personaje ha sido borrado correctamente");
			} else {
				System.out.println("No se encontró un personaje con ese nombre");
			}
		}

		System.out.println("Te quedan " + cantpers + " personajes para completar el equipo");
		} else {
			System.out.println("No hay ningún personaje creado");
		}
		
	}

	public void cambiar() {
		if (cantpers < 5) { //si no hay personajes no se ejecutará
			puntos = 36;
		System.out.println("Estos son tus personajes hasta ahora");
		for (Avatar i : personajes) { //primero muestra los personajes con un for each para que al usuario le 
			//resulte más cómodo, al no tener que recordar sus nombres
			i.constPersonaje();
			System.out.println();
		}
		System.out.print("¿Qué personaje quieres cambiar? Introduce su nombre: ");
		String nombreCambiar = sc2.nextLine();
		Iterator<Avatar> lista = personajes.iterator(); //el concepto es el mismo que el método borrar()
    	boolean encontrado = false;
    
    	while (lista.hasNext() && encontrado == false) {
        	Avatar personaje = lista.next();
        
        	if (personaje.getNombre().equals(nombreCambiar)) {
            	lista.remove(); //si coinciden primero borra el personaje
				System.out.println("Introduzca un nuevo personaje");
				cantpers++;
				añadir(); //luego llama al método añadir() para que el usuario introduzca uno en su lugar
            	encontrado = true;
        	}
			if (encontrado) {
				System.out.println("El personaje ha sido borrado correctamente");
			} else {
				System.out.println("No se encontró un personaje con ese nombre");
			}
		}
		
		} else {
			System.out.println("No hay ningún personaje creado");
		}
	}

	public void mostrar() {
		for (Avatar i : personajes) {
			i.constPersonaje(); //muestra los personajes introducidos en la lista
			System.out.println();
		}
		if (personajes.isEmpty()){
			System.out.println("No tienes ningún personaje creado");
		}
		System.out.println("Te quedan " + cantpers + " personajes para completar el equipo");
	}

	public void eliminar() {
		if (personajes.isEmpty()) { //comprueba que la lista no esté vacía, si no lo está elimina el contenido
			System.out.println("El equipo ya está vacío");
		} else {
			personajes.clear();
			System.out.println("La lista ha sido borrada");
			cantpers = 5;
		}
		
		System.out.println("Te quedan " + cantpers + " personajes para completar el equipo");
	}

	public void escribir() {
	    try { //se especifica la ruta en la que se guardará el fichero
	        BufferedWriter escribir = new BufferedWriter(new FileWriter("C:\\Users\\usuario\\Escritorio\\personajes.txt"));

	        for (Avatar personaje : personajes) { //recorre la lista escribiendo los personajes guardados en ella
	            escribir.write(personaje.DatosPersonaje()); //llama al constructor para poder escribir
	            escribir.write("\n");
	        }

	        escribir.close();
	        System.out.println("Los objetos se han escrito en el archivo correctamente.");
	    } catch (IOException e) { //si salta alguna excepción se coge el mensaje y se muestra
	        System.out.println("Error al escribir en el archivo: " + e.getMessage());
	    }
	}

}
