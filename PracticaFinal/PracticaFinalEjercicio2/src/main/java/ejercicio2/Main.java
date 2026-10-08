package ejercicio2;

public class Main {

	public static void main(String[] args) {
		Figura triangulo = FiguraFactory.crearFigura("triangulo", "rojo");
		Figura rectangulo = FiguraFactory.crearFigura("rectangulo", "azul");
		Figura circulo = FiguraFactory.crearFigura("circulo", "verde");
		Figura cuadrado = FiguraFactory.crearFigura("cuadrado", "amarillo");

		triangulo.dibujarFigura();
		rectangulo.dibujarFigura();
		circulo.dibujarFigura();
		cuadrado.dibujarFigura();
	}
}