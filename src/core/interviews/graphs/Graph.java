package interviews.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Graph representation.
 * @author Francois Rousseau
 */
public class Graph {
  public final int V;
  protected int E;
  protected List<Edge>[] adjacencyLists;
  protected Set<Edge> edges;

  @SuppressWarnings("unchecked")
  public Graph(int V) {
    this.V = V;
    this.adjacencyLists = (List<Edge>[]) new List[V];
    for (int v = 0; v < V; v++) {
      adjacencyLists[v] = new ArrayList<Edge>();
    }
    this.edges = new HashSet<Edge>(V);
  }

  /**
   * Add an edge between vertex v and vertex w (directed from v to w if it is a directed graph).
   * Create the vertices if not already present in the graph.
   */
  public boolean addEdge(int v, int w) {
    boolean ret = false;
    ret |= addEdge(new Edge(v, w));
    ret |= addEdge(new Edge(w, v));
    if(ret) {
      E++;  // we only want to increment it once for undirected edge
    }
    return ret;
  }

  /**
   * Adjacent vertices of v.
   */
  public Iterable<Integer> adjacents(int v) {
    List<Integer> adjacents = new ArrayList<Integer>();
    for(Edge edge: adjacencyLists[v]) {
      adjacents.add(edge.w);
    }
    return adjacents;
  }

  /**
   * Number of edges.
   */
  public int E() {
    return E;
  }

  /**
   * Return all the edges from this graph.
   */
  public Iterable<Edge> edges() {
    return edges;
  }

  /**
   * String representation by adjacency lists.
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for(int v = 0; v < V; v++) {
      builder.append(v + " -> [");
      for(int w: adjacents(v)) {
        builder.append(w + ", ");
      }
      builder.delete(builder.length() - 2, builder.length());
      builder.append("]\n");
    }
    return builder.toString();
  }

  /**
   * Add a (directed) edge between vertex v and vertex w.
   * Create the vertices if not already present in the graph.
   */
  protected boolean addEdge(Edge edge) {
    edges.add(edge);
    for(Edge e: adjacencyLists[edge.v]) {
      if(e.equals(edge)) {
        return false;
      }
    }
    return adjacencyLists[edge.v].add(edge);
  }
}
