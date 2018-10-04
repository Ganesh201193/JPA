package example.jpa;


import javax.persistence.*;


public class EmployeeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		EmployeeService service = new EmployeeService(em);
		em.getTransaction().begin();
		Employee emp = service.createEmployee(12345, "Punit", 50000);
		em.getTransaction().commit();
		System.out.println("Persisted "+emp);
		
		emp= service.findEmployee(12345);
		System.out.println("Found "+emp);
		
		em.getTransaction().begin();
		emp =service.raiseEmployeeSalary(12345, 20000);
		em.getTransaction().commit();
		System.out.println("Updated "+emp);
		em.close();
		emf.close();
	}

}
