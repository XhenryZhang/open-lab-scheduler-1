package edu.ucsb.cs56.ucsb_open_lab_scheduler.controllers;

import edu.ucsb.cs56.ucsb_open_lab_scheduler.advice.AuthControllerAdvice;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.entities.CourseOffering;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.repositories.CourseOfferingRepository;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.services.CSVToObjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
public class CourseOfferingController {
    private static Logger log = LoggerFactory.getLogger(CourseOfferingController.class);

    @Autowired
    private AuthControllerAdvice authControllerAdvice;

    @Autowired
    CSVToObjectService<CourseOffering> csvToObjectService;

    @Autowired
    CourseOfferingRepository courseOfferingRepository;

    @Autowired

    @GetMapping("/courseOffering")
    public String dashboard(Model model, OAuth2AuthenticationToken token, RedirectAttributes redirAttrs) {
        String role = authControllerAdvice.getRole(token);
        if (!(role.equals("Admin"))) {
            redirAttrs.addFlashAttribute("alertDanger", "You do not have permission to access that page");
            return "redirect:/";
        }
        model.addAttribute("CourseOfferingModel", courseOfferingRepository.findAll());
        return "courseOffering/courseOffering";
    }

    @PostMapping("/courseOffering/upload")
    public String uploadCSV(@RequestParam("csv") MultipartFile csv, OAuth2AuthenticationToken token,
            RedirectAttributes redirAttrs) {
        String role = authControllerAdvice.getRole(token);
        if (!(role.equals("Admin"))) {
            redirAttrs.addFlashAttribute("alertDanger", "You do not have permission to access that page");
            return "redirect:/";
        }
        try (Reader reader = new InputStreamReader(csv.getInputStream())) {
            List<CourseOffering> courseOfferings = csvToObjectService.parse(reader, CourseOffering.class);
            courseOfferingRepository.saveAll(courseOfferings);
        } catch (IOException e) {
            log.error(e.toString());
        }
        return "redirect:/courseOffering/courseOffering";
    }

    @GetMapping("/courseOffering/delete/{id}")
    public String deleteConfirm(@PathVariable("id") long id, Model model, OAuth2AuthenticationToken token,
            RedirectAttributes redirAttrs) {
        String role = authControllerAdvice.getRole(token);
        if (!role.equals("Admin")) {
            redirAttrs.addFlashAttribute("alertDanger", "You do not have permission to access that page");
            return "redirect:/";
        }

        Optional<CourseOffering> course = courseOfferingRepository.findById(id);
        if (!course.isPresent()) {
            redirAttrs.addFlashAttribute("alertDanger", "Course with that id does not exist.");
        } else {
            model.addAttribute("CourseToDelete", courseOfferingRepository.findById(id).get());
        }

        return "courseOffering/confirmDelete";
    }

    @PostMapping("/courseOffering/delete/confirm/{id}")
    public String deleteCourse(@PathVariable("id") long id, Model model, OAuth2AuthenticationToken token,
            RedirectAttributes redirAttrs) {
        String role = authControllerAdvice.getRole(token);
        if (!role.equals("Admin")) {
            redirAttrs.addFlashAttribute("alertDanger", "You do not have permission to access that page");
            return "redirect:/";
        }
        Optional<CourseOffering> course = courseOfferingRepository.findById(id);
        if (!course.isPresent()) {
            redirAttrs.addFlashAttribute("alertDanger", "Course with that id does not exist.");
        } else {
            courseOfferingRepository.delete(course.get());
            redirAttrs.addFlashAttribute("alertSuccess", "Course successfully deleted.");
        }
        return "redirect:/courseOffering/";

    }
}
