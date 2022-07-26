package ru.job4j.weather.reactive.domain;

import java.util.Objects;

/**
 * 3. Мидл
 * 3.4. Spring
 * 3.4.9.1. WebFlux
 * 2. Spring boot Webflux [#328882]
 * Weather модель данных городов и их погоды.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 26.07.2022
 */
public class Weather {
    private int id;
    private String city;
    private int temperature;

    public static Weather of(int id, String city, int temperature) {
        Weather weather = new Weather();
        weather.id = id;
        weather.city = city;
        weather.temperature = temperature;
        return weather;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Weather weather = (Weather) o;
        return id == weather.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Weather{id=" + id + ", city='" + city + '\''
                + ", temperature=" + temperature + '}';
    }
}
