package ua.goit.finall.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.goit.finall.model.Employee;
import ua.goit.finall.service.EmployeeService;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeesController {
    private Logger logger = LoggerFactory.getLogger(EmployeesController.class.getName());
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employeeInfo")
    public String employeeInfo(Map<String, Object> model) {
        String userName = getLoggedinUserName();
        Employee employee = employeeService.findEmployeeByName(userName);
        model.put("emp", employee);
        logger.info("Empn - " + userName);
        logger.info("Event - " + employee.getEvent());

        return "employeeInfo";
    }

    private String getLoggedinUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }
}
