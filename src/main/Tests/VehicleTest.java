import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.NetworkNode;
import com.codecool.pionierzy.citytrafficsim.model.vehicles.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;

public class VehicleTest {

    @Test
    public void testMove() {
        NetworkNode node1 = new NetworkNode();
        NetworkNode node2 = new NetworkNode();
        Edge road = new Edge(node1, node2);
        Car car = new Car(road);
        for (int i = 0; i < 5; i++) {
            car.accelerate();
        }
        car.Move();
        Assertions.assertEquals( Car.CAR_ACCELERATION * 5, car.getDistanceTravelled());
    }

    @Test
    public void testRandomDirection() {
        NetworkNode node1 = new NetworkNode();
        NetworkNode node2 = new NetworkNode();
        Edge road = new Edge(node1, node2);
        Car car = new Car(road);
        HashSet <NetworkNode> neighbours = node2.getNeighbours();
        int size = neighbours.size();
        int item = new Random().nextInt(size);
        int i = 0;
        NetworkNode node;
        for (NetworkNode obj : neighbours) {
            if (i == item) node = obj;
        }
        car.setRndDirection();
        Assertions.assertEquals(node, car.getDestination());

    }
}