package ru.itsjava;

import ru.itsjava.service.ServerService;
import ru.itsjava.service.ServerServiceImpl;

public class Application {


    public static void main(String[] args){
        ServerService serverService = new ServerServiceImpl();
        serverService.start();
    }
}
