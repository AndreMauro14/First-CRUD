package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;


public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TESTE 1 Find by ID ===");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TESTE 2 Find All ===");
		List<Department> list = departmentDao.findAll();
		dep = departmentDao.findById(1);
		for(Department d : list) {
		System.out.println(d);
		
		System.out.println("\n=== TESTE 3 Insert ===");
		Department newDepartment = new Department(null, "Food");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted!");
		
		System.out.println("\n=== TESTE 4 Update ===");
		Department dep2 = departmentDao.findById(1);
		dep2.setNome("RH");
		departmentDao.update(dep2);
		System.out.println("UPDATE!");
		
		System.out.println("\n=== TESTE 5 Delete ===");
		System.out.print("Digite o ID para deletar :");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("DELETE!");
		
		sc.close();
		
		}
	}

}
