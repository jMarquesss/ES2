package test;

import implementation.controller.Test;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.QuestionException;
import interfaces.exceptions.TestException;

import static org.junit.jupiter.api.Assertions.*;

class addQuestionTest {
    Test t1 = new Test();

    @org.junit.jupiter.api.Test /* Teste para adicionar questão valida*/
    void addQuestion1() throws TestException {
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        assertTrue(t1.addQuestion(q1));
    }

    @org.junit.jupiter.api.Test /* Teste para garantir que rejeita mais questões quando o teste esta cheio*/
    void addQuestion2() throws TestException {
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        for (int i = 0; i < 100; i++) {
            t1.addQuestion(q1);
        }
        assertFalse(t1.addQuestion(q1));
    }

    @org.junit.jupiter.api.Test /* Teste para garantir que lança exepção quando se adiciona uma pergunta nula*/
    void addQuestion3() {
        assertThrows(QuestionException.class, () -> {
            t1.addQuestion(null);
        });
    }


}