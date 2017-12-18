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

import ocm.dao.interfaces.IInstructorPreguntaDAO;
import ocm.vo.PreguntaVO;
import ocm.vo.ExamenVO;

/**
 * @author Eric
 *
 */
@Repository
public class InstructorPreguntaDAO implements IInstructorPreguntaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ArrayList<PreguntaVO> consultaPreguntasInstructor(PreguntaVO pregunta) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<PreguntaVO> listaPreguntas = new ArrayList<PreguntaVO>();
		String sql = "select p.id, p.pregunta, ep.pregunta_id as epregunta from preguntas p, examen_preguntas ep where ep.examen_id= 1 and ep.PREGUNTA_ID = p.id  ";
		
		try {
			listaPreguntas = (ArrayList<PreguntaVO>) jdbcTemplate.query(sql, new RowMapper<PreguntaVO>() {
				
				public PreguntaVO mapRow(final ResultSet result,
						final int rowNum) throws SQLException{
						PreguntaVO pregunta = new PreguntaVO();
						pregunta.setId_pregunta(result.getInt("id"));
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

	

}
