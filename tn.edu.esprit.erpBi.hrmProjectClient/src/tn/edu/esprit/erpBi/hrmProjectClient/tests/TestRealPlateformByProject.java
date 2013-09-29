package tn.edu.esprit.erpBi.hrmProjectClient.tests;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.erpBi.hrmProject.domain.Employee;
import tn.edu.esprit.erpBi.hrmProject.domain.Project;
import tn.edu.esprit.erpBi.hrmProject.services.interfaces.HrmCrudServicesRemote;
import tn.edu.esprit.erpBi.hrmProject.services.interfaces.HrmServicesRemote;

public class TestRealPlateformByProject {
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			HrmCrudServicesRemote proxyCRUD = (HrmCrudServicesRemote) context
					.lookup("ejb:/tn.edu.esprit.erpBi.hrmProject/HrmCrudServices!tn.edu.esprit.erpBi.hrmProject.services.interfaces.HrmCrudServicesRemote");

			HrmServicesRemote proxy = (HrmServicesRemote) context
					.lookup("ejb:/tn.edu.esprit.erpBi.hrmProject/HrmServices!tn.edu.esprit.erpBi.hrmProject.services.interfaces.HrmServicesRemote");

			Employee employee = new Employee();
			employee.setNameEmployee("foulen");
			Employee employee2 = new Employee();
			employee2.setNameEmployee("foulen2");

			List<Employee> employees = new ArrayList<Employee>();
			employees.add(employee);
			employees.add(employee2);

			Project project = new Project();
			project.setDescriptionProject("project1");
			project.linkEmployeesToThisProject(employees);

			proxy.addProject(project);
		}

		catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
