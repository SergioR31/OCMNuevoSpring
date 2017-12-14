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
public interface IPreguntasExamenService {
	public ArrayList<PreguntaVO> consultaPreguntasExamen(PreguntaVO pregunta) throws Exception;
	
}
