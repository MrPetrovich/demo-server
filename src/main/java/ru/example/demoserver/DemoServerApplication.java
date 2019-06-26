package ru.example.demoserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.example.demoserver.view.View;

@SpringBootApplication
public class DemoServerApplication {
    public static void main(String[] args) {

        View view = new View();
        view.start();

    }
}

