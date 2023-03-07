package view;

import model.Question;
import model.Toy;
import services.DataServices;
import services.userServices.ConsumerServices;

import java.util.List;
import java.util.Scanner;

/*
класс, отображение интерфейса для работы в режиме потребителя
обработка запросов и данных из консоли
*/
public class ConsumerView extends BaseView {

    private final ConsumerServices services;

    public ConsumerView() {
        services = new ConsumerServices();
    }

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                    Выберите действие (введите нужное число):
                    1. Участвовать в викторине и получить приз.
                    2. Показать список всех игрушек.
                    0. Выход из программы.""");
        String input = scanner.nextLine();

        while (true) {

            if (input.equals("1")) {
                List<Question> list = DataServices.getQuestions();
                Question question = services.choiceQuestion(list);

                System.out.print("\t\tОтгадай загадку, получишь приз:\n");
                System.out.printf("%s\nВыберите вариант ответа\n", question.getBody());
                for (String str : question.getListAnswer()) {
                    System.out.printf("\t%s\n", str);
                }

                input = scanner.nextLine();
                while (true) {
                    if (input.equals(String.valueOf(question.getTrueAnswer()))) {
                        String toy = services.getPrize();
                        System.out.printf("ПОЗДРАВЛЯЕ!!! ВАШ ПРИЗ: >>> %s <<<\n", toy);
                        break;
                    } else {
                        System.out.println("Вы не угадали, попробуйте еще раз.");
                        input = scanner.nextLine();
                    }
                }
                System.out.println("============================================");
                System.out.println("\tУчаствовать в викторине еще, введите: \"1\".\n\tПросмотр списка игрушек, введите \"2\".\n\tДля выхода введите: \"0\"\n");
                input = scanner.nextLine();
            }

            if (input.equals("2")) {
                showToysList();

                System.out.println("============================================");
                System.out.println("Участвовать в викторине, введите: \"1\", Для выхода введите: \"0\"");
                input = scanner.nextLine();
            }

            if (input.equals("0")) {
                break;
            } else {
                System.out.println("Некорректное значение, повторите ввод.");
            }
        }
    }
}



