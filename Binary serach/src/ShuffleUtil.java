import java.util.Arrays;
import java.util.Random;

public class ShuffleUtil {
    public static int binarySearch(int[] NumArray, int target) {
        int left = 0;
        int right = NumArray.length + 1;
        int mid = (left+right)/2;
        while(left<=right){
            if(NumArray[mid]==target){
                return mid;
            } else if(NumArray[mid]>target){
                right = mid-1;
                mid = (left+right)/2;
            } else if(NumArray[mid]<target){
                left = mid+1;
                mid = (left+right)/2;
                }
            }
        return -1;
        }

    public static void main(String[] args) {
    int [] numArray = {1,2,3,4,5,6,7,8,9,10,100};
    System.out.println(ShuffleUtil.binarySearch(numArray, 10));
    }
}

