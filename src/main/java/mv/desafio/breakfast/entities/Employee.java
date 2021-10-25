package mv.desafio.breakfast.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "employee")
public class Employee {
	
	@Id
    @Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "item", nullable = false, length = 100)
	private String breakfastItem;
	
	public Employee() {}
	
	public Employee(String cpf, String name, String breakfastItem) {
		this.cpf = cpf;
		this.name = name;
		this.breakfastItem = breakfastItem;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreakfastItem() {
		return breakfastItem;
	}

	public void setBreakfastItem(String breakfastItem) {
		this.breakfastItem = breakfastItem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(breakfastItem, cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(breakfastItem, other.breakfastItem) && Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Employee [cpf=" + cpf + ", name=" + name + ", breakfastItem=" + breakfastItem + "]";
	}
	
}
