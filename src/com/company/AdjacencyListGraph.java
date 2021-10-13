package com.company;

import java.util.ArrayList;

public class AdjacencyListGraph {

    private ArrayList<Vertex> vertices;
    // constructor
    public AdjacencyListGraph() {
        // dont need to define our graph yet
        vertices = new ArrayList<>();
    }
    // we need to be able to add Vertex
    public void addVertex(Vertex v) {
        vertices.add(v);
    }
    // we want to be able to create an edge

    public void newEdge(Vertex from, Vertex to, Integer dist) {
        if( ! (vertices.contains(from) && vertices.contains(to)))
        {
            System.out.println(" Vertex not found" );
            return;
        }
        Edge newedge = new Edge(from, to, dist);
    }
    // prints the graph
    public void printGraph() {
        Vertex currentvt;
        for (int i = 0; i < vertices.size(); i++) {
            currentvt = vertices.get(i);
            System.out.println("Edges from Vertex: " + currentvt.getName());
            for(int j = 0; j < currentvt.getOutEdges().size(); j++) {
                Edge currentve = currentvt.getOutEdges().get(j);

                System.out.println("To " + currentve.getToVertex().getName()+ " weight "+ currentve.getWeight());
            }
            System.out.println(" "); // just to print a line
        }
    }
}
class Vertex implements Comparable<Vertex> {

    private String Name;
    private ArrayList<Edge> outEdges;
    Integer distance = Integer.MAX_VALUE; // so we have the distance to max value possible
    //Vertex prev = null;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Edge> getOutEdges() {
        return outEdges;
    }

    public void setOutEdges(ArrayList<Edge> outEdges) {
        this.outEdges = outEdges;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    // constructor
    public Vertex(String id)
    {
        this.Name = id;
        outEdges = new ArrayList<>();
    }
    public void addOutEdge(Edge outEdge) {
        outEdges.add(outEdge);
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.distance < o.distance)
            return -1;
        if (this.distance > o.distance)
            return 1;
        return 0;
    }

}

class Edge {
    private Vertex fromVertex;
    private Vertex toVertex;

    public Vertex getFromVertex() {
        return fromVertex;
    }
    public void setFromVertex(Vertex fromVertex) {
        this.fromVertex = fromVertex;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public void setToVertex(Vertex toVertex) {
        this.toVertex = toVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    private double weight;
    // constructor
    public Edge(Vertex from, Vertex to, double cost) {
        fromVertex = from;
        toVertex = to;
        weight = cost;

        // new edge
        from.addOutEdge(this);
    }
}