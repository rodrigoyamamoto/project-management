package co.pma.controllers;

import co.pma.dao.ProjectRepository;
import co.pma.entities.Employee;
import co.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping
    public String displayEmployees(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        return "projects/list-projects";
    }
    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();
        model.addAttribute("project", aProject);

        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project) {
        projectRepository.save(project);

        return "redirect:/projects/new";
    }
}
