package view;

import model.Toy;
import services.DataServices;
import services.userServices.AdminServices;

import java.util.List;
import java.util.Scanner;

public class AdminView implements BaseView {

    private final AdminServices services;

    public AdminView() {
        services = new AdminServices();
    }

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();

        while (true) {

            if (!services.checkPassword(password)) {
                System.out.println("Некорректный пароль, повторите ввод.\n:>>> ");
                password = scanner.nextLine();
                continue;
            }

            System.out.println("""
                    Выберите действие (введите нужное число):
                    1. Добавить игрушки в список.
                    2. Показать список всех игрушек.
                    3. Смена пароля администратора.
                    0. Выход из программы.""");
            String input = scanner.nextLine();

            while (true) {
                if (input.equals("1")) {

                    services.addToy();

                    System.out.println("============================================");
                    System.out.println("\tДобавить еще игрушку? \"1\".\n\tПросмотр списка игрушек, введите \"2\".\n\tДля выхода введите: \"0\"\n");
                    input = scanner.nextLine();
                    continue;
                }

                if (input.equals("2")) {
                    List<Toy> list = DataServices.readData();
                    System.out.println("============================================");
                    System.out.println("=========== Список игрушек =================");
                    System.out.println("============================================");
                    for (Toy toy : list) {
                        System.out.printf("\tНазвание игрушки: %s, Количество: %d шт., Шанс получения: %d\n", toy.getTitle(), toy.getAmount(), (toy.getPriority()));
                        System.out.println("============================================================================");

                    }

                    System.out.println("Добавить еще игрушку? \"1\", Для выхода введите: \"0\"");
                    input = scanner.nextLine();
                    continue;
                }

                if (input.equals("3")) {
                    // ToDo
                    continue;
                }

                if (input.equals("0")) {
                    scanner.close();
                    break;
                } else {
                    System.out.println("Некорректное значение, повторите ввод.");
                }
            }
        }
    }
}



