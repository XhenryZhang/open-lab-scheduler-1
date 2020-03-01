package edu.ucsb.cs56.ucsb_open_lab_scheduler.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

import edu.ucsb.cs56.ucsb_open_lab_scheduler.advice.AuthControllerAdvice;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.repositories.CourseOfferingRepository;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.services.CSVToObjectService;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.entities.CourseOffering;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.repositories.CourseOfferingRepository;




import edu.ucsb.cs56.ucsb_open_lab_scheduler.entities.CourseOffering;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.entities.TutorAssignment;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.repositories.CourseOfferingRepository;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.repositories.TutorAssignmentRepository;




@Controller
public class InstructorMenuController {
    private static Logger log = LoggerFactory.getLogger(TutorController.class);

    @Autowired
    private AuthControllerAdvice authControllerAdvice;

    @Autowired
    private CourseOfferingRepository courseOfferingRepository;

    @Autowired
    private TutorAssignmentRepository tutorAssignmentRepository;
        

    @GetMapping("/instructorMenu")
    public String dashboard(Model model, OAuth2AuthenticationToken token, RedirectAttributes redirAttrs) {
        if (!authControllerAdvice.getIsInstructor(token)) {
            redirAttrs.addFlashAttribute("alertDanger", "You do not have permission to access that page");
            return "redirect:/";
        }
	
        String email= (String) token.getPrincipal().getAttributes().get("email");

        model.addAttribute("courses",courseOfferingRepository.findByInstructorEmail(email));
        //model.addAttribute("email", email);
        return "instructorMenu/instructorMenu";
    }

    @GetMapping("/instructorMenu/{id}")
    public String getTutor(@PathVariable("id") long id, Model model, OAuth2AuthenticationToken token,
                           RedirectAttributes redirAttrs){
        if (!authControllerAdvice.getIsInstructor(token)) {
            redirAttrs.addFlashAttribute("alertDanger", "You do not have permission to access that page");
            return "redirect:/";
        }
        Optional<CourseOffering> courseOffering = courseOfferingRepository.findById(id);
        if (!courseOffering.isPresent()) {
            redirAttrs.addFlashAttribute("alertDanger", "Course offering with id " + id + " not found");
            return "redirect:/";

        }
        model.addAttribute("tutors",tutorAssignmentRepository.findByCourseOffering(courseOffering.get()));
        return "instructorMenu/getTutors";
    }

}
