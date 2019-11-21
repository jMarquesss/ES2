import implementation.models.QuestionMultipleChoice;
import implementation.models.QuestionNumeric;
import implementation.models.QuestionYesNo;
import interfaces.exceptions.QuestionException;

import static org.junit.jupiter.api.Assertions.*;

public class answerTest {

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo lança exepção quando user insere um caracter não numerico numa pergunta numerica*/
    void answerQuestionNumericTest1() {
        QuestionNumeric q1 = new QuestionNumeric("Q1", "Que nota vou ter a ES2?");
        assertThrows(QuestionException.class, () -> {
            q1.answer("ola");
        });
    }

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo atribui a user_answer à variável de instância e define o tempo de fim de resposta*/
    void answerQuestionNumericTest2() {
        QuestionNumeric q1 = new QuestionNumeric("Q1", "Que nota vou ter a ES2?");
        Double nota = Double.valueOf(20);
        q1.answer(String.valueOf(nota));
        assertEquals(nota, q1.getUser_answer());
        assertNotEquals(0, q1.getQuestion_metadata().getTimestamp_finish());
    }

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo atribui a user_answer à variável de instância e define o tempo de fim de resposta*/
    void answerQuestionYesNoTest1() {
        QuestionYesNo q1 = new QuestionYesNo("Q1", "ES2 e top?");
        q1.answer("Yes");
        assertEquals("Yes", q1.getUser_answer());
        assertNotEquals(0, q1.getQuestion_metadata().getTimestamp_finish());
    }

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo atribui a user_answer à variável de instância e define o tempo de fim de resposta*/
    void answerQuestionMultipleChoiceTest1() {
        String[] dif = {"Easy", "Hard"};
        QuestionMultipleChoice q1 = new QuestionMultipleChoice("Q1", "Que dificldade tem ES2?", dif, "Easy");
        q1.answer("Easy");
        assertEquals("Easy", q1.getUser_answer());
        assertNotEquals(0, q1.getQuestion_metadata().getTimestamp_finish());
    }

}
