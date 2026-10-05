package andalucia;

public class AndaluciaFactory extends ElementoAndaluzFactory {
	@Override
	public ElementoAndaluz createElementoAndaluz(String tipo) {
		if (tipo.equalsIgnoreCase("flamenco")) {
			return new Flamenco();

		} else if (tipo.equalsIgnoreCase("gazpacho")) {
			return new Gazpacho();

		} else if (tipo.equalsIgnoreCase("feria")) {
			return new FeriaDeAbril();

		} else {
			return null;
		}
	}
}