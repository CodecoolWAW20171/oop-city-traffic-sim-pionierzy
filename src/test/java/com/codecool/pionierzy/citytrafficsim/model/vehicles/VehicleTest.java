package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void move() {
        NetworkNode node1 = new NetworkNode();
        NetworkNode node2 = new NetworkNode();
        Edge road = new Edge(node1, node2);
        Car car = new Car(road);
        for (int i = 0; i < 5; i++) {
            car.accelerate();
        }
        car.move();
        Assertions.assertEquals( Car.CAR_ACCELERATION * 5, car.getDistanceTravelled());
    }
}