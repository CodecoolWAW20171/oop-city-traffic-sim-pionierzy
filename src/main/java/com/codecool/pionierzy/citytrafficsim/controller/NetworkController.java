package com.codecool.pionierzy.citytrafficsim.controller;

import com.codecool.pionierzy.citytrafficsim.model.city.CityNetwork;
import com.codecool.pionierzy.citytrafficsim.model.city.Edge;
import com.codecool.pionierzy.citytrafficsim.model.city.Vertex;
import com.codecool.pionierzy.citytrafficsim.model.lights.LightsNetwork;
import com.codecool.pionierzy.citytrafficsim.view.city.NetworkDisplay;
import javafx.scene.layout.Pane;

import java.io.*;
import java.util.Scanner;

public class NetworkController {

    private CityNetwork network;
    private NetworkDisplay networkDisplay;

    void loadSampleNetwork(Pane container) {
        network = loadMap(getClass().getResource("/sample.txt").getFile());
        System.out.println(network);
        System.out.println(network.getConnections());

        // Setup display
        networkDisplay = new NetworkDisplay(network);
        networkDisplay.createDisplay();
        container.getChildren().add(networkDisplay);
    }


    /**
     * Loads map from a simple file in form:
     * V (int) number of vertices
     * E (int) number of edges
     * 0 x y (double) x, y are coordinates of vertex no 0
     * 1 x y
     * ...
     *  blank line
     * v w (int) edge connecting vertices v and w
     * ...
     * @param fileName location of file with a map.
     * @return CityNetwork object with created network
     */
    CityNetwork loadMap(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int V = Integer.parseInt(br.readLine());
            int E = Integer.parseInt(br.readLine());

            CityNetwork network = new CityNetwork(V);
            loadVertices(br, network, V);
            br.readLine();  // empty line in file (separator)
            loadEdges(br, network, E);

            return network;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File was not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid file format.");
        }
        return null;
    }

    private void loadVertices(BufferedReader reader, CityNetwork network, int V) throws IOException {
        for (int v = 0; v < V; v++) {
            String[] line = reader.readLine().split(" ");
            int no = Integer.parseInt(line[0]);
            // Verification if vertices are numbered correctly
            if (no != v) {
                throw new NumberFormatException();
            }
            double x = Double.parseDouble(line[1]);
            double y = Double.parseDouble(line[2]);

            network.addVertex(new Vertex(v, x, y));
        }
    }

    private void loadEdges(BufferedReader reader, CityNetwork network, int E) throws IOException {
        for (int e = 0; e < E; e++) {
            String[] line = reader.readLine().split(" ");
            int v = Integer.parseInt(line[0]);
            int w = Integer.parseInt(line[1]);

            network.addEdge(new Edge(network.getVertex(v), network.getVertex(w)));
        }

    }
}
