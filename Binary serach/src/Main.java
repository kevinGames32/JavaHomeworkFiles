

public class Main {

    private static int binarySearch(int[] SortedArray, int target){
        int low = 0;
        int high = SortedArray.length - 1;

        while(low <= high){
            int mid = (low+ high)/2;
            int CurrentValue = SortedArray[mid];

            if(CurrentValue == target){
                return mid;
            }
            if(CurrentValue < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = new int[20];
        for(int i = 0; i < 20;i++)
            array[i] = i;
        System.out.println(binarySearch(array, 15));
        int[] arr2 = {1,2,3,4};

    }
}