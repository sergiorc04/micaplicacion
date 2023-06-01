import java.util.Collection;

public class Avatar {


	private int id, fuerza, defensa, velocidad, inteligencia;
	private String nombre;
	
	private int numpers;
	
	public Avatar() {}

	public Avatar(int id, String n, int f, int d, int i, int v) {
		nombre = n;
		fuerza = f;
		defensa = d;
		velocidad = v;
		inteligencia = i;
		numpers = id;
	}

	public int getpersonaje() {
		return id;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void DatosPersonaje() {
		System.out.println("---Personaje " + numpers + "---\n Nombre = " + nombre + "\n Fuerza = " + fuerza + "\n Defensa = "
						+ defensa + "\n Velocidad = " + velocidad + "\n Inteligencia = " + inteligencia + "\n");
	}

}
