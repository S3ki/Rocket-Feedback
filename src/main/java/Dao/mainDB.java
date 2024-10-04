package Dao;

import Entity.Opettaja;

public class mainDB {
    public static void main(String[] args) {

        OpettajaDao opDao = new OpettajaDao();

        opDao.persist(new Opettaja("Matti", "Meikäläinen", "Mati@meikäläinen.com"));

        Opettaja op2 = opDao.find(2);
        System.out.println(op2.getFirstName() + " " + op2.getLastName());

        op2.setFirstName("Maija");
        opDao.update(op2);
    }
}
