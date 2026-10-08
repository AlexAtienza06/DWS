package ejercicio3;

public class Presidente {

	private String nombre;
	private String apellidos;
	private int anioEleccion;

	private static Presidente instancia;

	public Presidente(String nombre, String apellidos, int anioEleccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.anioEleccion = anioEleccion;
	}

	public static Presidente getInstance(String nombre, String apellidos, int anioEleccion) {
		if (instancia == null) {
			instancia = new Presidente(nombre, apellidos, anioEleccion);
		}
		return instancia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getAnioEleccion() {
		return anioEleccion;
	}

	public void mostrarDatos() {
		System.out.println("Presidente: " + nombre + " " + apellidos);
		System.out.println("Año de elección: " + anioEleccion);
	}
}