package SS21;

public class A2BinarySearch {
    public static void main(String[] args){
        long[] a = {2, 12, 15, 16, 21, 23, 33, 83, 92, 95, 96, 98, 112};
        System.out.println(first(a, 12, 0, 8));
    }

    static int first(long[] a, long k, int low, int high){
        int mid;
        boolean found = false;
        // get mid index
        
        
        while(true){
            mid = (high + low) / 2; 
            if(k == a[mid]){
                high = mid;
            }
            if(a[mid] > k){
                high = mid;
            }
            if(a[mid] < k){
                low = mid;
            }
        }

    }
}