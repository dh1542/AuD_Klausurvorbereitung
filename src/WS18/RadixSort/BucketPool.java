package WS18.RadixSort;

import java.util.LinkedList;
import java.util.List;

public class BucketPool {
    private List<List<String>> pool = new LinkedList<>();

    BucketPool (int num){
        for(int i = 0; i < num; i++){
            pool.add(new LinkedList<String>());
        }
    }

    List<List<String>> getBuckets(int n){
        // returns n empty buckets form pool
        return null;
    }

    void dropBuckets(List<List<String>> bs) { // empties and adds bs to pool
         }

    public void sort(List<String> in){
        sort(in, 0, new BucketPool(45));
    }

    private void sort(List<String> in, int charPos, BucketPool bp){
        List<List<String>> bs;
        if(charPos < 5){
            bs = bp.getBuckets(9);
            for(String s : in){
                char c = s.charAt(charPos);
                if(c >= '1' && c <= '9'){
                    bs.get(Character.getNumericValue(c)).add(s);
                    in.remove(s);
                }

            }

            sort(in, charPos + 1, bp);

            for(List<String> list : bs){
                sort(list, charPos + 1, bp);


                in.addAll(list);
            }

            bp.dropBuckets(bs);

        }
    }
}
