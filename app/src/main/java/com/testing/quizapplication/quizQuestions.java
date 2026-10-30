package com.testing.quizapplication;

public class quizQuestions{
    private int ansLocation;
    private boolean correct;
    public quizQuestions (int questionId,boolean correct){

        this.ansLocation = questionId;
        this.correct = correct;
    }
    public int getAnsLocation(){

        return ansLocation;
    }
    public int setQuestion(int ansLocation){
        this.ansLocation = ansLocation;
        return ansLocation;

    }
    public boolean isTrue(){

        return correct;
    }
    public void setAnswerTrue(boolean answerTrue){
        correct = answerTrue;


    }


}


