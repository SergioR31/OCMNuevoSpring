/**
 * 
 */
package ocm.servicio.implementacion;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ocm.dao.interfaces.IInstructorExamenDAO;
import ocm.servicio.interfaces.IInstructorExamenService;
import ocm.vo.EventoVO;
import ocm.vo.InscripcionVO;

/**
 * @author Eric
 *
 */
@Service
public class InstructorExamenService implements IInstructorExamenService {
	@Autowired
	private IInstructorExamenDAO instructorExamenDAO;
	/* (non-Javadoc)
	 * @see ocm.servicio.interfaces.IInstructorExamen#consultaEventosInstructor(ocm.vo.EventoVO)
	 */
	
	@Override
	public ArrayList<EventoVO> consultaEventosInstructor(EventoVO evento) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
		try {
			listaEventos = instructorExamenDAO.consultaEventosInstructor(evento);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listaEventos;
	}
	@Override
	public ArrayList<InscripcionVO> consultaInscritosEventoInstructor(InscripcionVO inscripcion) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<InscripcionVO> listaInscripciones = new ArrayList<InscripcionVO>();
		try {
			listaInscripciones = instructorExamenDAO.consultaInscritosEventoInstructor(inscripcion);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listaInscripciones;
	}

}
