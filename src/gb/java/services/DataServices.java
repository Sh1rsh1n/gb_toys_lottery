package services;

import model.Toy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
    класс, реализует запись/чтение данных в/из файла
*/
public class DataServices {

    private final static String path_toys_list = "toys_lottery_list.txt";
    private final static String path_questions_list = "question.txt";

    /*
        метод добавления игрушки в файл
        @toy - игрушка, которую нужно добавить в список
        @newLine - параметр для записи в файл. true: добавление с новой строки, false: перезапись всего файла
    */
    public static void writeData(Toy toy, boolean newLine) {

        try (FileWriter writer = new FileWriter(path_toys_list, newLine)) {
            writer.write(toy.getId() + ",");
            writer.write(toy.getTitle() + ",");
            writer.write(toy.getAmount() + ",");
            writer.write(toy.getPriority() + "\n");
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
        метод перезаписывает данные в файле
        @toysList - список игрушек
    */ 
    public static void reWriteData(List<Toy> toysList) {
        for (Toy toy : toysList) {
            if (toy.getId == 1) {
                writeData(toy, false);
            }
            writeData(toy, true);
        }
    }
    
    /*
        метод получает данные о игрушках из файла
        @return - список игрушек
    */
    public static List<Toy> readData() {

        try {
            new File(path_toys_list).createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Toy> list = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(path_toys_list))) {
            String str;
            while ((str = bf.readLine()) != null) {

                String[] array = str.split(",");

                Toy toy = new Toy(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]));
                list.add(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    /*
        метод добавляет вопрос для викторины в файл
        @question - вопрос для викторины
    */ 
    public static void writeQuestion(Question question) {
        
        try (FileWriter writer = new FileWriter(path_questions_list, newLine)) {
            writer.write(question.getId() + ",");
            writer.write(question.getBody() + ",");
            int num = 0;
            for (String str: question.getListAnswer()) {
                writer.write(String.format("%d.%s,", ++num, str));
            }
            writer.write(question.getTrueAnswer() + "\n");
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /*
        метод получения данных о вопросах к викторине из файла
        @return - список вопросов
    */
    public static List<Question> getQuestions() {
        
        try {
            new File(path_questions_list).createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        List<Question> list = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(path_questions_list))) {
            String str;
            while ((str = bf.readLine()) != null) {

                String[] array = str.split(";");

                Question question = new Question(
                Integer.parseInt(array[0]), array[1],  
                Integer.valueOf(array[array.lenght - 1]));
                
                
                list.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}



