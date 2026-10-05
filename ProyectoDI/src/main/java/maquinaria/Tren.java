package maquinaria;

import interfaces.ResponsableTren;

public class Tren {
	private Locomotora locomotora;
	private Vagon[] vagones;
	private int numeroVagones;

	private ResponsableTren maquinista;

	public Tren(Locomotora locomotora, ResponsableTren maquinista) {
		this.locomotora = locomotora;
		this.maquinista = maquinista;
		vagones = new Vagon[5];
		numeroVagones = 0;
	}

	public void annadirVagon(double capacidadMaxima, double capacidadActual, String tipoMercancia) {
		Vagon vagon = new Vagon(capacidadMaxima, capacidadActual, tipoMercancia);
		if (numeroVagones < 5) {
			vagones[numeroVagones] = vagon;
			numeroVagones++;
			System.out.println("Vagón añadido correctamente.");
		} else {
			System.out.println("No se pueden añadir más de 5 vagones.");
		}
	}

	public void conducir() {
		maquinista.conducir();
	}

	public Locomotora getLocomotora() {
		return locomotora;
	}

	public ResponsableTren getMaquinista() {
		return maquinista;
	}

	public int getNumeroVagones() {
		return numeroVagones;
	}
}