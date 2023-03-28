package SS20;

public class A2DynamicProgramming {
    private static int naiveLIS(long[] a){
        int max = 1, curr;
        for(int i = 0; i < a.length; i++){
            if(max < a[i]){
                max++;
            }
        }
        return max;
    }
}
