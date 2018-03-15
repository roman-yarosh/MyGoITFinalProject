package ua.goit.finall.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ua.goit.finall.model.Salary;
import ua.goit.finall.model.User;
import ua.goit.finall.service.EmployeeService;
import ua.goit.finall.service.SalaryService;
import ua.goit.finall.service.UserService;

import javax.validation.Valid;
import java.util.List;

import static ua.goit.finall.utils.Utils.getLoggedinUserName;

@RestController
@RequestMapping(value = "api/personalSalaries")
public class PersonalSalaryRestController {

    @Autowired
    SalaryService salaryService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    UserService userService;

    @PreAuthorize("#employee.user.id == principal.id")
    @RequestMapping(path = "/{fromYear}/{fromMonth}/{toYear}/{toMonth}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Salary>> getPersonalSalaries(@PathVariable("fromYear") Integer fromYear, @PathVariable("fromMonth") Integer fromMonth,
                                                            @PathVariable("toYear") Integer toYear, @PathVariable("toMonth") Integer toMonth) {
        String username = getLoggedinUserName();
        User user = userService.findUserByUsername(username);
        Long employeeId = employeeService.findEmployeeByUser(user).getId();
        List<Salary> salaryList = this.salaryService.getPersonalSalaries(employeeId, fromYear, fromMonth, toYear, toMonth);

        if (salaryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(salaryList, HttpStatus.OK);
    }
}
