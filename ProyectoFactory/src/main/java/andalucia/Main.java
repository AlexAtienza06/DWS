package andalucia;

public class Main {
	public static void main(String[] args) {
		AndaluciaFactory factory = new AndaluciaFactory();

		ElementoAndaluz flamenco = factory.createElementoAndaluz("flamenco");
		ElementoAndaluz gazpacho = factory.createElementoAndaluz("gazpacho");
		ElementoAndaluz feria = factory.createElementoAndaluz("feria");

		flamenco.describir();
		gazpacho.describir();
		feria.describir();
	}
}