package tn.edu.esprit.erpBi.hrmProjectClient.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.edu.esprit.erpBi.hrmProject.domain.Employee;
import tn.edu.esprit.erpBi.hrmProject.domain.Project;
import tn.edu.esprit.erpBi.hrmProject.services.interfaces.HrmCrudServicesRemote;
import tn.edu.esprit.erpBi.hrmProject.services.interfaces.HrmServicesRemote;

public class TestRealPlateform {
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			HrmCrudServicesRemote proxyCRUD = (HrmCrudServicesRemote) context
					.lookup("ejb:/tn.edu.esprit.erpBi.hrmProject/HrmCrudServices!tn.edu.esprit.erpBi.hrmProject.services.interfaces.HrmCrudServicesRemote");

			HrmServicesRemote proxy = (HrmServicesRemote) context
					.lookup("ejb:/tn.edu.esprit.erpBi.hrmProject/HrmServices!tn.edu.esprit.erpBi.hrmProject.services.interfaces.HrmServicesRemote");

			Employee employee=new Employee();
			employee.setNameEmployee("foulen");
			
			Project project=new Project();
			project.setDescriptionProject("project1");
			
			proxy.assignProjectToEmployee(project, employee);
		}

		catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
