package SS17.A4List;

import java.lang.reflect.Array;
import java.util.Comparator;

public class SkipListSet<E extends Comparable<? super E>> {
    private static final int LEVELS = 32;

    private class Node {
        private final E e;
        private Node[] next = (Node[]) Array.newInstance(Node.class, LEVELS);
        public Node (E e){
            this.e = e;
        }
    }
    private Node head = new Node(null);
    private int getRandomLevel(){ return 3;}

    private boolean contains(E e){
        Node cur = head;
        for(int l = LEVELS - 1; l >= 0; l--){
            while(cur.next[l] != null && cur.next[l].e.compareTo(e) <= 0){
                if(cur.next[l].e.compareTo(e) == 0){
                    return true;
                }
                cur = cur.next[l];
            }
        }
        return false;
    }

    private Node[] getPred(E e){
        Node[] last = (Node[]) Array.newInstance(Node.class, LEVELS);
        Node cur = head;

        for(int l = LEVELS - 1; l >= 0; l++){
            while(cur.next[l] != null && cur.next[l].e.compareTo(e) < 0){
                cur = cur.next[l];
            }
            last[l] = cur;
        }
        return last;
    }

    private boolean insert (E e){
        Node newN = new Node(e);
        int newL = getRandomLevel();
        if(contains(e)){
            return false;
        }
        Node[] pred = getPred(e);
        for(int l = newL;  l >= 0; l--){
            newN.next[l] = pred[l].next[l];
            pred[l].next[l] = newN;
        }
        return true;
    }

    private boolean delete (E e){
        Node newN = new Node(e);
        if(contains(e)){
            return false;
        }
        Node[] pred = getPred(e);
        for(int l = LEVELS - 1;  l >= 0; l--){
            if(pred[l].next[l] != null) {
                pred[l].next[l] = pred[l].next[l].next[l];
            }
        }
        return true;
    }

}
