package personal;

import interfaces.Mantenimiento;

public class Mecanico implements Mantenimiento {

	private String nombreCompleto;
	private String telefono;
	private String especialidad;

	public Mecanico(String nombreCompleto, String telefono, String especialidad) {
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.especialidad = especialidad;
	}

	@Override
	public void realizarMantenimiento() {
		System.out.println(nombreCompleto + " está realizando el mantenimiento de la locomotora.");
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEspecialidad() {
		return especialidad;
	}
}
