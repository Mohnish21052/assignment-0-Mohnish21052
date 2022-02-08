package com.example.assi1;

public class Questions {
    public int question_number;
    public String question_to_ask;

    public Questions(int qno) {
    question_number=qno;
    }
    public String get_question() {
        if(question_number==1)
        {
            question_to_ask="1)Do you have fever?";
        }
        else if(question_number==2)
            question_to_ask="2)Do you have sore throat?";
        else if(question_number==3)
            question_to_ask="3)Do you have running nose?";
        else if(question_number==4)
            question_to_ask="4)Is there any loss of taste or smell?";
        else if(question_number==5)
            question_to_ask="5)Are you having Aches and Pains?";
        else
            question_to_ask="6)Is there any difficulty is breathing?";

        return  question_to_ask;
    }
}
