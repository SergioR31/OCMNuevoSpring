/**
 * 
 */
package ocm.dao.interfaces;

import java.util.ArrayList;

import ocm.vo.EventoVO;
import ocm.vo.InscripcionVO;

/**
 * @author Eric
 *
 */
public interface IInstructorExamenDAO {
	public ArrayList<EventoVO> consultaEventosInstructor(EventoVO evento) throws Exception;
	public ArrayList<InscripcionVO> consultaInscritosEventoInstructor(InscripcionVO inscripcion) throws Exception;

	
}
