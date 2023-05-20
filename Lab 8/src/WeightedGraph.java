import java.util.ArrayList;

public class WeightedGraph<T extends Comparable<T>,N extends Comparable<N>> {
    private Vertex<T, N> head;
    private int size;

    private static class Vertex<T extends Comparable<T>, N extends Comparable<N>> {
        T vertexInfo;
        int inDegree;
        int outDegree;
        Vertex<T, N> nextVertex;
        Edge<T, N> firstEdge; // head of the edge list

        public Vertex() {
            this(null, null);
        }

        public Vertex(T vInfo, Vertex<T, N> next) {
            vertexInfo = vInfo;
            nextVertex = next;
            inDegree = 0;
            outDegree = 0;
            firstEdge = null;
        }
    }

    private static class Edge<T extends Comparable<T>, N extends Comparable<N>> {
        Vertex<T, N> toVertex;
        Edge<T, N> nextEdge; // link to next edge
        N weight;

        public Edge() {
            this(null, null, null);
        }

        public Edge(Vertex<T, N> destination, N weight, Edge<T, N> a) {
            toVertex = destination;
            this.weight = weight;
            nextEdge = a;
        }
    }

    public WeightedGraph() {
        head = null;
        size = 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getIndeg(T vertex) {
        Vertex<T, N> temp = head;
        while (temp != null) {
            if (temp.vertexInfo.compareTo(vertex) == 0) {
                return temp.inDegree;
            }
            temp = temp.nextVertex;
        }
        return -1;
    }

    public int getOutdeg(T vertex) {
        Vertex<T, N> temp = head;
        while (temp != null) {
            if (temp.vertexInfo.compareTo(vertex) == 0) {
                return temp.outDegree;
            }
            temp = temp.nextVertex;
        }
        return -1;
    }

    public boolean hasVertex(T vertex) {
        Vertex<T, N> temp = head;
        while (temp != null) {
            if (temp.vertexInfo.compareTo(vertex) == 0) {
                return true;
            }
            temp = temp.nextVertex;
        }
        return false;
    }

    public boolean addVertex(T vertex) {
        if (hasVertex(vertex)) {
            return false;
        }
        Vertex<T, N> temp = head;
        Vertex<T, N> newVertex = new Vertex<T, N>(vertex, null);
        if (temp == null) {
            head = newVertex;
        } else {
            while (temp.nextVertex != null) {
                temp = temp.nextVertex;
            }
            temp.nextVertex = newVertex;
        }
        size++;
        return true;
    }

    public int getIndex(T vertex) {
        Vertex<T, N> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.vertexInfo.compareTo(vertex) == 0) {
                return index;
            }
            temp = temp.nextVertex;
            index++;
        }
        return -1;
    }

    public ArrayList<T> getAllVertexObjects() {
        ArrayList<T> list = new ArrayList<>();
        Vertex<T, N> temp = head;
        while (temp != null) {
            list.add(temp.vertexInfo);
            temp = temp.nextVertex;
        }
        return list;
    }

    public ArrayList<Vertex<T, N>> getAllVertices() {
        ArrayList<Vertex<T, N>> list = new ArrayList<>();
        Vertex<T, N> temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.nextVertex;
        }
        return list;
    }

    public boolean addEdge(T source, T destination, N weight) {
        if (head == null) {
            return false;
        }
        if (!hasVertex(source) || !hasVertex(destination)) {
            return false;
        }
        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                Vertex<T, N> destinationVertex = head;
                while (destinationVertex != null) {
                    if (destinationVertex.vertexInfo.compareTo(destination) == 0) {
                        //Reached destination vertex, add edge here
                        Edge<T, N> currentEdge = sourceVertex.firstEdge;
                        Edge<T, N> newEdge = new Edge<T, N>(destinationVertex, weight, currentEdge);
                        sourceVertex.firstEdge = newEdge;
                        sourceVertex.outDegree++;
                        destinationVertex.inDegree++;
                        return true;
                    }
                    destinationVertex = destinationVertex.nextVertex;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    public boolean addUndirectedEdge(T source, T destination, N weight) {
        if (!hasVertex(source) || !hasVertex(destination)) {
            return false;
        }

        for (Vertex<T, N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                for (Vertex<T, N> destinationVertex = head; destinationVertex != null; destinationVertex = destinationVertex.nextVertex) {
                    if (destinationVertex.vertexInfo.compareTo(destination) == 0) {
                        sourceVertex.firstEdge = new Edge<T, N>(destinationVertex, weight, sourceVertex.firstEdge);
                        destinationVertex.firstEdge = new Edge<T, N>(sourceVertex, weight, destinationVertex.firstEdge);
                        sourceVertex.outDegree++;
                        sourceVertex.inDegree++;
                        destinationVertex.outDegree++;
                        destinationVertex.inDegree++;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasEdge(T source, T destination) {
        if (!hasVertex(source) || !hasVertex(destination)) {
            return false;
        }
        for (Vertex<T, N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                for (Edge<T, N> currentEdge = sourceVertex.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeEdge(T source, T destination) {
        if (!hasEdge(source, destination)) return false;

        for (Vertex<T, N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex)
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                if (sourceVertex.firstEdge.toVertex.vertexInfo.compareTo(destination) == 0)
                    sourceVertex.firstEdge = sourceVertex.firstEdge.nextEdge;
                else
                    for (Edge<T, N> currentEdge = sourceVertex.firstEdge; currentEdge.nextEdge != null; currentEdge = currentEdge.nextEdge)
                        if (currentEdge.nextEdge.toVertex.vertexInfo.compareTo(destination) == 0)
                            currentEdge.nextEdge = currentEdge.nextEdge.nextEdge;
                return true;
            }
        return false;
    }

    public N getEdgeWeight(T source, T destination) {
        if (!hasVertex(source) || !hasVertex(destination)) return null;

        for (Vertex<T, N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex)
            if (sourceVertex.vertexInfo.compareTo(source) == 0)
                for (Edge<T, N> currentEdge = sourceVertex.firstEdge; currentEdge != null; currentEdge=currentEdge.nextEdge)
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0)
                        return currentEdge.weight;
        return null;
    }

    public ArrayList<T> getNeighbours(T v) {
        if (!hasVertex(v)) return null;

        ArrayList<T> list = new ArrayList<>();
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex)
            if (current.vertexInfo.compareTo(v) == 0)
                for (Edge<T, N> currentEdge = current.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge)
                    list.add(currentEdge.toVertex.vertexInfo);
        return list;
    }

    public void printEdges() {
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            System.out.printf("# %s : ", current.vertexInfo);
            for (Edge<T, N> currentEdge = current.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge)
                System.out.printf("[%s,%s] ", current.vertexInfo, currentEdge.toVertex.vertexInfo);
            System.out.println();
        }
    }
}
