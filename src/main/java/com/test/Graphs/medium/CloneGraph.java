package com.test.Graphs.medium;
import java.util.*;

public class CloneGraph {

    public static HashMap<Integer, Node> map = new HashMap<>();

    public static Node cloneGraph(Node node) {
        return clone(node);
    }

    public static Node clone(Node node) {
        if (node == null) return null;

        if (map.containsKey(node.val))
            return map.get(node.val);

        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(newNode.val, newNode);

        for (Node neighbor : node.neighbors)
            newNode.neighbors.add(clone(neighbor));

        return newNode;
    }

    public static void main(String[] args) {
        List<Node> adjList = createGraph();
        Node clonedGraph = cloneGraph(adjList.getFirst());

        printGraph(clonedGraph);
    }

    // Create the example graph
    public static List<Node> createGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        List<Node> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);

        return nodes;
    }

    public static void printGraph(Node node) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        dfsPrint(node, visited);
    }

    private static void dfsPrint(Node node, HashMap<Integer, Boolean> visited) {
        if (node == null || visited.containsKey(node.val)) {
            return;
        }

        visited.put(node.val, true);
        System.out.print("Node " + node.val + " neighbors: ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        for (Node neighbor : node.neighbors) {
            dfsPrint(neighbor, visited);
        }
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
