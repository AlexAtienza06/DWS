package ejercicio2;

public class FiguraFactory {

	public static Figura crearFigura(String tipo, String color) {
		switch (tipo.toLowerCase()) {
		case "triangulo":
			return new Triangulo(color);
		case "rectangulo":
			return new Rectangulo(color);
		case "circulo":
			return new Circulo(color);
		case "cuadrado":
			return new Cuadrado(color);
		default:
			System.out.println("Tipo de figura no válido: " + tipo);
			return null;
		}
	}
}