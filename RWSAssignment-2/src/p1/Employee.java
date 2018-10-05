package p1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@Entity
@Table(name="Emp_Tab")
@XmlType(propOrder={"designation","salary","name","employeeId"})
public class Employee {

	@Id
	private int employeeId;
	private String name;
	private float salary;
	private String designation;
	public Employee() {
		super();
	}
	public Employee(int employeeId, String name, float salary, String designation) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", designation="
				+ designation + "]";
	}
	
}
