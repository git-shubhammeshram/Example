package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(name = "read",query = "from Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	
	@Column
	private String emp_name;
	
	@Column
	private int emp_sallary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String emp_name, int emp_sallary) {
		super();
		this.emp_name = emp_name;
		this.emp_sallary = emp_sallary;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getEmp_sallary() {
		return emp_sallary;
	}

	public void setEmp_sallary(int emp_sallary) {
		this.emp_sallary = emp_sallary;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_sallary=" + emp_sallary + "]";
	}
	
	
	
	

}
