package algorithm.topics.unclassified;

/**
 * Created by yamorn on 2016/4/13.
 *
 * Reference: Concrete Mathematics
 */
public class Josephus {

    public static void josephus(int n, int k){
        int answer = 0;
        for(int i = 1; i<=n; i++){
            answer = (answer + k) % i;
            System.out.println("survival: " + answer);
        }
    }

    public static void main(String[] args) {
        josephus(8, 4);
    }
}
