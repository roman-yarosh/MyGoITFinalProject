package ua.goit.finall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.finall.model.Employee;
import ua.goit.finall.model.User;
import ua.goit.finall.service.EmployeeService;
import ua.goit.finall.service.UserService;

import java.util.Map;

@Controller
public class EmployeesController {

    private Logger logger = LoggerFactory.getLogger(EmployeesController.class.getName());

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/employeeInfo")
    public String employeeInfo(Map<String, Object> model) {
        String userName = getLoggedinUserName();
        User user = userService.findUserByUsername(userName);
        Employee employee = employeeService.findEmployeeByUser(user);
        model.put("emp", employee);
        logger.info("Empn - " + userName);
        logger.info("Event - " + employee.getEventList());

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
