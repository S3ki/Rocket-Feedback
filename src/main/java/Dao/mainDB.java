package Dao;

import Entity.Opettaja;

public class mainDB {
    public static void main(String[] args) {

        OpettajaDao opDao = new OpettajaDao();


        Opettaja op2 = opDao.find(2);
        System.out.println(op2.getFirstName() + " " + op2.getLastName());

        op2.setFirstName("Dahl");
        opDao.update(op2);
    }
}
