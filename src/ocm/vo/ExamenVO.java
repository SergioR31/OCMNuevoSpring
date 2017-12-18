/**
 *
 */
package ocm.vo;

/**
 * @author Eric
 *
 */
public class ExamenVO {
    private int id;
    private String nombre;
    private int curso_id;
    private int puntaje_min;
    private int puntaje_max;
    private int id_evento;

    /**
     * @return the id_evento
     */
    public int getId_evento() {
        return id_evento;
    }

    /**
     * @param id_evento
     *            the id_evento to set
     */
    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the curso_id
     */
    public int getCurso_id() {
        return curso_id;
    }

    /**
     * @param curso_id
     *            the curso_id to set
     */
    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    /**
     * @return the puntaje_min
     */
    public int getPuntaje_min() {
        return puntaje_min;
    }

    /**
     * @param puntaje_min
     *            the puntaje_min to set
     */
    public void setPuntaje_min(int puntaje_min) {
        this.puntaje_min = puntaje_min;
    }

    /**
     * @return the puntaje_max
     */
    public int getPuntaje_max() {
        return puntaje_max;
    }

    /**
     * @param puntaje_max
     *            the puntaje_max to set
     */
    public void setPuntaje_max(int puntaje_max) {
        this.puntaje_max = puntaje_max;
    }

}