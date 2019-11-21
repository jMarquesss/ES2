/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package java;

import implementation.controller.Test;
import interfaces.exceptions.TestException;
import views.TestWindow;

/**
 * @author Marques
 */
public class ES2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TestException {
        Test t1 = new Test();
        System.out.println(t1.loadFromJSONFile("data/teste_A.json"));
        TestWindow t = new TestWindow();
        t.startTest(t1);
        /*QuestionYesNo qans = (QuestionYesNo) t1.getQuestion(2);
        QuestionNumeric qans2 = (QuestionNumeric) t1.getQuestion(3);
        System.out.println(qans.getCorrect_answer());
        System.out.println(qans.getUser_answer());
        System.out.println(qans2.getCorrect_anwser());*/

    }

}
