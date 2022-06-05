import java.util.Random;

public class Main {



    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        Random rand = new Random();

        for(int i=0;i<70;i++)
        {
            int num = rand.nextInt(100);
            bst.add(num);
        }
        System.out.printf("Unmodified:\n\n%s\n\n\n",bst);

        AVLTree newTree = bst.rotation(bst);
        System.out.printf("Modified:\n\n%s",newTree.toString());
    }
}
