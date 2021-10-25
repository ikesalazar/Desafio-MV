package mv.desafio.breakfast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mv.desafio.breakfast.entities.Employee;
import mv.desafio.breakfast.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping({"/listemployee", "/listemployee/"})
	public String showListEmployee (Model model) {
		
		List<Employee> employees = this.employeeRepository.findAll();
		
		model.addAttribute("employees", employees);
		
		return "listemployee";
	}
	
	
	@GetMapping({"/employee", "/employee/"})
    public String showNewEmployee() {
        return "newemployee";
    }
	
	@PostMapping({"/employee/creat", "/employee/creat/"})
	public String creatEmployee(
			@RequestParam(value = "cpf", required = false) String cpf, 
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "item", required = false) String item,
			Model model) {
		
		Employee employee = new Employee();
		employee.setCpf(cpf);
		employee.setName(name);
		employee.setBreakfastItem(item);
		
		this.employeeRepository.save(employee);
		model.addAttribute("success", "Cadastrado com sucesso!");
		
		return "newemployee";
	}
	
	@GetMapping({"/listemployee/delete/{name}", "/listemployee/delete/{name}/"})
	public String deleteEmployee(@PathVariable(value="name") String name, Model model){
		Employee employee = employeeRepository.findByName(name);
		employeeRepository.delete(employee);
		
		model.addAttribute("delete", "Deletado com sucesso!");
		
		return "listemployee";
		
	}
	
	
}
