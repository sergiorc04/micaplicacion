public class Avatar {

	//---------atributos-----------
	private int fuerza, defensa, velocidad, inteligencia;
	private String nombre;
	
	public Avatar() {}

	public Avatar(String n, int f, int d, int i, int v) {
		nombre = n;
		fuerza = f;
		defensa = d;
		velocidad = v;
		inteligencia = i;
	}

	//-----getters y setters------
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

	public String DatosPersonaje() { //constructor de tipo String para que funcione el .write del método escribir()
		String datos = "---" + nombre + "---" + "\nFuerza = " + fuerza + "\nDefensa = "
                      + defensa + "\nVelocidad = " + velocidad + "\nInteligencia = " + inteligencia + "\n";
    	return datos;
	}

	public void constPersonaje(){ //constructor sin return para que se puedan mostrar los personajes en tiemop de ejecución
		System.out.println("---" + nombre + "---" + "\nFuerza = " + fuerza + "\nDefensa = "
		+ defensa + "\nVelocidad = " + velocidad + "\nInteligencia = " + inteligencia + "\n");
	}

}
