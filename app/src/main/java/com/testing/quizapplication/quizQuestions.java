package com.testing.quizapplication;

public class quizQuestions{
    private int ansLocation;
    private boolean correct;
    private String userInput;
    private boolean isText;
    public quizQuestions (int questionId,boolean correct){

        this.ansLocation = questionId;
        this.correct = correct;
        this.isText = false;
    }
    public quizQuestions (int questionId, String userInput){

        this.userInput = userInput;
        this.ansLocation = questionId;
        this.isText = true;

    }
    public int getAnsLocation(){

        return ansLocation;
    }
    public int setQuestion(){
        return ansLocation;

    }
    public String check(){

        return userInput;
    }
    public boolean isText(){
        return isText;

    }
    public boolean isTrue(){

        return correct;
    }



}


