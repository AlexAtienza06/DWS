package ejercicio1;

public class Casa {
	private double area;
	private Tejado tejado;
	private Pared pared1;
	private Pared pared2;
	private Pared pared3;
	private Pared pared4;

	public Casa(Double area, Tejado tejado, Pared pared1, Pared pared2, Pared pared3, Pared pared4) {
		this.area = area;
		this.tejado = tejado;
		this.pared1 = pared1;
		this.pared2 = pared2;
		this.pared3 = pared3;
		this.pared4 = pared4;
	}

	public void mostrarCasa() {
		System.out.println("Área: " + area + " m2");
		System.out.println("Tejado: " + tejado.getClass().getSimpleName());
		System.out.println(pared1);
		System.out.println(pared2);
		System.out.println(pared3);
		System.out.println(pared4);
		tejado.darSoporte();
		System.out.println();
	}
}