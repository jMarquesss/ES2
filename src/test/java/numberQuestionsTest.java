package test;

import implementation.controller.Test;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.TestException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class numberQuestionsTest {

    Test t1 = new Test();

    @org.junit.jupiter.api.Test /*Teste para garantir que retorna o numero de questões não nullas no teste*/
    void numberQuestions() {
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        try {
            t1.addQuestion(q1);
        } catch (TestException e) {
            e.printStackTrace();
        }
        try {
            t1.addQuestion(null);
        } catch (TestException e) {
            e.printStackTrace();
        }
        assertEquals(1, t1.numberQuestions());
    }
}