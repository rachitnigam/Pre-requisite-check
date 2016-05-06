package graphs;

import java.util.*;

/**
 * Implementation of a graph. Uses an ArrayList as an adjacency matrix
 */
public class Graph<V> {

    protected ArrayList<V> vertices;
    protected IntegerNode[] edges;

    public Graph(int maxV) {
        vertices = new ArrayList<V>(maxV);
        edges = new IntegerNode[maxV];
    }

    public Graph(){
        this(100);
    }

    public int getNumVertices() {
        return vertices.size();
    }

    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    public void addVertex(V vertex) {
        vertices.add(vertex);
    }

    protected int indexOf(V vertex) {
        return vertices.indexOf(vertex);
    }

    public boolean hasVertex(V vertex) {
        return vertices.contains(vertex);
    }

    public List<V> getVertices() {
        return new ArrayList<V>(vertices);
    }

    public Iterator<V> vertexIterator() {
        return vertices.iterator();
    }

    protected int getIndexOf(V vertex) {
        int result = vertices.indexOf(vertex);
        if (result < 0) {
            throw new GraphException("Vertex not in graph: " + vertex);
        }
        return result;
    }

    public List<V> getNeighbors(V from) {
        int fromIndex = getIndexOf(from);
        List<V> neighbors = new ArrayList<V>();
        for (int i = 0; i < vertices.size(); i += 1)
        {
            if (hasEdge(fromIndex, i)) {
                neighbors.add(vertices.get(i));
            } }
        return neighbors;
    }

    public boolean hasEdge(V from, V to) {
        return hasEdge(getIndexOf(from),
                getIndexOf(to));
    }

    protected boolean hasEdge(int fromIndex, int toIndex) {
        for (IntegerNode node = edges[fromIndex]; node != null; node = node.getNext()) {
            if (node.getData() == toIndex) {
                return true;
            }
        }
        return false;
    }

    public void addEdge(V from, V to) {
        int fromIndex = getIndexOf(from);
        int toIndex = getIndexOf(to);
        edges[fromIndex] = new IntegerNode(toIndex, edges[fromIndex]);
    }


    @Override
    public String toString(){
        Queue<V> stringGen = new LinkedList<V>();
        HashSet<V> visited = new HashSet<>();
        StringBuilder retString = new StringBuilder("digraph { \n");

        stringGen.addAll(vertices);

        V parent;
        String parentString, childString;


        while(!stringGen.isEmpty()){
            parent = stringGen.remove();
            parentString = parent.toString();

            for(V iter : this.getNeighbors(parent)){
                if(visited.contains(iter))
                    continue;

                stringGen.add(iter);
                retString.append(parentString  + " -> " + iter.toString()+ ";\n");
                visited.add(iter);
            }
        }

        retString.append("}");
        return retString.toString();
    }
}
