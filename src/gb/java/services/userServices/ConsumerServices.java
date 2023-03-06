package services.userServices;

import model.Question;
import model.Toy;
import services.DataServices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsumerServices {

    private final static String path = "question.txt";

    public void getPrize() {
        List<Toy> toyList = DataServices.readData();
        int value = priorityValue();
        System.out.println(toyList);

        for (Toy toy : toyList) {
            if (toy.getPriority() == value) {
                if (toy.getAmount() > 0) {
                    System.out.printf("Поздравляю!!! Вы выиграли: %s", toy.getTitle());
                    toy.setAmount(toy.getAmount() - 1);
                    System.out.println(toyList);
                } else {
                    getPrize();
                    toyList.remove(toy);
                    DataServices.reWriteData(toyList);
                }
                return;
            }
        }
    }

    public List<Toy> getPrizesList() {
        return DataServices.readData();
    }

    public List<Question> readQuestions() {
        List<Question> list = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String str;
            while ((str = bf.readLine()) != null) {

                String[] array = str.split(";");

                Question question = new Question(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], Integer.valueOf(array[5]));
                list.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Question choiceQuestion(List<Question> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    private int priorityValue() {
        int seed = new Random().nextInt(9) + 1;
        return new Random().nextInt(seed + 1);
    }

}