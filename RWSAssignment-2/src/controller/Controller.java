package controller;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import p1.Employee;
import p1.EmployeeDaoImpl;

@Path(value = "controller")
public class Controller {

	EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
	
	@Path("get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees(){
		return employeeDaoImpl.getEmployee();
	}
	
	@Path("management/add")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertEmployees(Employee employee){
		return employeeDaoImpl.insert(employee);
	}
	
	@Path(value="getEmployeeBySalary/{x}/{y}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeeBySalary(@PathParam("x") float x1,@PathParam("y")float y1){
		return employeeDaoImpl.getEmployeeBySalary(x1, y1);
	}
	
	@Path(value="getEmployeeById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeBySalary(@PathParam("id") int eId){
		return employeeDaoImpl.getEmployeeById(eId);
	}
	
	@Path(value="management/update")
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateEmployee(Employee employee){
		return employeeDaoImpl.updateEmployee(employee); 
	}
	
	@Path(value="management/updateEmployeeName/{name}")
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateEmployeeName(@PathParam("name") String name1,Employee employee){
		return employeeDaoImpl.updateEmployeeName(name1, employee);
	}
	
	@Path(value="management/delete/{id}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteEmployee(@PathParam("id") int id1){
		return employeeDaoImpl.deleteEmployee(id1);
	}
	
	@Path(value="management/deleteall")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAllEmployee(){
		return employeeDaoImpl.deleteEmployeeAll();
	}
	
	@Path("getEmpInReverse")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeesInReverse(){
		return employeeDaoImpl.getEmployeeInReverse();
	}
	
}
