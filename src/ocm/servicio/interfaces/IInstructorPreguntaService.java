/**
 * 
 */
package ocm.servicio.interfaces;

import java.util.ArrayList;


import ocm.vo.PreguntaVO;

/**
 * @author Eric
 *
 */
public interface IInstructorPreguntaService {
	public ArrayList<PreguntaVO> consultaPreguntasInstructor(PreguntaVO pregunta) throws Exception;
	
	
}
