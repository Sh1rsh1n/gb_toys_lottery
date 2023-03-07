package view;

import model.Toy;
import services.DataServices;
import services.userServices.AdminServices;

import java.util.List;
import java.util.Scanner;

/*
класс, отображение интерфейса для работы в режиме администратора
обработка запросов и данных из консоли
*/
public class AdminView extends BaseView {

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
                    3. Добавить вопрос для викторины.
                    4. Показать список всех вопросов викторины.
                    0. Выход из программы.""");
            String input = scanner.nextLine();

            while (true) {
                if (input.equals("1")) {
                    services.addToy();
                    input = retryAsk();
                    continue;
                }

                if (input.equals("2")) {
                    showToysList();
                    input = retryAsk();
                    continue;
                }

                if (input.equals("3")) {
                    services.addQuestion();
                    input = retryAsk();
                    continue;
                }

                if (input.equals("4")) {
                    services.getQuestionList();
                    input = retryAsk();
                    continue;
                }

                if (input.equals("0")) {
                    return;
                } else {
                    System.out.println("Некорректное значение, повторите ввод.");
                }
            }
        }
    }

    private String retryAsk() {
        System.out.println("============================================");
        System.out.println("""
                \tДобавить еще игрушку, введите: "1"
                \tПросмотр списка игрушек, введите: "2"
                \tДобавить еще вопрос викторины, введите: "3"
                \tПоказать список вопросов викторины, введите: "4"
                \tДля выхода введите: "0\"""");
        return new Scanner(System.in).nextLine();
    }
}



