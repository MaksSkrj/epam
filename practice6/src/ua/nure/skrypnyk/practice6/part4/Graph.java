package ua.nure.skrypnyk.practice6.part4;

public class Graph {
    private boolean[][] matrx;

    public Graph(int vertexes) {
        matrx = new boolean[vertexes][vertexes];
    }

    public boolean addEdge(int vertex1, int vertex2) {
        if (vertex1 - 1 > matrx.length || vertex2 - 1 > matrx.length)
            return false;
        matrx[vertex1 - 1][vertex2 - 1] = true;
        matrx[vertex2 - 1][vertex1 - 1] = true;
        return true;
    }

    public boolean removeEdge(int vertex1, int vertex2) {
        if (vertex1 - 1 > matrx.length || vertex2 - 1 > matrx.length)
            return false;
        if (!matrx[vertex1 - 1][vertex2 - 1])
            return false;
        matrx[vertex1 - 1][vertex2 - 1] = false;
        matrx[vertex2 - 1][vertex1 - 1] = false;
        return true;
    }

    public void printEdges() {
        System.out.println("EDGES: ");
        for (int i = 0; i < matrx.length; i++) {
            for (int j = i; j < matrx.length; j++) {
                if (matrx[i][j]){
                    System.out.print("{"+(i + 1)+"} -- {"+(j + 1)+"}");
                System.out.println();}
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < matrx.length; j++) {
            result.append("vertex ").append(j + 1).append(" has edges with vertexes:");
            for (int i = 0; i < matrx.length; i++) {
                if (matrx[i][j])
                    result.append(" {").append(i + 1).append("}");
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

}
