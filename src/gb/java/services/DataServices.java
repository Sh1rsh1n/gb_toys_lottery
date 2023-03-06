package services;

import model.Toy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataServices {

    private final static String path = "toys_lottery_list.txt";

    public static void writeData(Toy toy, boolean newLine) {

        try (FileWriter writer = new FileWriter(path, newLine)) {
            writer.write(toy.getId() + ",");
            writer.write(toy.getTitle() + ",");
            writer.write(toy.getAmount() + ",");
            writer.write(toy.getPriority() + "\n");
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void reWriteData(List<Toy> toysList) {
        for (Toy toy : toysList) {
            writeData(toy, false);
        }
    }

    public static List<Toy> readData() {

        try {
            new File(path).createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Toy> list = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
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
}



