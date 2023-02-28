package view;

import services.AdminServices;

import java.util.Scanner;

public class AdminView implements BaseView {

	Scanner scanner;

	AdminServices adminServices;

	public AdminView() {
		scanner = new Scanner(System.in);
	}

	@Override
	public void action() {
		String password = scanner.nextLine();

		while (adminServices.checkPassword(password)) {
			System.out.println("""
					Select action (enter number):
					1. Add prize to list
					2. Show prizes list
					3. Change admin password
					0. Close app""");
			String input = scanner.nextLine();

			if (input.equals("1")) {

			}

			if (input.equals("2")) {

			}

			if (input.equals("3")) {

			}

			if (input.equals("0")) {

			}

		}

		scanner.close();
	}


}



