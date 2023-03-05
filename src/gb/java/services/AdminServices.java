package services;

import model.Toy;

import java.util.List;
import java.util.Scanner;


public class AdminServices{

	public void addToy() {
		Scanner scanner = new Scanner(System.in);

		int id = getPrizesList().size() + 1;

		System.out.println("Enter Toy title: ");
		String title = scanner.nextLine();

		String amount;
		do {
			System.out.println("Enter amount of toys: ");
			amount = scanner.nextLine();
		} while (!amount.matches("\\d+"));

		String priority;
		do {
			System.out.println("Enter priority of toys (1-9): ");
			priority = scanner.nextLine();
		} while (!priority.matches("[1-9]"));

      DataServices.writeData(new Toy(id, title, Integer.parseInt(amount), Integer.parseInt(priority)),true);
   }

   public List<Toy> getPrizesList() {
      return DataServices.readData();
   }

   public boolean checkPassword(String password) {
      return password.equals("123456");
   }
}



