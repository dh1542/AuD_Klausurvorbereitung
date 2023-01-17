package WS17;

import java.util.Arrays;
import java.util.LinkedList;

public class A3RadixSort {
    static void radixSort(LinkedList<Integer> list) {
        // prepare sufficient buckets bs with empty lists:

        LinkedList<Integer>[] bs = new LinkedList[10];
        for(int i = 0; i < 10; i++){
            bs[i] = new LinkedList<>();
        }


        LinkedList<Integer> lastBucket = list;


        // for each segment of the Integer radix
        for(int i = 0; i < 10; i++){
            // distribute values into buckets
            int currentMin = 10;
            int currentMinIndex = 0;
            while(!lastBucket.isEmpty()){
                for(int j = 0; j < lastBucket.size(); j++){
                    int value = lastBucket.get(j);
                    int b = (int) (value /Math.pow(10, i)) % 10;
                    if(b < currentMin){
                        currentMin = b;
                        currentMinIndex = j;
                    }
                }


                bs[i].addLast(lastBucket.remove(currentMinIndex));

                currentMinIndex = 0;
                currentMin = 10;


            }
            lastBucket.addAll(bs[i]);
        }

        // recollect values from buckets
        list.removeAll(list);
        list.addAll(bs[9]);
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(9);
        list.add(19);
        list.add(2);
        list.add(32);
        list.add(4);
        list.add(28);

        System.out.println(list);
        radixSort(list);

        System.out.println(list);
    }

}
