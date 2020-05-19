import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final int V;
    private final List<List<Integer>> adj;

    public Graph(int V) {
        // V is number of apex
        this.V = V;
        adj = new ArrayList<List<Integer>>();
        // init src, des in edge
        for (int i = 0; i < V; i ++) {
            adj.add(new LinkedList<Integer>());
        }
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    /**
     * isCyclic
     * @return true if the graph contain a cycle,
     * else false
     */
    private boolean isCyclic() {
        // mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++) {
            if(isCyclicUtils(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private  boolean isCyclicUtils(int i, boolean[] visited, boolean[] recStack) {
        // mark the current node as visted and
        // part of recursion stack
        System.out.println(String.format("i is %s", i));
        System.out.println(String.format("Visited %s", Arrays.toString(visited)));
        System.out.println(String.format("recStack is %s", Arrays.toString(recStack)));
        if (recStack[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }
        visited[i] = true;
        recStack[i] = true;
        // for in recursion stack
        // get recusor stack
        List<Integer> rec = this.adj.get(i);
        for (int edge : rec) {
            if (isCyclicUtils(edge, visited, recStack)) {
                return true;
            }
        }
        // diem xuat phat ko co cycle, reset recStack is false
        recStack[i] = false;
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        if (graph.isCyclic()) {
            System.out.println("Graph had cycle");
        } else {
            System.out.println("Graph no had cycle");
        }
    }
}

