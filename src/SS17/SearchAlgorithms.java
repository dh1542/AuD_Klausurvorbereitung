package SS17;

import java.util.Arrays;
import java.util.LinkedList;

public class SearchAlgorithms {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 3, 6, 37, 82};
        System.out.println(Arrays.toString(searchLinear(arr, 88)));
    }
    static int[] searchNaive(int[] a, int z){
        int[] r = null;
        for(int i = 0; i < a.length; i++){
            for(int j = i; j < a.length; j++){
                if(a[i] + a[j] == z && j != i){
                    r = new int[]{a[i], a[j]};
                    return r;
                }
            }
        }

        return r;
    }

    private static int[] searchLinear(int[] a, int z) {
        int i = 1, j = a.length - 1;
        while(i < j){
            int result = a[i] + a[j];

            if(result == z){
                return new int[] {a[i], a[j]};
            }

            if(result < z){
                i++;
            }
            else{
                j--;
            }
        }

        return null;
    }

    class AVLTree{

    }

}
