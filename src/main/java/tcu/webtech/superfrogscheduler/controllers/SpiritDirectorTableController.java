package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.webtech.superfrogscheduler.models.User;
import tcu.webtech.superfrogscheduler.repositories.UserRepository;
import tcu.webtech.superfrogscheduler.services.UserDetailsImpl;
import tcu.webtech.superfrogscheduler.services.UserDetailsServiceImpl;
import tcu.webtech.superfrogscheduler.export.UserExport;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SpiritDirectorTableController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsServiceImpl service;

    @PreAuthorize("hasAuthority('SPIRITDIRECTOR')")
    @RequestMapping("/spiritdirectortable")
    public String spiritdirectortable(Model model, Authentication authentication) {
        UserDetailsImpl currentUser = (UserDetailsImpl) authentication.getPrincipal();

        List<User> allCustomers = userRepository.findAllByRole("CUSTOMER");
        List<User> allSuperFrogs = userRepository.findAllByRole("SUPERFROG");

        model.addAttribute("user", currentUser);
        model.addAttribute("customers", allCustomers);
        model.addAttribute("superfrogs", allSuperFrogs);
        return "spiritdirectortable";
    }

    @PostMapping("/spiritdirectortable/addCustomer")
    public String addCustomer() {
        return "";
    }

    @PostMapping("/spiritdirectortable/addSuperFrog")
    public String addSuperFrog() {
        return "";
    }


    @GetMapping("/spiritdirectortable/export")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        System.out.println("here");
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<User> listUsers = service.listAll();
        System.out.println(listUsers);
        UserExport excelExporter = new UserExport(listUsers);

        excelExporter.export(response);
    }

}
