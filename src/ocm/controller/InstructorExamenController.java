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

import ocm.servicio.interfaces.IInstructorExamenService;
import ocm.servicio.interfaces.IInstructorPreguntaService;
import ocm.vo.EventoVO;
import ocm.vo.InscripcionVO;
import ocm.vo.PreguntaVO;

/**
 * @author Eric
 *
 */
@Controller
@RequestMapping("/instructor/")
public class InstructorExamenController {

	@Autowired
	private IInstructorExamenService instructorService;
	
	@Autowired
	private IInstructorPreguntaService instructorpreguntaService;
		
	@RequestMapping("ver-inscritos.do")
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
		
		return new ModelAndView("listaInscritosEventoInstructor");
	}

	@RequestMapping("lista-eventos-instructor.do")
	public ModelAndView listaEventosInstructor(@ModelAttribute("evento") final EventoVO evento, final Model model, final BindingResult result) {
		try {
			ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
				if(!result.hasErrors()) {
				    listaEventos = instructorService.consultaEventosInstructor(evento);
					model.addAttribute("listaEventos", listaEventos );
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("listaEventosInstructor");
	}
	
	@RequestMapping("lista-preguntas-instructor.do")
	public ModelAndView listaPreguntasInstructor(@ModelAttribute("pregunta") final PreguntaVO pregunta, final Model model, final BindingResult result) {
		try {
			ArrayList<PreguntaVO> listaPreguntas = new ArrayList<PreguntaVO>();
				if(!result.hasErrors()) {
					listaPreguntas = instructorpreguntaService.consultaPreguntasInstructor(pregunta);
					model.addAttribute("listaPreguntas", listaPreguntas );
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("listaPreguntasInstructor");
	}
    
}
