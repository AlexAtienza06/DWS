package ejercicio3;

public class Main {

	public static void main(String[] args) {

		Presidente presidente1 = Presidente.getInstance("Donald", "Trump", 2025);

		Presidente presidente2 = Presidente.getInstance("Alejandro", "Atienza", 2028);

		presidente1.mostrarDatos();

		System.out.println();
		System.out.println("¿Son la misma instancia? " + (presidente1 == presidente2));
	}
}
