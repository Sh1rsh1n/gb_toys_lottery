package model;

/*
    @id - уникальный идентификатор вопроса
    @body - тело вопроса(обычный текст)
    @listAnswer - список вариантов ответов
    @trueAnswer - номер правильного ответа
*/
public class Question {

    private int id;

    private String body;

    private List<String> listAnswer;

    private int trueAnswer;

    public Question(int id, String body, int trueAnswer) {
        this.id = id;
        this.body = body;
        listAnswer = new ArrayList();
        this.trueAnswer = trueAnswer;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public getListAnswer() {
        return listAnswer;
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }
}
