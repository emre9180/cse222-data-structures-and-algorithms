import java.util.Random;

public class Main {

    public static void main(String[] args) {

    Random rand = new Random();

    long sumQuick = 0,sumMerge = 0,sumNew = 0;

    /* ************************************** NEW_SORT ALGORITHM TEST ***************************************************** */

    System.out.printf("Firstly, let's show that the New Sort algorithm runs successfuly:\n\n");
    int ct = 0;
    Integer [] testArray = new Integer[7];
    System.out.printf("The array, before sorting:\n");
    for(int i=0;i<7;++i)
    {
        testArray[i] = Math.abs(rand.nextInt() % 20);
        System.out.printf("%d ",testArray[i]);
    }
        System.out.println();
    newSort.sort(testArray);
    System.out.printf("\nThe array, after sorting:\n");
    for(int i=0;i<7;i++)
        System.out.printf("%d ",testArray[i]);



        System.out.printf("\n\nAnother example:\n\n");
        ct = 0;
        testArray = new Integer[7];
        System.out.printf("The array, before sorting:\n");
        for(int i=0;i<7;++i)
        {
            testArray[i] = rand.nextInt() % 20;
            System.out.printf("%d ",testArray[i]);
        }
        newSort.sort(testArray);
        System.out.printf("\n\nThe array, after sorting:\n");
        for(int i=0;i<7;i++)
            System.out.printf("%d ",testArray[i]);

        /* ************************************** NEW_SORT ALGORITHM TEST ***************************************************** */

        /* ************************************** RUN-TIME TESTING STARTS ***************************************************** */


    System.out.printf("\n\n******************** Testing 100-size arrays sorting ********************");
    for(int i=0;i<1000;i++)
    {
        /* Create random array */
        Integer [] arr = new Integer[100];
        for(int j=0;j<100;j++)
            arr[j] = rand.nextInt() % 100;

        /* Measure MergeSort */
        long start = System.currentTimeMillis(); // Start the clock to measure run-time
        MergeSort.sort(arr);
        long end = System.currentTimeMillis(); // Start the clock to measure run-time

        sumMerge += end-start;

        /* Create random array */
        arr = new Integer[100];
        for(int j=0;j<100;j++)
            arr[j] = rand.nextInt() % 100;

        /* Measure Quick Sort */
        start = System.currentTimeMillis(); // Start the clock to measure run-time
        QuickSort.sort(arr);
        end = System.currentTimeMillis(); // Start the clock to measure run-time

        sumQuick += end-start;

        /* Creating random array */
        arr = new Integer[100];
        for(int j=0;j<100;j++)
            arr[j] = rand.nextInt() % 100;

        /* Measuring newSort */
        start = System.currentTimeMillis(); // Start the clock to measure run-time
        newSort.sort(arr);
        end = System.currentTimeMillis(); // Start the clock to measure run-time

        sumNew += end-start;
    }

    System.out.printf("\n\nQuick -> %f\nMerge -> %f\nNew -> %f\n\n",sumQuick/1000.0, sumMerge/1000.0, sumNew/1000.0);










        sumQuick = 0;
        sumMerge = 0;
        sumNew = 0;
        System.out.printf("******************** Testing 1000-size arrays sorting ********************");
        for(int i=0;i<1000;i++)
        {
            /* Create random array */
            Integer [] arr = new Integer[1000];
            for(int j=0;j<1000;j++)
                arr[j] = rand.nextInt() % 1000;

            /* Measure MergeSort */
            long start = System.currentTimeMillis(); // Start the clock to measure run-time
            MergeSort.sort(arr);
            long end = System.currentTimeMillis(); // Start the clock to measure run-time

            sumMerge += end-start;

            /* Create random array */
            arr = new Integer[1000];
            for(int j=0;j<1000;j++)
                arr[j] = rand.nextInt() % 1000;

            /* Measure Quick Sort */
            start = System.currentTimeMillis(); // Start the clock to measure run-time
            QuickSort.sort(arr);
            end = System.currentTimeMillis(); // Start the clock to measure run-time

            sumQuick += end-start;

            /* Creating random array */
            arr = new Integer[1000];
            for(int j=0;j<1000;j++)
                arr[j] = rand.nextInt() % 1000;

            /* Measuring newSort */
            start = System.currentTimeMillis(); // Start the clock to measure run-time
            newSort.sort(arr);
            end = System.currentTimeMillis(); // Start the clock to measure run-time

            sumNew += end-start;
        }

        System.out.printf("\n\nQuick -> %f\nMerge -> %f\nNew -> %f\n\n",sumQuick/1000.0, sumMerge/1000.0, sumNew/1000.0);










        System.out.printf("******************** Testing 10000-size arrays sorting ********************");
        sumQuick = 0;
        sumMerge = 0;
        sumNew = 0;
        for(int i=0;i<1000;i++)
        {
            /* Create random array */
            Integer [] arr = new Integer[10000];
            for(int j=0;j<10000;j++)
                arr[j] = rand.nextInt() % 10000;

            /* Measure MergeSort */
            long start = System.currentTimeMillis(); // Start the clock to measure run-time
            MergeSort.sort(arr);
            long end = System.currentTimeMillis(); // Start the clock to measure run-time

            sumMerge += end-start;

            /* Create random array */
            arr = new Integer[10000];
            for(int j=0;j<10000;j++)
                arr[j] = rand.nextInt() % 10000;

            /* Measure Quick Sort */
            start = System.currentTimeMillis(); // Start the clock to measure run-time
            QuickSort.sort(arr);
            end = System.currentTimeMillis(); // Start the clock to measure run-time

            sumQuick += end-start;

            /* Creating random array */
            arr = new Integer[10000];
            for(int j=0;j<10000;j++)
                arr[j] = rand.nextInt() % 10000;

            /* Measuring newSort */
            start = System.currentTimeMillis(); // Start the clock to measure run-time
            newSort.sort(arr);
            end = System.currentTimeMillis(); // Start the clock to measure run-time

            sumNew += end-start;
        }

        System.out.printf("\n\nQuick -> %f\nMerge -> %f\nNew -> %f\n\n",sumQuick/1000.0, sumMerge/1000.0, sumNew/1000.0);

    }
















}
