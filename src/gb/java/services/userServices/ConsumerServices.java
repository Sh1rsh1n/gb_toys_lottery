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

/*
    класс, обрабатывает запросы из интерфейса потребителя
*/
public class ConsumerServices {

    private final static String path = "question.txt";

    /*
        
    */
    public Toy getPrize() {
        List<Toy> toyList = DataServices.readData();
        int value = priorityValue();
        System.out.println(toyList);

        for (Toy toy : toyList) {
            if (toy.getPriority() == value) {
                if (toy.getAmount() > 0) {
                    toy.setAmount(toy.getAmount() - 1);
                    DataServices.reWriteData(toyList);
                    return toy;
                } else {
                    getPrize();
                    toyList.remove(toy);
                    DataServices.reWriteData(toyList);
                }
            }
        }
    }
    
    /*
        метод, получение данных о всех игрушках в виде списка
    */
    public List<Toy> getPrizesList() {
        return DataServices.readData();
    }

    /*
        метод, обрабатывает запрос к списку вопросов и рандомно возвращает один из вопросов
    */
    public Question choiceQuestion(List<Question> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    /*
        
    */
    private int priorityValue() {
        int seed = new Random().nextInt(9) + 1;
        return new Random().nextInt(seed + 1);
    }

}