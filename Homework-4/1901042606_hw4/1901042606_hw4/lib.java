public class lib
{
    /**
     * TASK-1 HELPER RECURSIVE FUNCTION-> Search a given string in another given bigger string. The function should return the index of the
     ith occurrence of the query string and return -1 when the query string doesn’t occur in the big string or the number of occurences is less than i.
     * @param bigStr Bigger string
     * @param smallStr Smaller, target, string
     * @param index Current position on big string
     * @param found Current position on small string
     * @param ocr Current occurance
     * @param targetOcr Target occurance
     * @return Ocr number, if the match is cannot be found, return -1
     */
    public static int occuranceFindHelper(String bigStr, String smallStr,int index, int found, int ocr, int targetOcr)
    {
        if(ocr==targetOcr)
            return index-smallStr.length();

        else if(index==bigStr.length())
            return -1;

        if(bigStr.charAt(index)==smallStr.charAt(found) && found==smallStr.length()-1)
            return occuranceFindHelper(bigStr, smallStr, index+1, 0, ocr+1, targetOcr);

        else if(bigStr.charAt(index)==smallStr.charAt(found))
            return occuranceFindHelper(bigStr, smallStr, index+1, found+1, ocr, targetOcr);

        else
            return occuranceFindHelper(bigStr, smallStr, index+1, 0, ocr, targetOcr);
    }

    /**
     * TASK-1 FUNCTION, CALLS THE RECURSION HELPER FUNCTION Search a given string in another given bigger string. The function should return the index of the
       ith occurrence of the query string and return -1 when the query string doesn’t occur in the big string or the number of occurences is less than i.
     * @param bigStr Bigger string
     * @param smallStr Smaller, target, string
     * @param target Target occurance
     * @return Return the occurence, if the target cannot be found, return -1
     */
    public static int occuranceFind(String bigStr, String smallStr, int target)
    {
        int occuranceNum = occuranceFindHelper(bigStr, smallStr, 0,0,0,target);
        return occuranceNum;
    }

    /**
     * TASK-2 RECURSIVE FUNCTION -> recursive algorithm to find the number of items in the array between two given integer values.
     * @param arr Array
     * @param leftIndex Starting index
     * @param rightIndex Size of array
     * @param num1 The lower bound
     * @param num2 The upper bound
     * @return
     */
    public static int search(int [] arr, int leftIndex, int rightIndex, int num1, int num2)
    {
        int midElement =( rightIndex + leftIndex) / 2;

        if(rightIndex < leftIndex)
            return 0;

        if(arr[midElement] > num2)
            return search(arr, leftIndex, midElement-1,num1,num2);

        else if(arr[midElement] < num1)
            return search(arr,midElement+1, rightIndex, num1, num2);

        else
        {
            return 1 + search(arr,midElement+1, rightIndex, num1, num2)
            + search(arr, leftIndex, midElement-1,num1,num2);
        }
    }

    
    /**
     * TASK-3 RECURSIVE HELPER FUNCTION -> Find contiguous subarray/s that the sum of its/theirs items is equal to a given integer value.
     * NOTE FOR T.A. -> In this function, the subarrays are printed as "from [3] to [5]" that means "3. index of the array to 5. index of the array"
     * @param arr Array
     * @param size Array size
     * @param startIndex Starting index of the first index of the subarray that the sum of its/theirs items is equal to a given integer value.
     * @param index Current index of the subarray
     * @param currentSum Current sum of the subarray
     * @param targetSum Target sum
     */
    public static void findSubarrayHelper(int [] arr, int size, int startIndex, int index, int currentSum, int targetSum)
    {
        if(index>=size || startIndex>=size)
            return;

        if(arr[index]<=targetSum)
        {
            if(currentSum+arr[index]==targetSum)
                System.out.printf("Subarray: Range from [%d] to [%d]\n",startIndex, index);

            else if(currentSum+arr[index] <= targetSum)
            {
                findSubarrayHelper(arr, size, startIndex,index+1,currentSum+arr[index], targetSum);
                return;
            }
        }

        findSubarrayHelper(arr, size, startIndex+1,startIndex+1,0, targetSum);
    }

    /**
     * TASK-3 FUNCTION, CALLS RECURSIVE HELPER FUNCTION -> find contiguous subarray/s that the sum of its/theirs items is equal to a given integer value.
     * @param arr Array
     * @param size Array size
     * @param targetSum Target sum
     */
    public static void findSubarray(int [] arr, int size, int targetSum)
        {
        findSubarrayHelper(arr,size,0,0,0,targetSum);
    }
   }
