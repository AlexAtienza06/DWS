package libro;

public class Main {

	public static void main(String[] args) {
		LibroDAOImpl libros = new LibroDAOImpl();
		libros.agregar(new Libro(1, "La leyenda de las tierras raras", "Folagor", 2017));
		libros.agregar(new Libro(2, "El libro troll", "ElRubius", 2014));
		libros.agregar(new Libro(3, "Don Quijote de la Mancha", "Miguel de Cervantes", 1605));

		Libro libro1 = new Libro(4, "El Principito ", "Antoine de Saint-Exupéry", 1943);
		libros.actualizar(libro1);

		System.out.println(libros.obtenerTodos());

		libros.eliminar(3);
		System.out.println(libros.obtenerTodos());
	}

}
