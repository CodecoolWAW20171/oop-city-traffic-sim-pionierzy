package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.vehicles.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimLoopTest {

    @Test
    void addToVehicleList() {
        SimLoop simTest = new SimLoop();
        assertEquals(0, simTest.getVehicleList().size());

        Car testCar = new Car();
        simTest.addToVehicleList(testCar);
        assertEquals(1, simTest.getVehicleList().size());
    }

    @Test
    void removeVehicleFromList(){
        SimLoop simTest = new SimLoop();
        Car testCar1 = new Car();
        simTest.addToVehicleList(testCar1);
        Car testCar2 = new Car();
        simTest.addToVehicleList(testCar2);
        assertEquals(2, simTest.getVehicleList().size());

        simTest.removeVehicleFromList(testCar1);
        assertEquals(1, simTest.getVehicleList().size());
    }
}