package ejercicio1;

public class Main {

	public static void main(String[] args) {

		// Dependencias de la primera casa.
		Tejado tejado1 = new TejadoTejas();
		Pared pared1 = new Pared(3.0);
		Pared pared2 = new Pared(3.0);
		Pared pared3 = new Pared(3.0);
		Pared pared4 = new Pared(3.0);

		// Inyección de todas las dependencias en Casa.
		Casa casa1 = new Casa(120.0, tejado1, pared1, pared2, pared3, pared4);

		// Segunda casa con otras dependencias.
		Tejado tejado2 = new Tejado();
		Pared pared5 = new Pared(2.8);
		Pared pared6 = new Pared(2.8);
		Pared pared7 = new Pared(2.8);
		Pared pared8 = new Pared(2.8);

		Casa casa2 = new Casa(90.0, tejado2, pared5, pared6, pared7, pared8);

		casa1.mostrarCasa();
		casa2.mostrarCasa();
	}
}
