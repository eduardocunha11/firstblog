import java.util.ArrayList;
import java.util.Collections;

public class Principal {

	public static void main(String[] args) {
						
		//create some Emp objects
        ArrayList<Employee> listEmp = new ArrayList<Employee>();
        listEmp.add( new Employee("John", 98000, 40) );
        listEmp.add( new Employee("Mark", 67000, 42) );
        listEmp.add( new Employee("Oliver", 120000, 28) );
        listEmp.add( new Employee("Anne", 150000, 31) );
        
        //list without sorting
        System.out.println("Employee list without sorting");
        System.out.println( listEmp );
        
        //sort the list using age comparator
        Collections.sort( listEmp, new EmployeeAgeComparator() );
        
        System.out.println("Employee list after sorting by age");
        System.out.println(listEmp);
        
        //sort the list using salary comparator
        Collections.sort( listEmp, new EmployeeSalaryComparator() );
        
        System.out.println("Employee list after sorting by salary");
        System.out.println(listEmp);
        
        // sort the list using name comparator
        Collections.sort( listEmp, new EmployeeNameComparator() );
        
        System.out.println("Employee list after sorting by name");
        System.out.println(listEmp);
        

	}

}
