package model;

import java.util.Objects;

public class Toy implements Comparable<Toy> {

    private int id;

    private String title;

    private int priority;

    public Toy(int id, String title, int priority) {
        this.id = id;
        this.title = title;
	if (priority > 100 || priority < 1) {
		System.out.println("Некорректное значение параметра 'priority'.\nУстановлено значение по-умолчанию: 50");
		this.priority = 50;
	} else {
		this.priority = priority;
	}
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (id != toy.id) return false;
        if (priority != toy.priority) return false;
        return Objects.equals(title, toy.title);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + priority;
        return result;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(Toy toy) {
        return this.priority - toy.getPriority();
    }
}
