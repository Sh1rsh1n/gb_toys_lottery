package view;

import model.Toy;
import services.AdminServices;
import services.DataServices;

import java.util.List;
import java.util.Scanner;

public class AdminView implements BaseView {

	private final Scanner scanner;

	private final AdminServices adminServices = new AdminServices();

	public AdminView() {
		scanner = new Scanner(System.in);
	}

	@Override
	public void action() {
		System.out.println("Enter password: ");
		String password = scanner.nextLine();

		while (adminServices.checkPassword(password)) {
			System.out.println("""
					Select action (enter number):
					1. Add toy to list
					2. Show toys list
					3. Change admin password
					0. Exit""");
			String input = scanner.nextLine();

			while (input.equals("1")) {
				int id = adminServices.getPrizesList().size() + 1;

				System.out.println("Enter Toy title: ");
				String title = scanner.nextLine();

				String amount;
				do {
					System.out.println("Enter amount of toys: ");
					amount = scanner.nextLine();
				} while (!amount.matches("\\d"));

				String priority;
				do {
					System.out.println("Enter priority of toys (1-9): ");
					priority = scanner.nextLine();
				} while (!priority.matches("[1-9]"));

				adminServices.addToy(new Toy(id, title, Integer.parseInt(amount), Integer.parseInt(priority)));

				System.out.println("Add toys more, enter \"1\", else enter any symbol");
				input = scanner.nextLine();
			}

			if (input.equals("2")) {
				List<Toy> list = DataServices.readData();
				System.out.println("Toys list:");
				for (Toy toy: list) {
					System.out.printf("\t%s\n", toy);
				}
			}

			if (input.equals("3")) {

			}

			if (input.equals("0")) {
				break;
			}
		}

		scanner.close();
	}


}



