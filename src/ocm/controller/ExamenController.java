/**
 *
 */
package ocm.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ocm.servicio.implementacion.PreguntasExamenService;
import ocm.servicio.interfaces.IInstructorExamenService;
import ocm.vo.EventoVO;
import ocm.vo.InscripcionVO;
import ocm.vo.PreguntaVO;
import ocm.servicio.interfaces.IPreguntasExamenService;

/**
 * @author Bismarck
 *
 */
@Controller
@RequestMapping("/examen/")
public class ExamenController {

	@Autowired
	private IInstructorExamenService instructorService;
	
	@RequestMapping("lista-examen.do")
	public ModelAndView listaPreguntasExamen(@ModelAttribute("pregunta") final PreguntaVO pregunta, final Model model, final BindingResult result) {
		try {
			ArrayList<PreguntaVO> listaPreguntas = new ArrayList<PreguntaVO>();
				if(!result.hasErrors()) {
					listaPreguntas = PreguntasExamenService.consultaPreguntasExamen(pregunta);
					model.addAttribute("listaPreguntas", listaPreguntas);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("examenPrueba");
	}
	
	
	
	
	
	@RequestMapping("ver-examen.do")
	public ModelAndView listaInscritosEvento(@ModelAttribute("evento") final EventoVO evento, final InscripcionVO inscripcion, final Model model, final BindingResult result) {
		try {
			int id_evento = evento.getId_evento();
			inscripcion.setId_evento(id_evento);
			ArrayList<InscripcionVO> listaInscritos = new ArrayList<InscripcionVO>();
				if(!result.hasErrors()) {
				    listaInscritos = instructorService.consultaInscritosEventoInstructor(inscripcion);
					model.addAttribute("listaInscritos", listaInscritos );
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("examenPrueba");
	}

    
}
