package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Garage {
    private final Map<Car, LocalDate> cars;
    private int capacity;

    public Garage(int capacity) {
        cars = new HashMap<>();
        this.capacity = capacity;
    }

    public boolean isFull() {
        return cars.size() == capacity;
    }

    public void addCar(Car car) {
        addCar(car, LocalDate.now());
    }

    public void addCar(Car car, LocalDate date) {
        if (isFull()) {
            throw new IllegalArgumentException("The garage is full. Cannot add more cars.");
        }

        cars.put(car, date);
    }

    public void removeCar(Car car) {
        if (!cars.containsKey(car)) {
            throw new IllegalArgumentException("Car not found in the garage.");
        }

        cars.remove(car);
    }

    public void setCapacity(int newCapacity) {
        if (newCapacity < cars.size()) {
            throw new IllegalArgumentException("New capacity is less than the current number of cars.");
        }
        capacity = newCapacity;
    }

    public int getAvailableSpots() {
        return capacity - cars.size();
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars.keySet());
    }

    public Map<Car, LocalDate> getCars() {
        return cars;
    }

}
