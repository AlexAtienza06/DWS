package personal;

import interfaces.ResponsableTren;

public class Maquinista implements ResponsableTren {
	private String nombreCompleto;
	private String dni;
	private double sueldoMensual;
	private String rango;

	public Maquinista(String nombreCompleto, String dni, double sueldoMensual, String rango) {
		this.nombreCompleto = nombreCompleto;
		this.dni = dni;
		this.sueldoMensual = sueldoMensual;
		this.rango = rango;
	}

	@Override
	public void conducir() {
		System.out.println(nombreCompleto + " está conduciendo el tren.");
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getDni() {
		return dni;
	}

	public double getSueldoMensual() {
		return sueldoMensual;
	}

	public String getRango() {
		return rango;
	}
}
