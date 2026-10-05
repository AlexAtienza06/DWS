package maquinaria;

import interfaces.Mantenimiento;

public class Locomotora {
	private String matricula;
	private double potenciaMotor;
	private int anioFabricacion;

	private Mantenimiento mecanico;

	public Locomotora(String matricula, double potenciaMotor, int anioFabricacion, Mantenimiento mecanico) {
		this.matricula = matricula;
		this.potenciaMotor = potenciaMotor;
		this.anioFabricacion = anioFabricacion;
		this.mecanico = mecanico;
	}

	public void realizarMantenimiento() {
		mecanico.realizarMantenimiento();
	}

	public String getMatricula() {
		return matricula;
	}

	public double getPotenciaMotor() {
		return potenciaMotor;
	}

	public int getAnioFabricacion() {
		return anioFabricacion;
	}

	public Mantenimiento getMecanico() {
		return mecanico;
	}
}