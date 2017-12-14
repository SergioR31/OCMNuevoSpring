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
import ocm.dao.interfaces.IPreguntaExamenDAO;
//import ocm.servicio.interfaces.Exception;
import ocm.vo.EventoVO;
import ocm.vo.InscripcionVO;
import ocm.vo.PreguntaVO;

/**
 * @author Bismarck
 *
 */
@Repository
public class PreguntaExamenDAO implements IPreguntaExamenDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ArrayList<PreguntaVO> consultaPreguntasExamen(PreguntaVO pregunta) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<PreguntaVO> listaPreguntas = new ArrayList<PreguntaVO>();
		String sql = "select * from preguntas where id =  1";
		
		try {
			listaPreguntas = (ArrayList<PreguntaVO>) jdbcTemplate.query(sql, new RowMapper<PreguntaVO>() {
				
				public PreguntaVO mapRow(final ResultSet result,
						final int rowNum) throws SQLException{
						PreguntaVO pregunta = new PreguntaVO();
						pregunta.setId_pregunta(result.getString("id"));
						pregunta.setPregunta(result.getString("pregunta"));
												
						return pregunta;
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listaPreguntas;
	}

	
	/*
	@Override
	public ArrayList<InscripcionVO> consultaInscritosEventoInstructor(InscripcionVO inscripcion) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<InscripcionVO> listaPaises = new ArrayList<InscripcionVO>();
		String sql = "select * from inscripciones where evento_id = ? and estado = 1";
		
		try {
			listaPaises = (ArrayList<InscripcionVO>) jdbcTemplate.query(sql, new Object[] {Integer.valueOf(inscripcion.getId_evento())}, new RowMapper<InscripcionVO>() {
				
				public InscripcionVO mapRow(final ResultSet result,
						final int rowNum) throws SQLException{
						InscripcionVO inscripcion = new InscripcionVO();
						inscripcion.setId_inscripcion(result.getInt("id"));
						inscripcion.setNombre(result.getString("nombre"));
												
						return inscripcion;
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return listaPaises;
	}
*/
}
