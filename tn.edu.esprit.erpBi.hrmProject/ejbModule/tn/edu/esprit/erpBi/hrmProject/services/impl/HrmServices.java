package tn.edu.esprit.erpBi.hrmProject.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.erpBi.hrmProject.domain.Employee;
import tn.edu.esprit.erpBi.hrmProject.domain.Project;
import tn.edu.esprit.erpBi.hrmProject.services.interfaces.HrmServicesLocal;
import tn.edu.esprit.erpBi.hrmProject.services.interfaces.HrmServicesRemote;

/**
 * Session Bean implementation class HrmServices
 */
@Stateless
public class HrmServices implements HrmServicesRemote, HrmServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public HrmServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void assignProjectToEmployee(Project project, Employee employee) {
		Project projectFound = entityManager.merge(project);
		Employee employeeFound = entityManager.merge(employee);
		employeeFound.setProject(projectFound);
		entityManager.merge(employeeFound);

	}

	@Override
	public void assignEmployeesToProject(List<Employee> employees, int idProject) {

		Project projectFound = entityManager.find(Project.class, idProject);
		projectFound.setEmployees(employees);

		entityManager.merge(projectFound);

	}

	@Override
	public void addProject(Project project) {
		entityManager.persist(project);

	}

}
