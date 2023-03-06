package model;

public class Question {

    private int id;

    private String body;

    private String firstAnswer;

    private String secondAnswer;

    private String thirdAnswer;

    private int trueAnswer;

    public Question(int id, String body, String firstAnswer, String secondAnswer, String thirdAnswer, int trueAnswer) {
        this.id = id;
        this.body = body;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.trueAnswer = trueAnswer;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }
}
