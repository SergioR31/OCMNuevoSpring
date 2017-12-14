package ocm.vo;

public class ExamenVO {

	
		String id_examen;
		String nombre;
		String id_curso;
		int puntuaje_min;
		int puntuaje_max;
		public String getId_examen() {
			return id_examen;
		}
		public void setId_examen(String id_examen) {
			this.id_examen = id_examen;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getId_curso() {
			return id_curso;
		}
		public void setId_curso(String id_curso) {
			this.id_curso = id_curso;
		}
		public int getPuntuaje_min() {
			return puntuaje_min;
		}
		public void setPuntuaje_min(int puntuaje_min) {
			this.puntuaje_min = puntuaje_min;
		}
		public int getPuntuaje_max() {
			return puntuaje_max;
		}
		public void setPuntuaje_max(int puntuaje_max) {
			this.puntuaje_max = puntuaje_max;
		}
		
		
}
