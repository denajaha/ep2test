public class class1 {
    public static void main(String[] args) {
        int x = (int) (Math.random()*10);
        double y = (Math.random()*10);
        float z;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        z = x;
        x = (int) y;
        y = z;
        System.out.println("-------------");
        System.out.println("x = " + x);
        System.out.println("x = " + y);
    }
}
