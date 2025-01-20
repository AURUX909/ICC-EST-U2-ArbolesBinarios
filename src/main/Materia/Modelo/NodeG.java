    package main.Materia.Modelo;

    import java.util.LinkedList;
    import java.util.List;

    public class NodeG {
        private final int value;
        private final List<NodeG> neighbors;

        public NodeG(int value) {
            this.value = value;
            this.neighbors = new LinkedList<>();
        }

        public int getValue() {
            return value;
        }

        public List<NodeG> getNeighbors() {
            return neighbors;
        }

        public void addNeighbor(NodeG neighbor) {
            neighbors.add(neighbor);
        }
    }