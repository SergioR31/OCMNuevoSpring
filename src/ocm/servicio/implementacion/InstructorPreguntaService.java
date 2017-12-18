/**
 * 
 */
package ocm.servicio.implementacion;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ocm.dao.interfaces.IInstructorPreguntaDAO;
import ocm.servicio.interfaces.IInstructorPreguntaService;
import ocm.vo.PreguntaVO;

/**
 * @author Eric
 *
 */
@Service
public class InstructorPreguntaService implements IInstructorPreguntaService {
	@Autowired
	private IInstructorPreguntaDAO instructorPreguntaDAO;
	/* (non-Javadoc)
	 * @see ocm.servicio.interfaces.IInstructorExamen#consultaEventosInstructor(ocm.vo.EventoVO)
	 */
	
	@Override
	public ArrayList<PreguntaVO> consultaPreguntasInstructor(PreguntaVO pregunta) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<PreguntaVO> listaPreguntas= new ArrayList<PreguntaVO>();
		try {
			listaPreguntas = instructorPreguntaDAO.consultaPreguntasInstructor(pregunta);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listaPreguntas;
	}

	
	

}
