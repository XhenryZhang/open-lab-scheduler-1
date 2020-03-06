package edu.ucsb.cs56.ucsb_open_lab_scheduler.controllers;

import edu.ucsb.cs56.ucsb_open_lab_scheduler.entities.User;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.entities.UsersToCSV;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class CSVDownloadController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/usersCSV")
    public void downloadCSV(HttpServletResponse response) throws IOException{
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=tutors.csv");

        List<User> tutors =  (List<User>) userRepository.findAll();

        UsersToCSV.writeTutors(response.getWriter(), tutors);
    }
}