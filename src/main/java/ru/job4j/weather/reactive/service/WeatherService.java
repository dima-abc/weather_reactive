package ru.job4j.weather.reactive.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.job4j.weather.reactive.domain.Weather;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 3. Мидл
 * 3.4. Spring
 * 3.4.9.1. WebFlux
 * 2. Spring boot Webflux [#328882]
 * WeatherService сервис по обработке модели данных в Flux и Mono
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 26.07.2022
 */
@Service
public class WeatherService {
    private final Map<Integer, Weather> weathers = new ConcurrentHashMap<>();

    {
        weathers.put(1, Weather.of(1, "Msc", 20));
        weathers.put(2, Weather.of(2, "Spb", 15));
        weathers.put(3, Weather.of(3, "Bryansk", 15));
        weathers.put(4, Weather.of(4, "Smolensk", 10));
        weathers.put(5, Weather.of(5, "Kiev", 33));
        weathers.put(6, Weather.of(6, "Minsk", 17));
    }

    /**
     * Метод возвращает города по ID
     * @param id Integer
     * @return Mono
     */
    public Mono<Weather> findById(Integer id) {
        return Mono.justOrEmpty(weathers.get(id));
    }

    /**
     * Метод возвращает все города
     *
     * @return Flux
     */
    public Flux<Weather> all() {
        return Flux.fromIterable(weathers.values());
    }

    /**
     * Метод, который вернет город с максимальной температурой.
     *
     * @return Mono
     */
    public Mono<Weather> getHottest() {
        return Mono.justOrEmpty(weathers.values()
                .stream()
                .max(Comparator
                        .comparingInt(Weather::getTemperature)));
    }

    /**
     * Метод, который вернет города с температурой выше указанной
     *
     * @param temperature Integer
     * @return Flux
     */
    public Flux<Weather> getCityGreatThen(Integer temperature) {
        return Flux.fromStream(weathers.values()
                .stream()
                .filter(w -> w.getTemperature() > temperature));
    }
}
