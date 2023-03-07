package org.example;

import org.example.controller.AuthController;
import org.example.db.DataBase;
import org.example.db.InitDataBase;

public class Main {

    public static void main(String[] args) {
        DataBase.initTable();
//        new DataBase().getMe();

        InitDataBase.adminInit();
        InitDataBase.addCompanyCard();

        AuthController authController = new AuthController();
        authController.start();

    }
}
