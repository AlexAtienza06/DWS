package config;

public class Main {
	public static void main(String[] args) {
		Configurador config = Configurador.obtenerInstancia();

		config.setConfiguracion("Hola");

		System.out.println(config.getConfiguracion());
	}
}