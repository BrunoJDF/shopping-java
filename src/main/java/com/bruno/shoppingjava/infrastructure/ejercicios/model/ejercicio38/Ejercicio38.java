package com.bruno.shoppingjava.infrastructure.ejercicios.model.ejercicio38;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class Ejercicio38 {
    private final Logger logger = LoggerFactory.getLogger(Ejercicio38.class);

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String path = "src/main/resources/winners.csv";
        Ejercicio38 ejercicio38 = new Ejercicio38();
        ejercicio38.chooseWinners(path);
    }

    void chooseWinners(String location) {
        List<Winner> winners = this.readCSV(location);
        List<Winner> filteredWinners = this.getTopWinners(winners);

        filteredWinners.forEach(winner -> logger.info("Winner: {}", winner.getEmail()));
    }

    private List<Winner> getTopWinners(List<Winner> winners) {
        String statusInactive = "inactivo";
        int top = 3;
        List<Winner> listActive = winners.stream()
                .filter(winner -> !winner.getStatus().equalsIgnoreCase(statusInactive))
                .toList();
        return this.getRandomWinners(listActive, top);
    }

    private List<Winner> getRandomWinners(List<Winner> listActive, int top) {
        IntStream distincted = RandomGenerator.getDefault().ints(0, listActive.size())
                .distinct();
        return distincted
                .limit(top)
                .mapToObj(value -> {
                    logger.info("Random value: {}", value);
                    return listActive.get(value);
                })
                .toList();
    }

    private List<Winner> readCSV(String location) {
        List<Winner> winners = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(location))) {
            boolean isFirstLine = true;
            while (br.ready()) {
                String line = br.readLine();
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split("\\|");
                var obj = Winner.builder()
                        .id(values[0])
                        .email(values[1])
                        .status(values[2])
                        .build();
                winners.add(obj);
            }

        } catch (IOException e) {
            logger.error("Error reading file", e);
        }
        return winners;
    }

}
