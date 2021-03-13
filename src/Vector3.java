import java.awt.*;

// This class represents vectors in a 3D vector space.
public class Vector3 {

    //TODO: change modifiers. DONE
    private double x;
    private double y;
    private double z;


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }



    //TODO: define constructor. DONE
    public Vector3(double initX, double initY, double initZ){
        this.x = initX;
        this.y = initY;
        this.z = initZ;
    }
    public Vector3() {

    }

    // Returns the sum of this vector and vector 'v'.
    public Vector3 plus(Vector3 v) {
        double vector_x = this.x, vector_y = this.y, vector_z = this.z;
        Vector3 vector = new Vector3(vector_x,vector_y,vector_z);
        double finalX = vector_x + v.getX();
        double finalY = vector_y + v.getY();
        double finalZ = vector_z + v.getZ();
        Vector3 sum = new Vector3(finalX, finalY, finalZ);
        //TODO: implement method.   DONE
        return sum;
    }

    // Returns the product of this vector and 'd'.
    public Vector3 times(double d) {
        Vector3 product = new Vector3(
                this.x * d,
                this.y * d,
                this.z * d);
        //TODO: implement method.   DONE
        return product;
    }

    // Returns the sum of this vector and -1*v.
    public Vector3 minus(Vector3 v) {
        Vector3 sum = new Vector3(
                this.x + -1*v.getX(),
                this.y + -1*v.getY(),
                this.z + -1*v.getZ()
        );
        //TODO: implement method. DONE
        return sum;
    }

    // Returns the Euclidean distance of this vector
    // to the specified vector 'v'.
    public double distanceTo(Vector3 v) {
        int power = 2;
        double x = Math.pow(this.x + v.getX(), power);
        double y = Math.pow(this.y + v.getY(),power);
        double z = Math.pow(this.z + v.getZ(),power);
        double distance = Math.sqrt(x+y+z);
        //TODO: implement method.   DONE
        return distance;
    }

    // Returns the length (norm) of this vector.
    public double length() {
        int power = 2;
        double x = Math.pow(this.x, power);
        double y = Math.pow(this.y, power);
        double z = Math.pow(this.z, power);


        double vectorNorm = Math.sqrt(x+y+z);
        //TODO: implement method.   DONE
        return vectorNorm;
    }

    // Normalizes this vector: changes the length of this vector such that it becomes 1.
    // The direction and orientation of the vector is not affected.
    public void normalize() {
        double normalize = this.length();
        this.x /= normalize;
        this.y /= normalize;
        this.z /= normalize;

        //TODO: implement method.   DONE
    }

    // Draws a filled circle with a specified radius centered at the (x,y) coordinates of this vector
    // in the existing StdDraw canvas. The z-coordinate is not used.
    public void drawAsDot(double radius, Color color) {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(this.x, this.y, radius);       // maybe use this.x and this.y instead of getters??     --> when to use this and when getter? (in class vs out of the class) <--
        //TODO: implement method.   DONE
    }

    // Returns the coordinates of this vector in brackets as a string
    // in the form "[x,y,z]", e.g., "[1.48E11,0.0,0.0]".
    public String toString() {

        //TODO: implement method.   DONE
        return "[" + this.x + "," + this.y + "," + this.z + "]";
    }

    public static void main(String[] args) {
        Vector3 vector1 = new Vector3(2,3,4);
        Vector3 vector2 = new Vector3(5,4,3);
        System.out.println("the sum is: " + vector1.plus(vector2));
        double xy = 5;
        System.out.println("the product is: " + vector1.times(xy));
        System.out.println("the sum of the vector + -1*v is: " + vector1.minus(vector2));
        System.out.println("normalized vector from vector1: " + vector1.length());
        System.out.println("testing distance between points: " + vector1.distanceTo(vector2));
        Vector3 vec3 = new Vector3(0,3,-4);
        vec3.normalize();
        System.out.println("vector (0,3,-4) normalized is:" + vec3);

    }

}

