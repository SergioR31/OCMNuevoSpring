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
	public ArrayList<EventoVO> consultaEventosInstructor(EventoVO evento) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<EventoVO> listaPaises = new ArrayList<EventoVO>();
		String sql = "select e.id, e.nombre, e.curso_id, c.nombre as nombrecurso from eventos e, cursos c where e.usuario_id = 3 and e.estado = 1 and e.curso_id = c.id order by e.id asc";
		
		try {
			listaPaises = (ArrayList<EventoVO>) jdbcTemplate.query(sql, new RowMapper<EventoVO>() {
				
				public EventoVO mapRow(final ResultSet result,
						final int rowNum) throws SQLException{
						EventoVO evento = new EventoVO();
						evento.setId_evento(result.getInt("id"));
						evento.setNombre(result.getString("nombre"));
						evento.setNombre_curso(result.getString("nombrecurso"));
												
						return evento;
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listaPaises;
	}

	@Override
	public ArrayList<InscripcionVO> consultaInscritosEventoInstructor(InscripcionVO inscripcion) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<InscripcionVO> listaPaises = new ArrayList<InscripcionVO>();
		//String sql = "select * from inscripciones i where evento_id = ? and estado = 1";
		String sql = "select i.id, i.nombre, i.apellido_paterno, i.apellido_materno, e.examen_id, a.nombre as nombrecurso from inscripciones i, examen_interesado e, eventos a where i.id = e.inscripcion_id and i.evento_id = ? and i.estado = 1 and a.id = i.evento_id";
		
		try {
			listaPaises = (ArrayList<InscripcionVO>) jdbcTemplate.query(sql, new Object[] {Integer.valueOf(inscripcion.getId_evento())}, new RowMapper<InscripcionVO>() {
				
				public InscripcionVO mapRow(final ResultSet result,
						final int rowNum) throws SQLException{
						InscripcionVO inscripcion = new InscripcionVO();
						inscripcion.setId_inscripcion(result.getInt("id"));
						inscripcion.setNombre(result.getString("nombre"));
						inscripcion.setApellido_paterno(result.getString("apellido_paterno"));
						inscripcion.setApellido_materno(result.getString("apellido_materno"));
						inscripcion.setNombre_curso(result.getString("nombrecurso"));
						inscripcion.setId_examen(result.getInt("examen_id"));
												
						return inscripcion;
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listaPaises;
	}

}
