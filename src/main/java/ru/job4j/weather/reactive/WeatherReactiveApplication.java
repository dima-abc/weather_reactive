package ru.job4j.weather.reactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherReactiveApplication {
    public static final Logger LOG = LoggerFactory.getLogger(WeatherReactiveApplication.class.getSimpleName());

    public static void main(String[] args) {
        SpringApplication.run(WeatherReactiveApplication.class, args);
        LOG.info("{}Go to /all, /hottest, /get/{id}, /cityGreatThen/{temperature}", System.lineSeparator());
    }
}
