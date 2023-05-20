public class T8Q3 {
    public static void main(String[]args){
        Graph<Character> graph = new Graph<>();
        for(char c = 'A' ; c<= 'I' ; c++){
            graph.addVertex(c);
        }
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'D');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'E');
        graph.addEdge('C', 'F');
        graph.addEdge('D', 'E');
        graph.addEdge('E', 'G');
        graph.addEdge('F', 'H');
        graph.addEdge('G', 'H');
        graph.addEdge('H', 'I');
        // Adjacency list is used.

        graph.showGraph();
    }
}

class Graph<T extends Comparable<T>>{
    private Vertex<T> head;
    private int size;

    private static class Vertex<T extends Comparable<T>>{
        T vertexInfo;
        Vertex<T> nextVertex;
        Edge<T> firstEdge; // Edge that starts from this vertex

        public Vertex(){
            this(null,null);
        }

        public Vertex(T vInfo, Vertex<T> next){
            vertexInfo = vInfo;
            nextVertex = next;
            firstEdge = null;
        }
    }

    private static class Edge<T extends Comparable<T>>{
        Vertex<T> toVertex; // Vertex that this edge points to
        Edge<T> nextEdge; // Next edge that starts from the same vertex

            public Edge(){
                this(null,null);
            }

            public Edge(Vertex<T> to, Edge<T> next){
                toVertex = to;
                nextEdge = next;
            }
    }

    public boolean addVertex(T vInfo){
        if(head == null){
            head = new Vertex<>(vInfo,null);
            size++;
            return true;
        }
        Vertex<T> v = head;
        while(v.nextVertex != null){
            if(v.vertexInfo.compareTo(vInfo) == 0){
                return false;
            }
            v = v.nextVertex;
        }
        if(v.vertexInfo.compareTo(vInfo) == 0){
            return false;
        }
        v.nextVertex = new Vertex<>(vInfo,null);
        size++;
        return true;
    }

    public boolean addEdge(T from, T to){
        Vertex<T> fromVertex = head;
        Vertex<T> toVertex = head;
        while(fromVertex != null){
            if(fromVertex.vertexInfo.compareTo(from) == 0){
                break;
            }
            fromVertex = fromVertex.nextVertex;
        }
        while(toVertex != null){
            if(toVertex.vertexInfo.compareTo(to) == 0){
                break;
            }
            toVertex = toVertex.nextVertex;
        }
        if(fromVertex == null || toVertex == null){
            return false;
        }
        Edge<T> e = fromVertex.firstEdge;
        while(e != null){
            if(e.toVertex.vertexInfo.compareTo(to) == 0){
                return false;
            }
            e = e.nextEdge;
        }
        fromVertex.firstEdge = new Edge<>(toVertex,fromVertex.firstEdge);
        return true;
    }

    public void showGraph(){
        Vertex<T> v = head;
        while(v != null){
            System.out.print(v.vertexInfo + " -> ");
            Edge<T> e = v.firstEdge;
            while(e != null){
                System.out.print(e.toVertex.vertexInfo + " -> ");
                e = e.nextEdge;
            }
            System.out.println();
            v = v.nextVertex;
        }
    }
}
