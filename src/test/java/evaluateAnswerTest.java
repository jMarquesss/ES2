package test;

import implementation.models.QuestionMultipleChoice;
import implementation.models.QuestionNumeric;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.QuestionException;

import static org.junit.jupiter.api.Assertions.*;

public class evaluateAnswerTest {

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo lança uma exepção quando a resposta do user e nula*/
    void evaluateAnswerQuestionMultipleChoice1() {
        String[] dif = {"Easy", "Hard"};
        QuestionMultipleChoice q1 = new QuestionMultipleChoice("Q1", "Que dificldade tem ES2?", dif, "Easy");
        q1.setUser_answer(null);
        assertThrows(QuestionException.class, () -> {
            q1.evaluateAnswer();
        });
    }

    @org.junit.jupiter.api.Test
    void evaluateAnswerQuestionMultipleChoice2() { /*Teste para garantir que o metodo retorna true quandoa  respotas do user esta correta*/
        String[] dif = {"Easy", "Hard"};
        QuestionMultipleChoice q1 = new QuestionMultipleChoice("Q1", "Que dificldade tem ES2?", dif, "Easy");
        q1.setUser_answer("Easy");
        assertTrue(q1.evaluateAnswer());
    }

    @org.junit.jupiter.api.Test
    void evaluateAnswerQuestionMultipleChoice3() { /*Teste para garantir que o metodo retorna false quando a resposta do user esta errada*/
        String[] dif = {"Easy", "Hard"};
        QuestionMultipleChoice q1 = new QuestionMultipleChoice("Q1", "Que dificldade tem ES2?", dif, "Easy");
        q1.setUser_answer("Hrad");
        assertFalse(q1.evaluateAnswer());
    }

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo lança uma exepção quando a resposta do user e nula*/
    void evaluateAnswerQuestionYesNo1() {
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        q1.setCorrect_answer("Yes");
        q1.setUser_answer(null);
        assertThrows(QuestionException.class, () -> {
            q1.evaluateAnswer();
        });
    }

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo retorna true quando a resposta do user esta correta*/
    void evaluateAnswerQuestionYesNo2() {
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        q1.setCorrect_answer("Yes");
        q1.setUser_answer("Yes");
        assertTrue(q1.evaluateAnswer());
    }

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo retorna false quando a resposta do user esta errada*/
    void evaluateAnswerQuestionYesNo3() {
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        q1.setCorrect_answer("Yes");
        q1.setUser_answer("NO");
        assertFalse(q1.evaluateAnswer());
    }


    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo lança uma exepção quando a resposta do user e nula*/
    void evaluateAnswerQuestionNumeric1() {
        QuestionNumeric q1 = new QuestionNumeric("Q1", "Que nota vou ter a ES2?");
        q1.setCorrect_anwser(10);
        q1.setUser_answer(Double.parseDouble(null));
        assertThrows(QuestionException.class, () -> {
            q1.evaluateAnswer();
        });
    }

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo retorna true quando a resposta do user esta correta*/
    void evaluateAnswerQuestionNumeric2() {
        QuestionNumeric q1 = new QuestionNumeric("Q1", "Que nota vou ter a ES2?");
        q1.setCorrect_anwser(10);
        q1.setUser_answer(10);
        assertTrue(q1.evaluateAnswer());
    }

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo retorna false quando a resposta do user esta errada*/
    void evaluateAnswerQuestionNumeric3() {
        QuestionNumeric q1 = new QuestionNumeric("Q1", "Que nota vou ter a ES2?");
        q1.setCorrect_anwser(10);
        q1.setUser_answer(20);
        assertFalse(q1.evaluateAnswer());
    }

}
