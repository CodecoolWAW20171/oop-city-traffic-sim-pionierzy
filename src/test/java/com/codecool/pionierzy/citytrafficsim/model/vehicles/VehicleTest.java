package com.codecool.pionierzy.citytrafficsim.model.vehicles;

import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javafx.scene.layout.Pane;

class VehicleTest {

    Pane pane = new Pane();

    @Test
    void move() {
        NetworkNode node1 = new NetworkNode(5,5);
        NetworkNode node2 = new NetworkNode(100,100);
        Edge road = new Edge(node1, node2, pane);
        Car car = new Car(road);
        for (int i = 0; i < 5; i++) {
            car.accelerate();
        }
        car.move();
        Assertions.assertEquals( Car.CAR_ACCELERATION * 5, car.getDistanceTravelled());
    }
}