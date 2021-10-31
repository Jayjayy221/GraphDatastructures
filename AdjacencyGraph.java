package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;

public class AdjacencyGraph {

    ArrayList<Vertex> vertices; //creates list
    public AdjacencyGraph() {
        vertices = new ArrayList<Vertex>();
    } // method

    public void addVertex(Vertex v) {
        vertices.add(v);
    } //adds

    public void addEdge(Vertex from, Vertex to, Integer dist) { //Adds point of no return
        if (!(vertices.contains(from) && vertices.contains(to))) {
            System.out.println(" Vertex not in graph");
            return;
        }
        Edge e = new Edge(from, to, dist);
        Edge e2 = new Edge(to, from, dist);

    }
    public void MSTPrims() {
        MinHeap<Vertex> Q = new MinHeap<>();
        for (int i = 0; i < vertices.size(); i++) { // Vertices options created
            vertices.get(i).dist = Integer.MAX_VALUE;
            vertices.get(i).prev = null;
            Q.Insert(vertices.get(i));
        }
        if (vertices.size() > 0) { // min decrease and update position
            vertices.get(0).dist = 0;
            //q.update;
            int pos = Q.getPosition(vertices.get(0));
            Q.decreasekey(pos);
        }
        int MST = 0;
        while (!Q.isEmpty()) {
            Vertex u = Q.extractMin(); //compare and extraction of min
            for (int v = 0; v < u.OutEdges.size(); v++) {
                if (u.OutEdges.get(v).weight < u.OutEdges.get(v).to.dist) {
                    u.OutEdges.get(v).to.dist = u.OutEdges.get(v).weight;
                    u.OutEdges.get(v).to.prev = u;
                    int pos = Q.getPosition(u.OutEdges.get(v).to);
                    Q.decreasekey(pos);
                }
            }
            MST += u.dist; // Updating MST
        }
        System.out.println("Minimum spanning tree Distance: " + MST);
        for(int i=1; i< vertices.size();i++) // From and to min
    {
        System.out.println(" From "+ vertices.get(i).prev.name + " to " + vertices.get(i).name + " distance: " + vertices.get(i).dist);
    }
        System.out.println(" ");
        int total_price = MST * 100000;
        NumberFormat myFormat = NumberFormat.getInstance();
        System.out.println("The total price is: " + myFormat.format(total_price) + " DKK");
    }
}

class Vertex implements Comparable<Vertex>{ //Vertex implements Compare (minheap)
    String name;
    ArrayList<Edge> OutEdges;
    Integer dist= Integer.MAX_VALUE;
    Vertex prev = null;
    public Vertex(String id){
        name=id;
        OutEdges=new ArrayList<Edge>();
    }

    public void addOutEdge(Edge e) {
        OutEdges.add(e);
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.dist<o.dist)
            return -1;
        if (this.dist>o.dist)
            return 1;
        return 0;
    }
}
class Edge{
    Integer weight;
    Vertex from;
    Vertex to;
    public Edge(Vertex from, Vertex to, Integer cost){
        this.from=from;
        this.to=to;
        this.weight=cost;
        this.from.addOutEdge(this);
    }
}
