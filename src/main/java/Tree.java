
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Tree {

    void addAsLeftChild(Node nodeParent, Node childNode) {
        nodeParent.setLeftNode(childNode);
    }

    void addAsRightChild(Node nodeParent, Node childNode) {
        nodeParent.setRightNode(childNode);
    }

    int countSumInSubTree(Node node) {
        if (node == null) {
            return 0;
        }
        return (node.getValue() + countSumInSubTree(node.getLeftNode()) + countSumInSubTree(node.getRightNode()));
    }

    private int countNumberOfNodesInSubTree(Node node) {
        if (node == null) {
            return 0;
        }
        return (1 + countNumberOfNodesInSubTree(node.getLeftNode()) + countNumberOfNodesInSubTree(node.getRightNode()));
    }

    double countAverageValueInSubTree(Node node) {
        if (node == null) {
            return 0;
        }
        return ((double) countSumInSubTree(node) / (double) countNumberOfNodesInSubTree(node));
    }

    double countMedianInSubTree(Node node) {
        if (node == null) {
            return 0;
        }
        List<Integer> list = addValuesFromSubTreeToList(node, new ArrayList<Integer>());
        Collections.sort(list);

        if (list.size() % 2 == 0) {
            return (double)( (list.get(list.size() / 2)) +  (list.get(list.size() / 2 - 1))) /2.0;
        } else
        return list.get(list.size() / 2);
    }

    private List<Integer> addValuesFromSubTreeToList(Node node, ArrayList<Integer> lista) {
        if (node != null) {
            lista.add(node.getValue());
            addValuesFromSubTreeToList(node.getLeftNode(), lista);
            addValuesFromSubTreeToList(node.getRightNode(), lista);
        }
        return lista;
    }
}