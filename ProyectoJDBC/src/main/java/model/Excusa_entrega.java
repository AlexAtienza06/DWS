package model;

public class Excusa_entrega {
	private int id;
	private String alumno;
	private String curso;
	private String excusa;
	private int dias_retraso;
	private int credibilidad;
	private String fecha_entrega;
	private int aprobada_por_profesor;
	private int nivel_drama;

	public Excusa_entrega(int id, String alumno, String curso, String excusa, int dias_retraso, int credibilidad,
			String fecha_entrega, int aprobada_por_profesor, int nivel_drama) {
		this.id = id;
		this.alumno = alumno;
		this.curso = curso;
		this.excusa = excusa;
		this.dias_retraso = dias_retraso;
		this.credibilidad = credibilidad;
		this.fecha_entrega = fecha_entrega;
		this.aprobada_por_profesor = aprobada_por_profesor;
		this.nivel_drama = nivel_drama;
	}

	public Excusa_entrega(String alumno, String excusa, int dias_retraso, int nivel_drama) {
		this.alumno = alumno;
		this.excusa = excusa;
		this.dias_retraso = dias_retraso;
		this.nivel_drama = nivel_drama;
	}

	public int getId() {
		return id;
	}

	public String getAlumno() {
		return alumno;
	}

	public String getCurso() {
		return curso;
	}

	public String getExcusa() {
		return excusa;
	}

	public int getDias_retraso() {
		return dias_retraso;
	}

	public int getCredibilidad() {
		return credibilidad;
	}

	public String getFecha_entrega() {
		return fecha_entrega;
	}

	public int getAprobada_por_profesor() {
		return aprobada_por_profesor;
	}

	public int getNivel_drama() {
		return nivel_drama;
	}

	@Override
	public String toString() {
		return "Excusa_entrega [id=" + id + ", alumno=" + alumno + ", curso=" + curso + ", excusa=" + excusa
				+ ", dias_retraso=" + dias_retraso + ", credibilidad=" + credibilidad + ", fecha_entrega="
				+ fecha_entrega + ", aprobada_por_profesor=" + aprobada_por_profesor + ", nivel_drama=" + nivel_drama
				+ "]";
	}

}
