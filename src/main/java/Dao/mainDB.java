package Dao;

import Entity.Feedback;
import Entity.Opettaja;
import Entity.Kurssi;

public class mainDB {
    public static void main(String[] args) {

//        OpettajaDao opDao = new OpettajaDao();
//
//
//        Opettaja op2 = opDao.find(2);
//        System.out.println(op2.getFirstName() + " " + op2.getLastName());
//
//        op2.setFirstName("Dahl");
//        opDao.update(op2);

//        KurssiDao kurssi = new KurssiDao();
//
//        Kurssi kur1 = new Kurssi("EN", "Math");
//        kurssi.delete(1);

        FeedbackDao feedDao = new FeedbackDao();

        Feedback feedback = new Feedback("Amazing course", "EN");
        feedDao.delete(3);
    }

}
