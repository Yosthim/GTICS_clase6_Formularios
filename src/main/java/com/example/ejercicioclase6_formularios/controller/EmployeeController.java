package com.example.ejercicioclase6_formularios.controller;
import com.example.ejercicioclase6_formularios.entity.Employees;
import com.example.ejercicioclase6_formularios.repository.DepartmentsRepository;
import com.example.ejercicioclase6_formularios.repository.EmployeesRepository;
import com.example.ejercicioclase6_formularios.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import javax.jws.WebParam;
import jakarta.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    DepartmentsRepository departmentsRepository;

    @GetMapping(value = {"","/"})
    public String listaEmployee(Model model){
        model.addAttribute("listaEmployee", employeesRepository.findAll());
        model.addAttribute("listaJobs", jobsRepository.findAll());
        model.addAttribute("listaDepartments", departmentsRepository.findAll());
        return "employee/lista";
    }

    @GetMapping("/new")
    public String nuevoEmployeeForm(@ModelAttribute("employees") Employees employees, Model model) {
        //COMPLETAR
        model.addAttribute("type", "new");
        return "employee/Frm";
    }

    @PostMapping("/save")
    public String guardarEmployee(@ModelAttribute("employees") @Valid Employees employees, BindingResult bindingResult,
                                  RedirectAttributes attr,
                                  @RequestParam(name="fechaContrato", required=false) String fechaContrato, Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("listaJobs", jobsRepository.findAll());
            model.addAttribute("listaJefes", employeesRepository.findAll());
            model.addAttribute("listaDepartments", departmentsRepository.findAll());
            return "employee/Frm";
        }else {

            if (employees.getEmployeeId() == 0) {
                attr.addFlashAttribute("msg", "Empleado creado exitosamente");
                employees.setHireDate(LocalDateTime.now());
                employeesRepository.save(employees);
                return "redirect:/employee";
            } else {

                try {
                    employees.setHireDate(LocalDateTime.parse(fechaContrato));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                employeesRepository.save(employees);
                attr.addFlashAttribute("msg", "Empleado actualizado exitosamente");
                return "redirect:/employee";
            }
        }
    }

    public List<Employees> getListaJefes() {
        List<Employees> listaJefes = employeesRepository.findAll();
        Employees e = new Employees();
        e.setEmployeeId(0);
        e.setFirstName("--No tiene Jefe--");
        listaJefes.add(0, e);
        return listaJefes;
    }

    @GetMapping("/edit")
    public String editarEmpleado(@ModelAttribute("employees") Employees employees, Model model, @RequestParam("id") int id) {
        Optional<Employees> optional = employeesRepository.findById(id);

        if (optional.isPresent()) {
            employees = optional.get();
            model.addAttribute("employees", employees);
            model.addAttribute("listaJefes", getListaJefes());
            model.addAttribute("type", "edit");
            return "employee/Frm";
        } else {
            return "redirect:/employee";
        }

    }

    @GetMapping("/delete")
    public String borrarEmpleado(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Employees> optEmployees = employeesRepository.findById(id);

        if (optEmployees.isPresent()) {
            employeesRepository.deleteById(id);
            attr.addFlashAttribute("msg","Empleado borrado exitosamente");
        }
        return "redirect:/employee";

    }

    @PostMapping("/search")
    public String buscar (){

        //COMPLETAR
        return "employee/lista";
    }

}
