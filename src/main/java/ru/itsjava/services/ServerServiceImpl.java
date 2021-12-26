package ru.itsjava.services;

import lombok.SneakyThrows;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerServiceImpl implements ServerService {
    public final static int PORT = 8081;
    public final List<Observer> observers = new ArrayList<>();


    @SneakyThrows
    @Override
    public void start() {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("== SERVER STARTS ==");
        while (true) {
            Socket socket = serverSocket.accept();
            if (socket != null) {
                Thread thread = new Thread(new ClientRunnable(socket, this));
                thread.start();
            }
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        for (Observer observer : observers) {
            observer.notifyMe(message);
        }
    }

//    3. Реализовать отправку сообщений всем кроме себя
//    1. На сервере добавить метод notifyObserverExceptMe с логикой, где вы рассылаете всем за исключением текущего Observer

    @Override
    public void notifyObserverExceptMe(String message, Observer observer) {
        for (Observer value : observers) {
            if (!observer.equals(value)) {
                value.notifyMe(message);
            }
        }
    }
}
