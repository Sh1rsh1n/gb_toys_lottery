package view;

import model.Toy;
import services.AdminServices;
import services.DataServices;

import java.util.List;
import java.util.Scanner;

public class AdminView implements BaseView {

	private final AdminServices adminServices;

	public AdminView() {
		this.adminServices = new AdminServices();
	}

	@Override
	public void action() {
		System.out.println("Enter password: ");
		Scanner scanner = new Scanner(System.in);
		String password = scanner.nextLine();

		while (adminServices.checkPassword(password)) {
			System.out.println("""
					Select action (enter number):
					1. Add toy to list
					2. Show toys list
					3. Change admin password
					0. Exit""");
			String input = scanner.nextLine();

			while(true) {
				if (input.equals("1")) {
				
				adminServices.addToy();

				System.out.println("Add toys more, enter \"1\", For exit, enter \"0\"");
				input = scanner.nextLine();
				continue;
				}

				if (input.equals("2")) {
					List<Toy> list = DataServices.readData();
					System.out.println("Toys list:");
					for (Toy toy: list) {
						System.out.printf("\t%s\n", toy);
					}
					
					System.out.println("Add toy, enter \"1\". For exit, enter \"0\"");
				}

				if (input.equals("3")) {

				}

				if (input.equals("0")) {
					break;
				}
			}	
		}

		scanner.close();
	}


}



