package softuni.workshop.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.workshop.service.services.EmployeeService;
import softuni.workshop.service.services.ProjectService;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {
    private ProjectService projectService;
    private EmployeeService employeesService;

    @Autowired
    public ExportController(ProjectService projectService, EmployeeService employeesService) {
        this.projectService = projectService;
        this.employeesService = employeesService;
    }

    @GetMapping("/project-if-finished")
    public ModelAndView getFinishedProjects() {
        return new ModelAndView("export/export-project-if-finished", "finished",
                projectService.exportFinishedProjects());
    }

    @GetMapping("/employees-above")
    public ModelAndView getEmployeesAbove25() {
        return new ModelAndView("export/export-employees-with-age", "employeesAbove",
                employeesService.exportEmployeesWithAgeAbove(25));
    }
}
