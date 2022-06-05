/**
 * New Sort Algorithm
 */
public class newSort {

    /**
     * Main function of newSort algorithm. Calls the private sort function
     * @param table Array
     * @param <T> Type
     */
    public static < T extends Comparable < T >> void sort(T[] table)
    {
        new_sort(table,0,table.length-1);
    }

    /* Main max-min finder. It calls the recursive function to find max and min term */
    private static < T extends Comparable < T >> int[] getMinMax(T[] table, int head, int tail)
    {
        /* Initiliaze the max and min terms */
        int [] minMax = new int[2];
        minMax[0] = head;
        minMax[1] = tail;

        return findMaxMinRecursively(table,head,tail,minMax);
    }

    /* Finds and returns max and min terms between head and tail  */
    private static < T extends Comparable < T >> int[] findMaxMinRecursively(T[] table, int head, int tail, int [] maxMin)
    {
        if(head>tail) return maxMin;

        if(table[head].compareTo(table[maxMin[0]])>0)
            maxMin[0]=head; // max

        if(table[head].compareTo(table[maxMin[1]])<0)
            maxMin[1]=head; // min

        return findMaxMinRecursively(table,head+1,tail,maxMin);

    }

    /**
     * This function swaps the items without changing the Max and Min term to protect correctness
     * @param table Array
     * @param i Head or Tail
     * @param j Max or Min
     * @param maxMin Max Min array
     * @param <T> Type
     */
    private static < T extends Comparable < T >> void swap(T[] table, int i, int j, int []maxMin)
    {

        T temp = table[i];

        /* If max and min term have to be changed, do it */
        if(i==maxMin[0])
            maxMin[0] = j;
        if(i==maxMin[1])
            maxMin[1] = j;

        table[i] = table[j];
        table[j] = temp;
    }

    /**
     * Main function of the algorithm. It is the same as the Pseudo Code in the PDF
     * @param table Array
     * @param head Head indice
     * @param tail Tail indice
     * @param <T> Type
     * @return Return the ordered array
     */
    private static < T extends Comparable < T >> T[] new_sort(T[] table, int head, int tail)
    {
        if(head>tail)
            return table;

        else
        {
            int [] minMax = getMinMax(table,head,tail);

            swap(table,head,minMax[1],minMax); // min
            swap(table,tail,minMax[0],minMax); // max

            return new_sort(table,head+1, tail-1);
        }
    }

}
