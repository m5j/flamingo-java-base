package suanfa.erfenchazhao;

/**
 * 二分查找
 * 特点：在一个有序的列表中查找某个元素的位置。二分查找速度较快，时间复杂度为log n
 * Created by minwujun on 2020/8/4
 */
public class BinarySearchDemo {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 16, 17, 18, 19, 20};
        Integer result = binarySearch(array, 2);
        System.out.println(result);
    }

    public static Integer binarySearch(int[] array, int item) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = array[mid];
            if (guess == item) {
                return mid;
            }
            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }
}
