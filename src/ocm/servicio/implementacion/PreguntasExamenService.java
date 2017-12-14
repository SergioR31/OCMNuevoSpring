/**
 * 
 */
package ocm.servicio.implementacion;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ocm.dao.interfaces.IInstructorExamenDAO;
import ocm.dao.interfaces.IPreguntaExamenDAO;
import ocm.servicio.interfaces.IInstructorExamenService;
import ocm.servicio.interfaces.IPreguntasExamenService;
import ocm.vo.EventoVO;
import ocm.vo.InscripcionVO;
import ocm.vo.PreguntaVO;

/**
 * @author Bismarck
 *
 */
@Service
public class PreguntasExamenService implements IPreguntasExamenService {
	@Autowired
	private IPreguntaExamenDAO preguntasExamenDAO;
	
	
	public ArrayList<PreguntaVO> consultaPreguntasExamen(PreguntaVO pregunta) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<PreguntaVO> listaPreguntas = new ArrayList<PreguntaVO>();
		try {
			listaPreguntas = preguntasExamenDAO.consultaPreguntasExamen(pregunta);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listaPreguntas;
	}


	


}
