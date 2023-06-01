import java.util.*;

public class Caracteristicas {

	static ArrayList<Avatar> personajes = new ArrayList<Avatar>();
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	int numpers, cantpers = 5, puntos = 36;

	
	public void informar() {
		System.out.println("---------Información----------");
		System.out.println("¡CREA TU EQUIPO PARA JUGAR!");
		System.out.println("Puedes crear hasta 5 personajes, \nse recomienda subir diferentes atributos"
				+ " en cada uno para lograr un equipo equilibrado.\n Dispones de 36 puntos para repartir entre los 4 atributos");
		System.out.println("*Este es un personaje de ejemplo que te sirve como guía para crear tus propios personajes*");
		Avatar base = new Avatar(0, "Pedro", 9, 9, 9, 9);
		base.DatosPersonaje();
		System.out.println("--------Fin información--------");
	}

	public Avatar añadir() {
		do {
			puntos = 36;
			System.out.println("Introduce los datos del nuevo personaje:");
			System.out.print("Número de personaje -> ");
			int id = sc.nextInt();
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
			Avatar añadido = new Avatar(id, nombre, fuerza, defensa, velocidad, inteligencia);
			
			if (puntos >= 0) {
				System.out.println("Te quedan " + cantpers + " personajes para completar el equipo");
				añadido.DatosPersonaje();
				personajes.add(añadido);
				cantpers--;
				puntos = 0;
			} else {
				System.out.println("Has pasado el límite de puntos, vuelve a introducirlos");
			}
			return añadido;
		} while (puntos != 0 && cantpers > 0);
	}

	public void borrar() {
		System.out.println("¿Qué personaje quieres borrar?");
		System.out.print("Introduce su número de personaje: ");
		int idBorrar = sc.nextInt();
		personajes.remove(numpers);
		cantpers++;
		
		System.out.println("Te quedan " + cantpers + " personajes para completar el equipo");
	}

	public void cambiar() {
		puntos = 36;
		System.out.println("Estos son tus personajes hasta ahora");
		for (Avatar i : personajes) {
			i.DatosPersonaje();
			System.out.println();
		}
		System.out.print("¿Qué personaje quieres cambiar? Introduce su número de personaje: ");
		int idCambiar = sc.nextInt();
		System.out.println("Introduzca un nuevo personaje");
		Avatar nuevoAvatar = new Avatar();
		añadir();
		personajes.set(numpers, nuevoAvatar);
		cantpers++;
	}

	public void mostrar() {
		for (Avatar i : personajes) {
			i.DatosPersonaje();
			System.out.println();
		}
		System.out.println("Te quedan " + cantpers + " personajes para completar el equipo");
	}

	public void eliminar() {
		personajes.clear();
		System.out.println("La lista ha sido borrada");
		cantpers = 5;
		System.out.println("Te quedan " + cantpers + " personajes para completar el equipo");
	}

}
