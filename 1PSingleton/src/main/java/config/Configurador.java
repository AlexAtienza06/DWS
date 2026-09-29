package config;

public class Configurador {
	private static final Configurador INSTANCIA = new Configurador();

	private static String configuracion;

	public static Configurador obtenerInstancia() {
		return INSTANCIA;
	}

	public String getConfiguracion() {
		return configuracion;
	}

	public void setConfiguracion(String configuracion) {
		Configurador.configuracion = configuracion;
	}
}