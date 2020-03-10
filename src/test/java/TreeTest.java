import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeTest {
    private static Node node1 = new Node(5);
    private static Node node2 = new Node(3);
    private static Node node3 = new Node(7);
    private static Node node4 = new Node(2);
    private static Node node5 = new Node(1);
    private static Node node6 = new Node(5);
    private static Node node7 = new Node(0);
    private static Node node8 = new Node(2);
    private static Node node9 = new Node(8);
    private static Node node10 = new Node(5);
    private static Tree tree = new Tree();

    @BeforeAll
    static void createTree() {
        tree.addAsRightChild(node1, node3);
        tree.addAsRightChild(node3, node7);
        tree.addAsRightChild(node7, node9);
        tree.addAsRightChild(node9, node10);
        tree.addAsRightChild(node2, node6);
        tree.addAsLeftChild(node1, node2);
        tree.addAsLeftChild(node2, node4);
        tree.addAsLeftChild(node3, node5);
        tree.addAsLeftChild(node7, node8);
    }

    @Test
    void sumInSubTree() {
        assertEquals(0, tree.countSumInSubTree(null));
        assertEquals(2, tree.countSumInSubTree(node4));
        assertEquals(23, tree.countSumInSubTree(node3));
    }

    @Test
    void averageValueInSubTree() {
        assertEquals(0, tree.countAverageValueInSubTree(null));
        assertEquals(3.75, tree.countAverageValueInSubTree(node7));
        assertEquals(3.8, tree.countAverageValueInSubTree(node1));
    }

    @Test
    void medianInSubTree() {
        assertEquals(0, tree.countMedianInSubTree(null));
        assertEquals(3, tree.countMedianInSubTree(node2));
        assertEquals(3.5, tree.countMedianInSubTree(node3));
        assertEquals(4, tree.countMedianInSubTree(node1));
    }


}
