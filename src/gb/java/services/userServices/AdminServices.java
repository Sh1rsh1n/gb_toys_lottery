package services.userServices;

import model.Toy;
import services.DataServices;

import java.util.List;
import java.util.Scanner;

/*
	класс, обрабатывает запросы из интерфейса администратора
*/
public class AdminServices {

	/*
		метод, обработка и добавление данных об игрушке в файл
	*/
	public void addToy() {
		Scanner scanner = new Scanner(System.in);

		int id = getPrizesList().size() + 1;

		System.out.println("Введите название игрушки: ");
		String title = scanner.nextLine();

		String amount;
		do {
			System.out.println("Введите количество игрушек: ");
			amount = scanner.nextLine();
		} while (!amount.matches("\\d+"));

		String priority;
		do {
			System.out.println("Введите шанс получения игрушки от 1 до 9: ");
			priority = scanner.nextLine();
		} while (!priority.matches("[1-9]"));

      DataServices.writeData(new Toy(id, title, Integer.parseInt(amount), Integer.parseInt(priority)),true);
   }

	/*
		метод, получение данных о всех игрушках в виде списка
	*/
   public List<Toy> getPrizesList() {
      return DataServices.readData();
   }

	/*
		проверка пароля администратора
	*/
   public boolean checkPassword(String password) {
      return password.matches("123456");
   }
	
	/*
		метод, обработка и добавление данных о вопросах к викторине в файл
	*/
	public void addQuestion() {
		Scanner scanner = new Scanner(System.in);
		
		int id = DataServices.getQuestions().size + 1;
		
		
		
	}
}



