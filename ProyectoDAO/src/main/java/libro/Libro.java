package libro;

public class Libro {
	private int id;
	private String titulo;
	private String autor;
	private int aniopublicacion;

	public Libro() {

	}

	public Libro(int id, String titulo, String autor, int aniopublicacion) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.aniopublicacion = aniopublicacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAniopublicacion() {
		return aniopublicacion;
	}

	public void setAniopublicacion(int aniopublicacion) {
		this.aniopublicacion = aniopublicacion;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", aniopublicacion=" + aniopublicacion
				+ "]";
	}

}
