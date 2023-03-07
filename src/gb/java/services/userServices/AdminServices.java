package services.userServices;

import model.Question;
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

        DataServices.writeData(new Toy(id, title, Integer.parseInt(amount), Integer.parseInt(priority)), true);
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

        int id = DataServices.getQuestions().size() + 1;

        System.out.println("Введите текст загадки: ");
        String text = scanner.nextLine();
        Question question = new Question(id, text, 0);

        while (true) {
            System.out.println("Добавьте вариант ответа: ");
            String variant = scanner.nextLine();
            question.getListAnswer().add(variant);
            if (retryEnter("Вариант")) {
                break;
            }
        }

        do {
            System.out.println("Введите цифру, правильного варианта ответа.");
            text = scanner.nextLine();
        }
        while (!text.matches("[0-9]"));

        question.setTrueAnswer(Integer.parseInt(text));

        DataServices.writeQuestion(question);
    }

    public void getQuestionList() {
        List<Question> list = DataServices.getQuestions();
        System.out.println("====================================================");
        System.out.println("=========== Список вопросов викторины ==============");
        System.out.println("====================================================");
        for (Question question : list) {
            System.out.printf("Вопрос: %s\nНомер правильного ответа: \"%d\"\n", question.getBody(), question.getTrueAnswer());
            System.out.println("__________________________________________________________________________");
        }

    }

    /*
    метод проверка повторного ввода вариантов ответов
     */
    private boolean retryEnter(String str) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Добавить еще один %s? Введите 1, для выхода введите 0\n:>>> ", str);
        String variant = scanner.nextLine();
        while (true) {
            if (variant.equals("1")) {
                return false;
            }
            if (variant.equals("0")) {
                return true;
            } else {
                System.out.println("Некорректное значение, повторите ввод.");
            }
        }

    }
}



