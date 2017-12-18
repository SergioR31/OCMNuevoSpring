/**
 *
 */
package ocm.dao.implementacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ocm.dao.interfaces.IInstructorExamenDAO;
import ocm.vo.EventoVO;
import ocm.vo.ExamenVO;
import ocm.vo.InscripcionVO;

/**
 * @author Eric
 *
 */
@Repository
public class InstructorExamenDAO implements IInstructorExamenDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArrayList<EventoVO> consultaEventosInstructor(EventoVO evento)
            throws Exception {
        // TODO Auto-generated method stub
        ArrayList<EventoVO> listaPaises = new ArrayList<EventoVO>();
        String sql = "select e.id, e.nombre, e.curso_id, c.nombre as nombrecurso from eventos e, cursos c where e.usuario_id = 3 and e.estado = 1 and e.curso_id = c.id order by e.id asc";

        try {
            listaPaises = (ArrayList<EventoVO>) jdbcTemplate.query(sql,
                    new RowMapper<EventoVO>() {

                        @Override
                        public EventoVO mapRow(final ResultSet result,
                                final int rowNum) throws SQLException {
                            EventoVO evento = new EventoVO();
                            evento.setId_evento(result.getInt("id"));
                            evento.setNombre(result.getString("nombre"));
                            evento.setNombre_curso(
                                    result.getString("nombrecurso"));

                            return evento;
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return listaPaises;
    }

    @Override
    public ArrayList<InscripcionVO> consultaInscritosEventoInstructor(
            InscripcionVO inscripcion) throws Exception {
        // TODO Auto-generated method stub
        ArrayList<InscripcionVO> listaPaises = new ArrayList<InscripcionVO>();
        // String sql = "select * from inscripciones i where evento_id = ? and
        // estado = 1";
        String sql = "select i.id, i.nombre, i.apellido_paterno, i.apellido_materno, e.examen_id, a.nombre as nombrecurso from inscripciones i, examen_interesado e, eventos a where i.id = e.inscripcion_id and i.evento_id = ? and i.estado = 1 and a.id = i.evento_id";

        try {
            listaPaises = (ArrayList<InscripcionVO>) jdbcTemplate.query(sql,
                    new Object[] {
                            Integer.valueOf(inscripcion.getId_evento()) },
                    new RowMapper<InscripcionVO>() {

                        @Override
                        public InscripcionVO mapRow(final ResultSet result,
                                final int rowNum) throws SQLException {
                            InscripcionVO inscripcion = new InscripcionVO();
                            inscripcion.setId_inscripcion(result.getInt("id"));
                            inscripcion.setNombre(result.getString("nombre"));
                            inscripcion.setApellido_paterno(
                                    result.getString("apellido_paterno"));
                            inscripcion.setApellido_materno(
                                    result.getString("apellido_materno"));
                            inscripcion.setNombre_curso(
                                    result.getString("nombrecurso"));
                            inscripcion
                                    .setId_examen(result.getInt("examen_id"));

                            return inscripcion;
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return listaPaises;
    }

    @Override
    public ArrayList<ExamenVO> consultaExamenesEvento(ExamenVO examen)
            throws Exception {
        ArrayList<ExamenVO> listaExamenes = new ArrayList<ExamenVO>();
        String sql = "SELECT E.ID, E.NOMBRE, E.CURSO_ID, E.PUNTAJE_MIN, E.PUNTAJE_MAX, EV.ID AS EVENTO_ID FROM EXAMEN E, EVENTOS EV, CURSOS C WHERE E.CURSO_ID = C.ID AND EV.CURSO_ID = C.ID AND EV.ID = ? ORDER BY E.ID ASC";

        try {
            listaExamenes = (ArrayList<ExamenVO>) jdbcTemplate.query(sql,
                    new Object[] { Integer.valueOf(examen.getId()) },
                    new RowMapper<ExamenVO>() {

                        @Override
                        public ExamenVO mapRow(final ResultSet result,
                                final int rowNum) throws SQLException {
                            ExamenVO examen = new ExamenVO();
                            examen.setId(result.getInt("id"));
                            examen.setNombre(result.getString("nombre"));
                            examen.setId_evento(result.getInt("evento_id"));

                            return examen;
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return listaExamenes;
    }

    @Override
    public int asignarExamen(InscripcionVO inscripcion) throws Exception {
        String sql = "UPDATE EXAMEN_INTERESADO SET EXAMEN_ID = ? WHERE EVENTO_ID = ?";
        int res = 0;
        System.out.println(inscripcion.getId_examen());
        System.out.println(inscripcion.getId_evento());
        try {

            res = jdbcTemplate.update(sql,
                    new Object[] { Integer.valueOf(inscripcion.getId_examen()),
                            Integer.valueOf(inscripcion.getId_evento()) });
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return res;
    }

}
