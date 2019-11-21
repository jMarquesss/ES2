package test;

import implementation.controller.Test;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.TestException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class correctAnswerTest {

    Test t1 = new Test();

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo retorna o numero de questões respondidas corretamente no teste*/
    void correctAnswer1() {
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        q1.setCorrect_answer("Sim");
        try {
            t1.addQuestion(q1);
        } catch (TestException e) {
            e.printStackTrace();
        }
        t1.getQuestion(0).answer("Nao");
        assertEquals(0, t1.getTestStatistics().correctAnswers().length);
    }

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo retorna o numero de questões respondidas corretamente no teste*/
    void correctAnswer2() {
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        q1.setCorrect_answer("Sim");
        try {
            t1.addQuestion(q1);
        } catch (TestException e) {
            e.printStackTrace();
        }
        t1.getQuestion(0).answer(q1.getCorrect_answer());
        assertEquals(1, t1.getTestStatistics().correctAnswers().length);
    }
}