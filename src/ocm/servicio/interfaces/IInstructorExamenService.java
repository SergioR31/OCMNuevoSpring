/**
 * 
 */
package ocm.servicio.interfaces;

import java.util.ArrayList;

import ocm.vo.EventoVO;
import ocm.vo.InscripcionVO;

/**
 * @author Eric
 *
 */
public interface IInstructorExamenService {
	public ArrayList<EventoVO> consultaEventosInstructor(EventoVO evento) throws Exception;
	public ArrayList<InscripcionVO> consultaInscritosEventoInstructor(InscripcionVO inscripcion) throws Exception;
	
	
}
