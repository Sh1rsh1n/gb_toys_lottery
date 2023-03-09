package services.userServices;

import model.Question;
import model.Toy;
import services.DataServices;
import java.util.List;
import java.util.Random;

/*
    класс, обрабатывает запросы из интерфейса потребителя
*/
public class ConsumerServices {

    public String getPrize() {
        List<Toy> toyList = DataServices.readData();
        int value = priorityValue();

        for (Toy toy : toyList) {
            if (toy.getPriority() == value) {
                if (toy.getAmount() > 0) {
                    toy.setAmount(toy.getAmount() - 1);
                    DataServices.reWriteData(toyList);
                    return toy.getTitle();
                } else {
                    getPrize();
                    toyList.remove(toy);
                    DataServices.reWriteData(toyList);
                }
            }
        }
        return getPrize();
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
        генерация рандомного значения, для получения приза(игрушки)
        чем меньше значение, тем больше шанс получить приз.
    */
    private int priorityValue() {
        int seed = new Random().nextInt(9) + 1;
        return new Random().nextInt(seed + 1);
    }

}