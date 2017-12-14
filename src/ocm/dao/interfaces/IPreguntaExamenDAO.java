/**
 * 
 */
package ocm.dao.interfaces;

import java.util.ArrayList;


import ocm.vo.EventoVO;
import ocm.vo.InscripcionVO;
import ocm.vo.PreguntaVO;

/**
 * @author Eric
 *
 */
public interface IPreguntaExamenDAO {
	public ArrayList<PreguntaVO> consultaPreguntasExamen(PreguntaVO pregunta) throws Exception;
	
}
