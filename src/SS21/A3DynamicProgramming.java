package SS21;

public class A3DynamicProgramming {
    public static void main(String[] args) {
        int[] ks = {10, 22, 5, 75, 65, 80};
        //System.out.println(maxProfitOne(ks, 0, ks.length ));
        System.out.println(maxProfitTwoNaiv(ks));
    }


    private static int maxProfitOneNaiv(int[] ks, int a, int z) {
        int maxProf = 0; // falls kein Profit moeglich ist
        for(int i = 0; i < z; i = i +  2){
            for(int j = i + 1; j < z; j = j + 2){
                int currentProf = ks[j] - ks[i];
                if(maxProf < currentProf){
                    maxProf = currentProf;
                }
            }
        }
        return maxProf;
    }

    private static int maxProfitOne(int[] ks, int a, int z){
        int maxProf = 0;
        int minPrice = Integer.MAX_VALUE;
        int maxSell = 0;
        for(int i = 0; i < z; i++){

            if(i % 2 == 0){
                if(ks[i] < minPrice){
                    minPrice = ks[i];
                }
            }
            else{
                if(ks[i] > maxSell){
                    maxSell = ks[i];
                }
            }
        }

        maxProf = maxSell - minPrice;
        return maxProf;

    }

    private static int maxProfitTwoNaiv(int[] ks) {
            int n = ks.length;
            int maxProfit = 0;
            for(int i = 1; i < n; i++){
                int profit1 = maxProfitOne(ks, 0, i);
                int profit2 = maxProfitOne(ks, i, n);
                int totalProfit = profit1 + profit2;
                maxProfit = Math.max(maxProfit, totalProfit);
            }
            return maxProfit;

    }

}
