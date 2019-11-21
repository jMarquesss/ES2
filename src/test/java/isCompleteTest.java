package test;

import implementation.controller.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class isCompleteTest {

    Test t1 = new Test();

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo retorna true quando todas as perguntas do teste estão done*/
    void isComplete1() {
        t1.loadFromJSONFile("data/teste_A.json");
        t1.getQuestion(0).setDone(true);
        t1.getQuestion(1).setDone(true);
        t1.getQuestion(2).setDone(true);
        t1.getQuestion(3).setDone(true);
        assertTrue(t1.isComplete());
    }

    @org.junit.jupiter.api.Test /*Teste para garantir que o metodo retorna false quando existem questões que não estão done*/
    void isComplete2() {
        t1.loadFromJSONFile("data/teste_A.json");
        t1.getQuestion(0).setDone(true);
        assertFalse(t1.isComplete());
    }


}