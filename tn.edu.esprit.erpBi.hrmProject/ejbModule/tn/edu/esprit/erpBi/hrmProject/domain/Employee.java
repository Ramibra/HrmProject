package tn.edu.esprit.erpBi.hrmProject.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity

public class Employee implements Serializable {

	
	private int idEmployee;
	private String nameEmployee;
	private static final long serialVersionUID = 1L;
	
	private Project project;

	public Employee() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdEmployee() {
		return this.idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}   
	public String getNameEmployee() {
		return this.nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}
	@ManyToOne
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
   
}
