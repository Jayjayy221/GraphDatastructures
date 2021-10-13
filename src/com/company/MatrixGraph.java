package com.company;

public class MatrixGraph {
    int[][] matrixedgegraph; // list that contains the edges
    int[][] matrixweightgraph; // we pressume everything in our graph is int

    MatrixGraph(int vertices) {
        matrixedgegraph = new int[vertices][vertices];
        matrixweightgraph = new int[vertices][vertices];
    }

    public void addEdge(int from, int to, int weight) {
        matrixedgegraph[from][to] = 1; // how we add an edge
        matrixweightgraph[from][to] = weight;
    }

    // method to print graph
    public void printGraph() {
        for (int fromi = 0; fromi < matrixedgegraph.length; fromi++) {
            System.out.println("Edge from vertex " + fromi);

            for (int toj = 0; toj < matrixedgegraph.length; toj++) {
                if (matrixedgegraph[fromi][toj] == 1) {
                    System.out.println(" To " + toj);
                    System.out.println(" weight " + matrixweightgraph[fromi][toj]);
                }
            }
            System.out.println(" ");
        }
    }

    public void PrismNST() {
        int[] D = new int[matrixedgegraph.length];
        int[] P = new int[matrixedgegraph.length];
        MyHeap<Pair> Q = new MyHeap<>();
        Pair[] VertexPairs = new Pair[matrixedgegraph.length];
        for (int i = 0; i < matrixedgegraph.length; i++) {
            D[i] = Integer.MAX_VALUE;
            P[i] = -1;
            Pair newPair = new Pair(D[i], i);
            Q.insert(newPair);
            VertexPairs[i] = newPair;
        }
        if (D.length > 0)
            D[0] = 0;
        int pos = Q.getPosition(VertexPairs[0]);
        VertexPairs[0].distance = 0;
        Q.decreasekey(pos);
        int MST = 0;
        while (!Q.isEmpty()) {
            Pair u = Q.extractMin();
            for (int v = 0; v < matrixedgegraph.length; v++) {
                if (matrixedgegraph[u.index][v] == 1 && matrixweightgraph[u.index][v] < D[v]) {
                    D[v] = matrixweightgraph[u.index][v];
                    P[v] = u.index;
                    pos = Q.getPosition(VertexPairs[v]);
                    VertexPairs[v].distance = D[v];
                    Q.decreasekey(pos);
                }
            }
            MST += D[u.index];
            System.out.println("Edge: " + P[u.index] + ", " + u.index + "Weight " + D[u.index]);
        }
        System.out.println("MST size " + MST);
    }
}

class Pair implements Comparable<Pair>{
    Integer distance;
    Integer index;

    public Pair(int distance, int index){
        this.distance=distance;
        this.index=index;
    }

    @Override
    public int compareTo(Pair o) {
        return distance.compareTo(o.distance);
    }
}