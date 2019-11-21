package test;

import implementation.controller.Test;
import implementation.models.QuestionNumeric;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.QuestionException;
import interfaces.exceptions.TestException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class incorrectAnswerPecentageTest {
    Test t1 = new Test();

    @org.junit.jupiter.api.Test
    void incorrectAnswerPercentageTest1() { /*Teste para garantir que o metodo retorna a percentagem de questões respondidas incorretamente no teste*/
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        q1.setCorrect_answer("Yes");
        q1.setUser_answer("Yes");
        q1.setDone(true);
        QuestionNumeric q2 = new QuestionNumeric("Q2", "Que nota vou ter a ES2?");
        q2.setCorrect_anwser(10);
        q2.setUser_answer(20);
        q2.setDone(true);
        try {
            t1.addQuestion(q1);
            t1.addQuestion(q2);
        } catch (TestException e) {
            e.printStackTrace();
        }
        assertEquals(0.5, t1.getTestStatistics().incorrectAnswerPecentage());
    }

    @org.junit.jupiter.api.Test
    void incorrectAnswerPercentageTest2() { /*Teste para garantir que o metodo lança uma exepção quando existem perguntas que não estão respondidas no teste*/
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        q1.setCorrect_answer("Yes");
        q1.setUser_answer("Yes");
        q1.setDone(true);
        QuestionNumeric q2 = new QuestionNumeric("Q2", "Que nota vou ter a ES2?");
        q2.setCorrect_anwser(10);
        q2.setUser_answer(20);
        try {
            t1.addQuestion(q1);
            t1.addQuestion(q2);
        } catch (TestException e) {
            e.printStackTrace();
        }
        assertThrows(QuestionException.class, () -> {
            t1.getTestStatistics().incorrectAnswerPecentage();
        });
    }

}

