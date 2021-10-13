package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MatrixGraph myGraph = new MatrixGraph(7);
        myGraph.addEdge(1, 1, 1);
        myGraph.addEdge(0, 2, 5);
        myGraph.addEdge(0,4, 3);
        myGraph.addEdge(1, 4, 1);
        myGraph.addEdge(1,5,7);
        myGraph.addEdge(2,3,1);
        myGraph.addEdge(3, 4,1);
        myGraph.addEdge(3,6,1);
        myGraph.addEdge(4,2,1);
        myGraph.addEdge(4,3,3);
        myGraph.addEdge(4,5,3);
        myGraph.addEdge(4,6,4);
        myGraph.addEdge(5,6,1);
        myGraph.printGraph();

// we make the graph
        AdjacencyListGraph adjgraph = new AdjacencyListGraph();
        Vertex A = new Vertex("Eskildstrup");
        adjgraph.addVertex(A);
        Vertex B = new Vertex("Haslev");
        adjgraph.addVertex(B);
        Vertex C = new Vertex("Holbæk");
        adjgraph.addVertex(C);
        Vertex D = new Vertex("Jærgerspris");
        adjgraph.addVertex(D);
        Vertex E = new Vertex("Kalundborg");
        adjgraph.addVertex(E);
        Vertex F = new Vertex("Korsør");
        adjgraph.addVertex(F);
        Vertex G = new Vertex("Køge");
        adjgraph.addVertex(G);
        Vertex H = new Vertex("Maribo");
        adjgraph.addVertex(H);
        Vertex I = new Vertex("Nakskov");
        adjgraph.addVertex(I);
        Vertex J = new Vertex("Nykøbing F");
        adjgraph.addVertex(J);
        Vertex K = new Vertex("Næstved");
        adjgraph.addVertex(K);
        Vertex L = new Vertex("Ringsted");
        adjgraph.addVertex(L);
        Vertex M = new Vertex("Roskilde");
        adjgraph.addVertex(M);
        Vertex N = new Vertex("Slagelse");
        adjgraph.addVertex(N);
        Vertex O = new Vertex("Sorø");
        adjgraph.addVertex(O);
        Vertex P = new Vertex("Vordingborg");
        adjgraph.addVertex(P);

        adjgraph.newEdge(A, H, 28);
        adjgraph.newEdge(A, J, 13);
        adjgraph.newEdge(A, P, 25);

        adjgraph.newEdge(B, F, 60);
        adjgraph.newEdge(B, G, 24);
        adjgraph.newEdge(B, K, 25);
        adjgraph.newEdge(B, L, 19);
        adjgraph.newEdge(B, M, 47);
        adjgraph.newEdge(B, N, 48);
        adjgraph.newEdge(B, O, 34);
        adjgraph.newEdge(B, P, 40);

        adjgraph.newEdge(C, D, 34);
        adjgraph.newEdge(C, E, 44);
        adjgraph.newEdge(C, F, 66);
        adjgraph.newEdge(C, L, 36);
        adjgraph.newEdge(C, M, 32);
        adjgraph.newEdge(C, N, 46);
        adjgraph.newEdge(C, O, 34);

        adjgraph.newEdge(D, F,94);
        adjgraph.newEdge(D, G,58);
        adjgraph.newEdge(D, L,56);
        adjgraph.newEdge(D, M,33);
        adjgraph.newEdge(D, N,74);
        adjgraph.newEdge(D, O,63);

        adjgraph.newEdge(E, L, 62);
        adjgraph.newEdge(E, M, 70);
        adjgraph.newEdge(E, N, 39);
        adjgraph.newEdge(E, O, 51);

        adjgraph.newEdge(F, G, 1);
        adjgraph.printGraph();

        myGraph.PrismNST();


    }
}
