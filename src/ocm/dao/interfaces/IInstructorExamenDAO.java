/**
 *
 */
package ocm.dao.interfaces;

import java.util.ArrayList;

import ocm.vo.EventoVO;
import ocm.vo.ExamenVO;
import ocm.vo.InscripcionVO;

/**
 * @author Eric
 *
 */
public interface IInstructorExamenDAO {
    public ArrayList<EventoVO> consultaEventosInstructor(EventoVO evento)
            throws Exception;

    public ArrayList<InscripcionVO> consultaInscritosEventoInstructor(
            InscripcionVO inscripcion) throws Exception;

    public ArrayList<ExamenVO> consultaExamenesEvento(ExamenVO examen)
            throws Exception;

    public int asignarExamen(InscripcionVO inscripcion) throws Exception;

}
