package main;

import personal.*;
import maquinaria.*;

public class Main {
	public static void main(String[] args) {
		Mecanico mecanico = new Mecanico("Alejandro Atienza Naranjo", "600123123", "Frenos");
		Maquinista maquinista = new Maquinista("Mari Carmen López Martín", "12345678A", 2500, "Jefe de tren");
		JefeEstacion jefe = new JefeEstacion("José Manuel Pérez Carmona", "87654321B");
		Locomotora locomotora = new Locomotora("SE-1234", 3000, 2020, mecanico);
		Tren tren = new Tren(locomotora, maquinista);

		tren.annadirVagon(20000, 15000, "Aceite");
		tren.annadirVagon(30000, 25000, "Trigo");
		tren.conducir();

		locomotora.realizarMantenimiento();

		System.out.println("Matrícula: " + locomotora.getMatricula());
		System.out.println("Vagones del tren: " + tren.getNumeroVagones());
		System.out.println("Jefe de estación: " + jefe.getNombreCompleto());
	}
}