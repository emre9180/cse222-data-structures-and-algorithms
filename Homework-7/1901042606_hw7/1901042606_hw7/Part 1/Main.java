public class Main {
	
    /**
     * Takes a binary tree and an array of items as input, and it returns a binary search tree (BST) as output whose structure is the same as Binary Tree
     * @param bst BinarySearchTree that will be output
     * @param root BinaryTree input
     * @param array Array input
     * @param index Current index
     * @param side Indicates what side we go in the Binary Tree
     */
    private static void buildBST(BinarySearchTree bst, BinaryTree root, Comparable [] array,  int index, int side)
    {
        // Base case, if the tree ends, terminate the recursion
        if(root==null)
            return;

        // Going left in the tree
        if(side==1)
        {
            BinaryTree leftRoot = root.getLeftSubtree();
            int tempLeftNum;
            if(leftRoot==null)
                tempLeftNum = index - 1;
            else tempLeftNum = index - (leftRoot.childNumber(leftRoot.root.right) + 1);

            if(tempLeftNum<0 || tempLeftNum>= array.length)
            {
                buildBST(bst, root.getLeftSubtree(), array, tempLeftNum, 2);
                buildBST(bst, root.getLeftSubtree(), array,tempLeftNum,1);
                return;
            }

            bst.add(array[tempLeftNum]);

            buildBST(bst, root.getLeftSubtree(), array, tempLeftNum, 2);
            buildBST(bst, root.getLeftSubtree(), array,tempLeftNum,1);

        }

        // Going right in the tree
        if(side==2)
        {
            BinaryTree rightRoot = root.getRightSubtree();
            int tempLeftNum;

            if(rightRoot==null)
                tempLeftNum = index + 1;
            else tempLeftNum = rightRoot.childNumber(rightRoot.root.left) + index + 1;

            if(tempLeftNum>= array.length)
            {
                buildBST(bst, root.getRightSubtree(), array,tempLeftNum,1);
                buildBST(bst, root.getRightSubtree(), array, tempLeftNum, 2);
                return;
            }


            bst.add(array[tempLeftNum]);
            buildBST(bst, root.getRightSubtree(), array,tempLeftNum,1);
            buildBST(bst, root.getRightSubtree(), array, tempLeftNum, 2);


        }
    }

    /**
     * Takes a binary tree and an array of items as input, and it returns a binary search tree (BST) as output whose structure is the same as Binary Tree
     * @param root Binary Tree input
     * @param array Array input
     * @return  Returns the BST
     */
    public static BinarySearchTree buildBST(BinaryTree root, Comparable[] array)
    {
        // Sort the array, time complexity:
        QuickSort.sort(array);

        // Find left children number
        int leftChildNum = root.childNumber(root.root.left);

        // Create the Binary Search Tree
        BinarySearchTree BST = new BinarySearchTree();

        // Start by adding the root
        BST.add(array[leftChildNum]);

        // Build the BST recursively
        buildBST(BST, root, array, leftChildNum, 1);
        buildBST(BST, root, array, leftChildNum, 2);

        return BST;
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        BinarySearchTree BST = new BinarySearchTree();
        
        tree.root = new BinaryTree.Node<>(3);;
        tree.root.left = new BinaryTree.Node<>(3);;
        tree.root.right = new BinaryTree.Node<>(3);;
        tree.root.right.right = new BinaryTree.Node<>(3);
        tree.root.right.right.right = new BinaryTree.Node<>(3);
        tree.root.right.right.right.left = new BinaryTree.Node<>(3);
        tree.root.right.right.left = new BinaryTree.Node<>(3);
        tree.root.left.left = new BinaryTree.Node<>(3);
        tree.root.left.right = new BinaryTree.Node<>(3);
        tree.root.left.right.left = new BinaryTree.Node<>(3);
        tree.root.left.right.left.right = new BinaryTree.Node<>(3);

        Comparable [] array = {1,2,3,4,5,6,7,8,9,10,11};

        BST = buildBST(tree,array);

        System.out.printf("BINARY TREE:\n\n%s\n\n\n\n",tree.toString()) ;
        System.out.printf("BST:\n\n%s",BST.toString());
        
        
        
        
        
        
        BinaryTree tree2 = new BinaryTree();
        BinarySearchTree BST2 = new BinarySearchTree();
        
        tree2.root = new BinaryTree.Node<>(3);;
        tree2.root.left = new BinaryTree.Node<>(3);;
        tree2.root.right = new BinaryTree.Node<>(3);;
        tree2.root.right.right = new BinaryTree.Node<>(3);
        tree2.root.right.right.right = new BinaryTree.Node<>(3);
        tree2.root.right.right.right.left = new BinaryTree.Node<>(3);

        Comparable [] array2 = {1,2,3,4,5,6};

        BST2 = buildBST(tree2,array2);

        System.out.printf("\n\n\n\nEXAMPLE 2:\nBINARY TREE:\n\n%s\n\n\n\n",tree2.toString()) ;
        System.out.printf("BST:\n\n%s",BST2.toString());
        
        
        
        
        
        
        BinaryTree tree3 = new BinaryTree();
        BinarySearchTree BST3 = new BinarySearchTree();

        Comparable [] array3 = {1,2,3,4,5,6,7,8};
        
        tree3.root = new BinaryTree.Node<>(3);
        tree3.root.right = new BinaryTree.Node<>(3);
        tree3.root.left = new BinaryTree.Node<>(3);
        tree3.root.right.left = new BinaryTree.Node(3);
        tree3.root.right.left.left = new BinaryTree.Node<>(3);
        tree3.root.right.left.left.left = new BinaryTree.Node<>(3);
        tree3.root.left.left = new BinaryTree.Node<>(3);
        tree3.root.left.left.left = new BinaryTree.Node<>(3);

        BST3 = buildBST(tree3,array3);

        System.out.printf("\n\n\n\nEXAMPLE 3:\nBINARY TREE:\n\n%s\n\n\n\n",tree3.toString()) ;
        System.out.printf("BST:\n\n%s",BST3.toString());
        
        
        
        
        
        
        BinaryTree tree4 = new BinaryTree();
        BinarySearchTree BST4 = new BinarySearchTree();

        Comparable [] array4 = {1,2,3,4,5};
        
        tree4.root = new BinaryTree.Node<>(3);
        tree4.root.right = new BinaryTree.Node<>(3);
        tree4.root.left = new BinaryTree.Node<>(3);
        tree4.root.left.left = new BinaryTree.Node<>(3);
        tree4.root.left.left.left = new BinaryTree.Node<>(3);
        
        BST4 = buildBST(tree4,array4);

        System.out.printf("\n\n\n\nEXAMPLE 4:\nBINARY TREE:\n\n%s\n\n\n\n",tree4.toString()) ;
        System.out.printf("BST:\n\n%s",BST4.toString());
        
        
        
        
        
        
        BinaryTree tree5 = new BinaryTree();
        BinarySearchTree BST5 = new BinarySearchTree();

        Comparable [] array5 = {1,2,3,4};
        
        tree5.root = new BinaryTree.Node<>(3);
        tree5.root.left = new BinaryTree.Node(3);
        tree5.root.right = new BinaryTree.Node<>(3);
        tree5.root.right.right = new BinaryTree.Node<>(3);

        BST5 = buildBST(tree5,array5);

        System.out.printf("\n\n\n\nEXAMPLE 5:\nBINARY TREE:\n\n%s\n\n\n\n",tree5.toString()) ;
        System.out.printf("BST:\n\n%s",BST5.toString());
        
        
        
        
        
        
        
        
        
        BinaryTree tree6 = new BinaryTree();
        BinarySearchTree BST6 = new BinarySearchTree();

        Comparable [] array6 = {1,2,3,4};
        
        tree6.root = new BinaryTree.Node<>(3);
        tree6.root.left = new BinaryTree.Node<>(3);
        tree6.root.left.left = new BinaryTree.Node(3);
        tree6.root.left.left.right = new BinaryTree.Node<>(3);

        BST6 = buildBST(tree6,array6);

        System.out.printf("\n\n\n\nEXAMPLE 6:\nBINARY TREE:\n\n%s\n\n\n\n",tree6.toString()) ;
        System.out.printf("BST:\n\n%s",BST6.toString());
        
        
        
        
        
        
        
    }
}
