import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Main {

    /**
     * Test class
     */
    public static class test
    {
        /**
         * Key data
         */
        public int key;

        /**
         * Data. Does not matter what it is
         */
        public int value;

        /**
         * Constructor
         * @param key Key
         * @param value Data
         */
        test(int key, int value)
        {
            this.key = key;
            this.value = value;
        }

        /**
         * Constructor
         * @param key data
         */
        test(int key)
        {
            this.key = key;
            this.value = key;
        }


        /**
         * To string
         * @return Prints the object's key
         */
        public String toString()
        {
            return String.format("%d",key);
        }
    }

    /**
     * Generatares a unique random number array.
     * WARNING -> IT IS NEVER USED!
     * @param size Array size
     * @return Returns the random array
     */
    static test [] randomGenerator(int size)
    {
        // TODO Auto-generated method stub
        Random myRandom = new Random();
        test[] numbers = new test[size];
        boolean[] check = new boolean[size];
        int amountFilled = 0;
        int trial;
        while (amountFilled < size) {
            trial = myRandom.nextInt(size);
            if (!check[trial]) {
                check[trial] = true;
                numbers[amountFilled] = new test(trial);
                amountFilled++;
            }
        }
        return numbers;
    }


    public static void main(String[] args) throws FileNotFoundException {

        Random rand = new Random();
        int i;

        /* ******************************************************  TESTING THE PDF  ****************************************************** */
        /* ******************************************************  THE INITIAL TABLE SIZE SHOULD BE 10  ****************************************************** */
        /*System.out.printf("Testing the example in the PDF:\n\n");
        HashCoal obj = new HashCoal<>();

        // Creates the objects that will be put in the Hash Table
        test prb = new test(3,3);
        test prb2 = new test(12,12);
        test prb3 = new test(13,13);
        test prb4 = new test(25,25);
        test prb5 = new test(23,23);
        test prb6 = new test(51,51);


        // Putting process
        obj.put(prb.key, prb);
        System.out.printf("\nAfter adding 3 ->\n%s",obj);
        obj.put(prb2.key, prb2);
        System.out.printf("\nAfter adding 12 ->\n%s",obj);
        obj.put(prb3.key, prb3);
        System.out.printf("\nAfter adding 13 ->\n%s",obj);
        obj.put(prb4.key, prb4);
        System.out.printf("\nAfter adding 25 ->\n%s",obj);
        obj.put(prb5.key, prb5);
        System.out.printf("\nAfter adding 23 ->\n%s",obj);
        obj.put(prb6.key, prb6);
        System.out.printf("\nAfter adding 51 ->\n%s",obj);
        obj.remove(prb4.key);
        System.out.printf("\nAfter removing 24 ->\n%s",obj);
        obj.remove(prb3.key);
        System.out.printf("\nAfter removing 13 ->\n%s",obj);

        /* ******************************************************  TESTING THE PDF  ****************************************************** */


        /* ******************************************************  Calculating Run-Time  ****************************************************** */



        // Calculating Run-time 100 size array PUT function

        System.out.printf("\nTesting put function with 100-size array:\n");
        long sum = 0; /* Time sum */

        /* Hash Table */
        HashCoal hashTable = new HashCoal<>();

        /* Run 100 times */
        for(i=0;i<100;i++)
        {
            hashTable = new HashCoal<>();

            test [] ObjArray = new test[100];
            ObjArray = randomGenerator(100);

            long start = System.currentTimeMillis(); // Start the clock to measure run-time
            for(int j=0;j<100;j++)
            {
                int randomNumber = Math.abs(rand.nextInt()%2000);
                ObjArray[j] = new test(randomNumber);
            }

            for(int j=0;j<100;j++)
            {
                hashTable.put(ObjArray[j].key, ObjArray[j].value);
            }

            long end = System.currentTimeMillis();
            sum += end-start;
        }
        System.out.println("100-size array Putting proces: the run-time is: "+sum/100.0);
	System.out.printf("\nAfter first adding proccess: ->\n%s",hashTable);



        // Calculating Run-time 100 size array GET function
        System.out.printf("\nTesting get function with 100-size array:\n ");

        sum = 0; /* Time sum */

        /* Run 100 times */
        for(i=0;i<100;i++)
        {
            long start = System.currentTimeMillis(); // Start the clock to measure run-time

            for(int j=0;j<50000;j++)
            {
                hashTable.get(j);
            }
            long end = System.currentTimeMillis();
            sum += end-start;
        }

        System.out.println("100-size array Getting process: the run-time is: "+sum/100.0);




        // Calculating Run-time 100 size array Remove function
        System.out.printf("\nTesting remove function with 100-size array:\n");

        sum = 0; /* Time sum */

        /* Run 100 times */
        for(i=0;i<100;i++)
        {
            long start = System.currentTimeMillis(); // Start the clock to measure run-time

            for(int j=0;j<50000;j++)
            {
                hashTable.remove(j);
            }
            long end = System.currentTimeMillis();
            sum += end-start;
            break;
        }

        System.out.println("100-size array Removing process: the run-time is: "+sum/100.0);






        // Calculating Run-time 1000 size array PUT function
        System.out.printf("\nTesting put function with 1000-size array:\n");
        sum = 0; /* Time sum */

        /* Hash Table */
        hashTable = new HashCoal<>();

        /* Run 100 times */
        for(i=0;i<100;i++)
        {
            hashTable = new HashCoal<>();

            test [] ObjArray = new test[1000];
            ObjArray = randomGenerator(1000);

            long start = System.currentTimeMillis(); // Start the clock to measure run-time
            for(int j=0;j<1000;j++)
            {
                int randomNumber = Math.abs(rand.nextInt()%50000);
                ObjArray[j] = new test(randomNumber);
            }

            for(int j=0;j<1000;j++)
            {
                hashTable.put(ObjArray[j].key, ObjArray[j].value);
            }

            long end = System.currentTimeMillis();
            sum += end-start;
        }
        System.out.println("1000-size array Putting proces: the run-time is: "+sum/100.0);




        // Calculating Run-time 1000 size array GET function
        System.out.printf("\nTesting get function with 1000-size array:\n ");

        sum = 0; /* Time sum */

        /* Run 100 times */
        for(i=0;i<100;i++)
        {
            long start = System.currentTimeMillis(); // Start the clock to measure run-time

            for(int j=0;j<50000;j++)
            {
                hashTable.get(j);
            }
            long end = System.currentTimeMillis();
            sum += end-start;
        }

        System.out.println("1000-size array Getting process: the run-time is: "+sum/100.0);




        // Calculating Run-time 1000 size array Remove function
        System.out.printf("\nTesting remove function with 1000-size array:\n");

        sum = 0; /* Time sum */

        /* Run 100 times */
        for(i=0;i<100;i++)
        {
            long start = System.currentTimeMillis(); // Start the clock to measure run-time

            for(int j=0;j<50000;j++)
            {
                hashTable.remove(j);
            }
            long end = System.currentTimeMillis();
            sum += end-start;
            break;
        }

        System.out.println("1000-size array Removing process: the run-time is: "+sum/100.0);












        // Calculating Run-time 10000 size array PUT function
        System.out.printf("\nTesting put function with 10000-size array:\n");
        sum = 0; /* Time sum */

        /* Hash Table */
        hashTable = new HashCoal<>();

        /* Run 100 times */
        for(i=0;i<100;i++)
        {
            hashTable = new HashCoal<>();

            test [] ObjArray = new test[10000];
            ObjArray = randomGenerator(10000);

            long start = System.currentTimeMillis(); // Start the clock to measure run-time
            for(int j=0;j<10000;j++)
            {
                int randomNumber = Math.abs(rand.nextInt()%50000);
                ObjArray[j] = new test(randomNumber);
            }

            for(int j=0;j<10000;j++)
            {
                hashTable.put(ObjArray[j].key, ObjArray[j].value);
            }

            long end = System.currentTimeMillis();
            sum += end-start;
        }
        System.out.println("10000-size array Putting proces: the run-time is: "+sum/100.0);




        // Calculating Run-time 10000 size array GET function
        System.out.printf("\nTesting get function with 10000-size array:\n ");

        sum = 0; /* Time sum */

        /* Run 100 times */
        for(i=0;i<100;i++)
        {
            long start = System.currentTimeMillis(); // Start the clock to measure run-time

            for(int j=0;j<50000;j++)
            {
                hashTable.get(j);
            }
            long end = System.currentTimeMillis();
            sum += end-start;
        }

        System.out.println("10000-size array Getting process: the run-time is: "+sum/100.0);




        // Calculating Run-time 10000 size array Remove function
        System.out.printf("\nTesting remove function with 10000-size array:\n");

        sum = 0; /* Time sum */

        /* Run 100 times */
        for(i=0;i<100;i++)
        {
            long start = System.currentTimeMillis(); // Start the clock to measure run-time

            for(int j=0;j<50000;j++)
            {
                hashTable.remove(j);
            }
            long end = System.currentTimeMillis();
            sum += end-start;
            break;
        }

        System.out.println("10000-size array Removing process: the run-time is: "+sum/100.0);








    }
}
