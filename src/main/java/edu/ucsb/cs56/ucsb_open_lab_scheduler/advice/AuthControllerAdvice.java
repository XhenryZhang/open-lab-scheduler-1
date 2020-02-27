package edu.ucsb.cs56.ucsb_open_lab_scheduler.advice;

import edu.ucsb.cs56.ucsb_open_lab_scheduler.entities.User;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.repositories.UserRepository;
import edu.ucsb.cs56.ucsb_open_lab_scheduler.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;



//code gets ran after login
@ControllerAdvice
public class AuthControllerAdvice {

    @Autowired   
    private MembershipService membershipService;

    private UserRepository userRepository;

    @ModelAttribute("isLoggedIn")
    public boolean getIsLoggedIn(OAuth2AuthenticationToken token){
        return token != null;
    }

    @ModelAttribute("id")
    public String getUid(OAuth2AuthenticationToken token){
        return "stub";
        // if (token == null) return "";
        // return token.getPrincipal().getAttributes().get("given_name").toString();
    }

    @ModelAttribute("fname")
    public String getFirstName(OAuth2AuthenticationToken token){
        if (token == null) return "";
        return token.getPrincipal().getAttributes().get("given_name").toString();
    }

    @ModelAttribute("lname")
    public String getLastName(OAuth2AuthenticationToken token){
        if (token == null) return "";
        return token.getPrincipal().getAttributes().get("family_name").toString();
    }


    @ModelAttribute("picture")
    public String getPicture(OAuth2AuthenticationToken token){
        // return "stub";
        if (token == null) return "";
        return token.getPrincipal().getAttributes().get("picture").toString();
    }

    @ModelAttribute("login")
    public String getLogin(OAuth2AuthenticationToken token){
        // return "stub";
        if (token == null) return "";
        return token.getName();
    }

    @ModelAttribute("email")
    public String getEmail(OAuth2AuthenticationToken token){
        if (token == null) return "";
        return token.getPrincipal().getAttributes().get("email").toString();
    }

    //code gets ran after login
    @ModelAttribute("oauth")
    public Object getOauth(OAuth2AuthenticationToken token){
        // userRepository.save(new User(getEmail(token),getFirstName(token),getLastName(token)));
        // System.out.println(userRepository);
        return token;
    }
    
    @ModelAttribute("isMember")
    public boolean getIsMember(OAuth2AuthenticationToken token){
        return membershipService.isMember(token);
    }
    @ModelAttribute("isAdmin")
    public boolean getIsAdmin(OAuth2AuthenticationToken token){
        return membershipService.isAdmin(token);
    }

    @ModelAttribute("role")
    public String getRole(OAuth2AuthenticationToken token){
        return membershipService.role(token);
    }
}