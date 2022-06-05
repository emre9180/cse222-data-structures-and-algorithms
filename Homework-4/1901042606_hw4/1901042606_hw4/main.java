public class main {



    public static void main(String[] args) {
    	System.out.printf("***********************************TESTING FIRST TASK***********************************\n\n\n");
        // Looking for a word in the Big String's middle of somewhere and the occurence number is smaller than target occurance
        String bigStr = new String("GtuBilMuhEmreCSE102Emre");
        String smallStr = new String("Emre");
        int target = 1;
        int ocr = lib.occuranceFind(bigStr, smallStr, target);
        System.out.printf("The big string: %s\nThe target string: %s\nTarget occurance: %d\nThe i'th occurance: %d"
        ,bigStr, smallStr, target,ocr );

        // Looking for a word in the Big String's end and the occurence number is equals to target occurance
        target = 2;
        ocr = lib.occuranceFind(bigStr, smallStr, target);
        System.out.printf("\n\nThe big string: %s\nThe target string: %s\nTarget occurance: %d\nThe i'th occurance: %d"
                ,bigStr, smallStr, target,ocr );

        // Looking for a target i value that greater than the occurance exists in the big string
        target = 3;
        ocr = lib.occuranceFind(bigStr, smallStr, target);
        System.out.printf("\n\nThe big string: %s\nThe target string: %s\nTarget occurance: %d\nThe i'th occurance: %d"
                ,bigStr, smallStr, target,ocr );

        // Looking for a word in the Big String's beginning and smaller than target occurance
        bigStr = new String("EmreGtuBilMuhEmreCSE102Emre");
        smallStr = new String("Emre");
        target = 1;
        ocr = lib.occuranceFind(bigStr, smallStr, target);
        System.out.printf("\n\nThe big string: %s\nThe target string: %s\nTarget occurance: %d\nThe i'th occurance: %d"
                ,bigStr, smallStr, target,ocr );

	
	System.out.printf("\n\n\n***********************************TESTING SECOND TASK***********************************\n");
        //The target numbers (between upper and lower bound) is put to head, tail and middle of the array. These conditions is run successfully.
        int [] array = {3,4,5,6,7,7,7};
        int upper = 9;
        int lower = 3;
        int size3 = 7;
        int result = lib.search(array,0,size3-1,lower,upper);
        System.out.printf("\n\n\nThe array: ");
        for(int i=0;i<size3;++i)
            System.out.printf("%d ",array[i]);

        System.out.printf("\nThe target lower bound: %d\nTarget upper bound: %d\nnumber of items in the array between two given integer values: %d",
                lower, upper,result);


        //Then, a condition that there is no number between upper and lower bound is set. This condition is run successfully.
        int [] array2 = {2,3,7,8,9,10,14};
        upper = 17;
        lower = 15;
        size3 = 7;
        result = lib.search(array2,0,size3-1,lower,upper);
        System.out.printf("\n\n\nThe array: ");
        for(int i=0;i<size3;++i)
            System.out.printf("%d ",array2[i]);

        System.out.printf("\nThe target lower bound: %d\nTarget upper bound: %d\nNumber of items in the array between two given integer values: %d",
                lower, upper,result);






	System.out.printf("\n\n\n***********************************TESTING THIRD TASK***********************************\n");
        //Subarrays are set to be consecutive. It runs successfuly
        int arr[] = {1,1,2,3,4,5,6,8,9,10};
        int size2 = 10;
        int target2 = 7;
        System.out.printf("\n\n\nThe target value: %d\nThe array: ",target2);
        for(int i=0;i<size2;++i)
            System.out.printf("%d ",arr[i]);
        System.out.println();
        lib.findSubarray(arr, size2, target2);


        // Looking for targetSum = 7, The condition that there is no subarray is run successfully
        int arr2[] = {9,10,0,1,1,2};
        size2 = 6;

        System.out.printf("\n\nThe target value: %d\nThe array: ",target2);
        for(int i=0;i<size2;++i)
            System.out.printf("%d ",arr2[i]);
        System.out.println();
        lib.findSubarray(arr2, size2, target2);


        //Looking for targetSum = 7, There are subarrays at the beginning and end of the array. This condition runs successfully
        int arr3[] = {1,2,4,6,8,10,6,1};
        size3 = 8;
        System.out.printf("\n\nThe target value: %d\nThe array: ",target2);
        for(int i=0;i<size3;++i)
            System.out.printf("%d ",arr3[i]);
        System.out.println();
        lib.findSubarray(arr3, size3, target2);


    }

}

