package mv.desafio.breakfast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mv.desafio.breakfast.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
	
	List<Employee> findByCpf(String cpf);
	
	Employee findByName(String name);
	

}
