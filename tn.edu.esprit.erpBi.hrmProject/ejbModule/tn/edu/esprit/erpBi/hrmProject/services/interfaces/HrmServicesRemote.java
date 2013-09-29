package tn.edu.esprit.erpBi.hrmProject.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.erpBi.hrmProject.domain.Employee;
import tn.edu.esprit.erpBi.hrmProject.domain.Project;

@Remote
public interface HrmServicesRemote {
	public void assignProjectToEmployee(Project project, Employee employee);

	public void assignEmployeesToProject(List<Employee> employees, int idProject);

	public void addProject(Project project);

}
