package view;

import model.Toy;
import services.DataServices;

import java.util.List;

/*
базовый интерфейс для всех классов отображения 
пользовательского интерфейса
*/
public abstract class BaseView{

    public abstract void action();

    public void showToysList() {
        List<Toy> list = DataServices.readData();
        System.out.println("============================================");
        System.out.println("=========== Список игрушек =================");
        System.out.println("============================================");
        for (Toy toy : list) {
            System.out.printf("Название игрушки: %s, Количество: %d шт., Коэффициент получения приза: %d\n", toy.getTitle(), toy.getAmount(), (toy.getPriority()));
            System.out.println("__________________________________________________________________________");
        }
        System.out.println("Справка по коэффициент получения приза:\n" +
                "Чем больше коэффициент получения приза, тем меньше шанс получить приз\n" +
                "то есть с коэффициентом '9' шанс примерно 1 к 100");
    }
}

