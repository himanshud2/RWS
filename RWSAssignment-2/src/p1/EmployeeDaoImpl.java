package p1;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utility.SessionProvider;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		Session session=SessionProvider.getSession();
		List<Employee> employees=session.createQuery("from Employee").list();
		return employees;
	}

	@Override
	public String insert(Employee employee) {
		// TODO Auto-generated method stub
		Session session=SessionProvider.getSession();
		Transaction transaction=session.beginTransaction();
		session.save(employee);
		transaction.commit();
		return "Inserted";
	}

	@Override
	public List<Employee> getEmployeeBySalary(float x, float y) {
		// TODO Auto-generated method stub
		Session session=SessionProvider.getSession();
		Query query=session.createQuery("from Employee where salary>? and salary<?");
		query.setFloat(0, x);
		query.setFloat(1, y);
		List<Employee> employees=query.list();
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Session session=SessionProvider.getSession();
		Employee employee=(Employee) session.get(Employee.class, id);
		return employee;
	}

	@Override
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session=SessionProvider.getSession();
		Transaction transaction=session.beginTransaction();
		//Employee employee2=(Employee) session.get(Employee.class, employee.getEmployeeId());
		session.update(employee);
		transaction.commit();
		return "Updated";
	}

	@Override
	public String updateEmployeeName(String name, Employee employee) {
		// TODO Auto-generated method stub
		Session session=SessionProvider.getSession();
		Transaction transaction=session.beginTransaction();
		//Employee employee2=(Employee) session.get(Employee.class, employee.getEmployeeId());
		employee.setName(name);
		session.update(employee);
		transaction.commit();
		return "Name Updated";
	}

	@Override
	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Session session=SessionProvider.getSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Employee where employeeId=?");
		query.setInteger(0, id);
		List<Employee> elements=query.list();
		for (Employee employee : elements) {
			session.delete(employee);
		}
		transaction.commit();
		return "Deleted";
	}

	@Override
	public String deleteEmployeeAll() {
		// TODO Auto-generated method stub
		Session session=SessionProvider.getSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Employee");
		List<Employee> elements=query.list();
		for (Employee employee : elements) {
			session.delete(employee);
		}
		transaction.commit();
		return "All Records Deleted";
	}

	@Override
	public List<Employee> getEmployeeInReverse() {
		// TODO Auto-generated method stub
		Session session=SessionProvider.getSession();
		Query query=session.createQuery("from Employee");
		List<Employee> employees=query.list();
		return employees;
	}
	
}
