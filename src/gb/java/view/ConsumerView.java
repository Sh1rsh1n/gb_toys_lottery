package view;

import model.Question;
import services.userServices.ConsumerServices;

import java.util.List;
import java.util.Scanner;

public class ConsumerView implements BaseView {

    private final ConsumerServices services;

    public ConsumerView() {
        services = new ConsumerServices();
    }

    @Override
    public void action() {

        List<Question> list = services.readQuestions();
        Question question = services.choiceQuestion(list);

        System.out.print("\t\tОтгадай загадку, получишь приз:\n");
        System.out.printf("%s\n\t%s\n\t%s\n\t%s\n(Выберите вариант ответа)\n:>>> ", question.getBody(), question.getFirstAnswer(), question.getSecondAnswer(), question.getThirdAnswer());
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        while (true) {
            if (answer == question.getTrueAnswer()) {
                services.getPrize();
                break;
            } else {
                System.out.println("Вы не угадали, попробуйте еще раз.");
                answer = scanner.nextInt();
            }
        }
    }
}



