package ejercicio1;

public class Pared {

	private Double altura;

	public Pared(Double altura) {
		this.altura = altura;
	}

	public Double getAltura() {
		return altura;
	}

	@Override
	public String toString() {
		return "Pared de " + altura + " metros";
	}
}