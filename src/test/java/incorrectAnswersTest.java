package test;

import implementation.controller.Test;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.TestException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class incorrectAnswersTest {
    Test t1 = new Test();

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo retorna o numero de questões respondidas incorretamente no teste*/
    void incorrectAnswer1() {
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        q1.setCorrect_answer("Sim");
        try {
            t1.addQuestion(q1);
        } catch (TestException e) {
            e.printStackTrace();
        }
        t1.getQuestion(0).answer("Nao");
        assertEquals(1, t1.getTestStatistics().incorrectAnswers().length);
    }

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo retorna o numero de questões respondidas incorretamente no teste*/
    void incorrectAnswer2() {
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        q1.setCorrect_answer("Sim");
        try {
            t1.addQuestion(q1);
        } catch (TestException e) {
            e.printStackTrace();
        }
        t1.getQuestion(0).answer(q1.getCorrect_answer());
        assertEquals(0, t1.getTestStatistics().incorrectAnswers().length);
    }
}
