package p1;

import java.util.List;

public interface EmployeeDao {

	public List<Employee> getEmployee();
	public String insert(Employee employee);
	public List<Employee> getEmployeeBySalary(float x,float y);
	public Employee getEmployeeById(int id);
	public String updateEmployee(Employee employee);
	public String updateEmployeeName(String name, Employee employee);
	public String deleteEmployee(int id);
	public String deleteEmployeeAll();
	public List<Employee> getEmployeeInReverse();
}
