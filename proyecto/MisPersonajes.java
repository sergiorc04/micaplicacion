
import java.util.*;

public class MisPersonajes {

	public static void main(String[] args) {

		Caracteristicas avatar = new Caracteristicas();
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("----------MENÚ----------");
			System.out.println("0-Información sobre la aplicación");
			System.out.println("1-Introducir personaje propio");
			System.out.println("2-Eliminar un personaje");
			System.out.println("3-Cambiar un personaje por otro");
			System.out.println("4-Eliminar todos los personajes");
			System.out.println("5-Mostrar los personajes creados");
			System.out.println("6-Añadir personajes al fichero");
			System.out.println("7-Mostrar personajes del fichero");
			System.out.println("8-Salir");
			System.out.println("------------------------");
			System.out.print("Número de opción: ");
			opcion = sc.nextInt();

			switch (opcion) { // las opciones llaman a métodos de otras clases

			case 0:
				avatar.informar();
				break;
			
			case 1:
				avatar.añadir();
				break;

			case 2:
				avatar.borrar();
				break;

			case 3:
				avatar.cambiar();
				break;

			case 4:
				avatar.eliminar();
				break;

			case 5:
				avatar.mostrar();
				break;

			case 6:
				Fichero.escribir();
				break;

			case 7:
                Fichero.leer();
				break;

			case 8:
				System.out.println();
				System.out.println("ADIÓS");
				break;

			default:
				System.out.println("No existe esta opcion, vuelva a introducir la que desea");
				break;
			}
		} while (opcion != 8);

	}

}
