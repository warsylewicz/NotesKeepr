package noteKeepr.controllers;

import noteKeepr.models.RegisterDto;
import noteKeepr.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController
{
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String registrationForm(Model model)
    {
        model.addAttribute("registerDto", new RegisterDto());
        return "register";
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String registrationSubmit(@ModelAttribute RegisterDto registerDto, Model model)
    {
        if ( accountService.isValid(registerDto) )
        {
            return "welcome";
        }
        else
        {
            return "register";
        }
    }
}
