/**
 * Created by caoxingyun on 2018/6/29.
 */
public class ForTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if((i-10)*(i-10)+(j-10)*(j-10)<80){
                    System.out.println("*");
                }else {
                    System.out.println(" ");
                }
            }
            System.out.println();
        }
    }
}
