/**
 *
 */
package ocm.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ocm.servicio.interfaces.IInstructorExamenService;
import ocm.vo.EventoVO;
import ocm.vo.ExamenVO;
import ocm.vo.InscripcionVO;

/**
 * @author Eric
 *
 */
@Controller
@RequestMapping("/instructor/")
public class InstructorExamenController {

    @Autowired
    private IInstructorExamenService instructorService;

    @RequestMapping("lista-eventos-instructor.do")
    public ModelAndView listaEventosInstructor(
            @ModelAttribute("evento") final EventoVO evento, final Model model,
            final BindingResult result) {
        try {
            ArrayList<EventoVO> listaEventos = new ArrayList<EventoVO>();
            if (!result.hasErrors()) {
                listaEventos = instructorService
                        .consultaEventosInstructor(evento);
                model.addAttribute("listaEventos", listaEventos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("listaEventosInstructor");
    }

    @RequestMapping("ver-inscritos.do")
    public ModelAndView listaInscritosEvento(
            @ModelAttribute("evento") final EventoVO evento,
            final InscripcionVO inscripcion, final Model model) {
        try {
            int id_evento = evento.getId_evento();
            inscripcion.setId_evento(id_evento);
            ExamenVO examen = new ExamenVO();
            examen.setId(id_evento);
            ArrayList<ExamenVO> listaExamenes = new ArrayList<ExamenVO>();
            ArrayList<InscripcionVO> listaInscritos = new ArrayList<InscripcionVO>();

            listaInscritos = instructorService
                    .consultaInscritosEventoInstructor(inscripcion);
            model.addAttribute("listaInscritos", listaInscritos);

            listaExamenes = instructorService.consultaExamenesEvento(examen);
            model.addAttribute("listaExamenes", listaExamenes);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ModelAndView("listaInscritosEventoInstructor");
    }

    @RequestMapping("asignar-examen.do")
    public ModelAndView asignarExamen(
            @ModelAttribute("evento") final EventoVO evento,
            final InscripcionVO inscripcion, final HttpServletRequest req,
            final HttpServletResponse resp, final Model model) {
        try {
            int id_examen = Integer.parseInt(req.getParameter("selectExamen"));
            int id_evento = Integer.parseInt(req.getParameter("evento"));

            inscripcion.setId_evento(id_evento);
            inscripcion.setId_examen(id_examen);

            evento.setId_evento(id_evento);

            instructorService.asignarExamen(inscripcion);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaInscritosEvento(evento, inscripcion, model);
    }

}
