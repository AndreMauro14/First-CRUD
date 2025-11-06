package application;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main (String []args) {
		Scanner sc = new Scanner (System.in);
	
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("\n=== TESTE 1 Seller by ID ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TESTE 2 Seller by DepartmentID ===");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 3 Seller by findAll ===");
		List<Seller> all = sellerDao.findAll();
		
		for(Seller obj : all) {
			System.out.println(obj);
		}
		
		Date data = Date.valueOf("2006-02-03");
		System.out.println("\n=== TESTE 4 Seller Insert ===");
		Seller newSeller = new Seller (null, "Aylla Vitoria", "aylla@gmail.com", data, 1519.89, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! ID = " + newSeller.getId());
		
		
		System.out.println("\n=== TESTE 5 Seller Update ===");
		seller = sellerDao.findById(1);
		seller.setNome("Lionel Messi");
		sellerDao.update(seller);
		System.out.println("Update! New name = Lionel Messi");
		
		System.out.println("\n=== TESTE 6 Seller DeleteById ===");
		System.out.println("Digite o Id do funcionario que você quer deletar :");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Vendendor com o Id "+id+" foi deletado com sucesso!");
		
		sc.close();
	}

}
