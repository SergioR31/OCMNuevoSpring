/**
 * 
 */
package ocm.dao.interfaces;

import java.util.ArrayList;

import ocm.vo.PreguntaVO;

/**
 * @author Eric
 *
 */
public interface IInstructorPreguntaDAO {
	public ArrayList<PreguntaVO> consultaPreguntasInstructor(PreguntaVO pregunta) throws Exception;


	
}
