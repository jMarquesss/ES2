package test;

import implementation.controller.Test;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.TestException;

import static org.junit.jupiter.api.Assertions.*;

class removeQuestionTest {

    Test t1 = new Test();

    @org.junit.jupiter.api.Test /* Teste para garantir que retorna false quando questão a remover e null*/
    void removeQuestion1() throws TestException {
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        t1.addQuestion(q1);
        assertFalse(t1.removeQuestion(null));
    }

    @org.junit.jupiter.api.Test /* Teste para garantir que remove a questão na posição indicada, deixa essa posição em null e que retorna true quando o faz*/
    void removeQuestion2() throws TestException {
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        t1.addQuestion(q1);
        assertTrue(t1.removeQuestion(0));
        assertEquals(null, t1.getQuestion(0));
    }
}