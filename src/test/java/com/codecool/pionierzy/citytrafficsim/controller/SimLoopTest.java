package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Car;
import com.codecool.pionierzy.citytrafficsim.view.city.NetworkDisplay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimLoopTest {

    NetworkDisplay networkDisplay = new NetworkDisplay();
    SimLoop simTest;
    NetworkNode networkNode1 = new NetworkNode(100,50);
    NetworkNode networkNode2 = new NetworkNode(150, 50);
    Edge edge = new Edge(networkNode1, networkNode2);

    @BeforeEach
    void setupLoop() {
        this.simTest = new SimLoop(networkDisplay);
    }

    @Test
    void addToVehicleList() {
        assertEquals(0, this.simTest.getVehicleList().size());

        Car testCar = new Car(this.edge);
        simTest.addToVehicleList(testCar);
        assertEquals(1, this.simTest.getVehicleList().size());
    }

    @Test
    void removeVehicleFromList(){
        Car testCar1 = new Car(this.edge);
        this.simTest.addToVehicleList(testCar1);
        Car testCar2 = new Car(this.edge);
        this.simTest.addToVehicleList(testCar2);
        assertEquals(2, simTest.getVehicleList().size());

        this.simTest.removeVehicleFromList(testCar1);
        assertEquals(1, simTest.getVehicleList().size());
    }
}