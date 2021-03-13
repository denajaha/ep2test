import java.awt.*;

// This class represents celestial bodies like stars, planets, asteroids, etc..
public class Body {

    //TODO: change modifiers.   DONE
    private String name;
    private double mass;
    private double radius;
    private Vector3 position; // position of the center.
    private Vector3 currentMovement;
    private Color color; // for drawing the body.

    //TODO: define constructor. DONE

    // this definition:
    // The this keyword refers to the current object in a method or constructor.
    //
    //The most common use of the this keyword is to eliminate the confusion between
    // class attributes and parameters with the same name
    // (because a class attribute is shadowed by a method or constructor parameter).
    public Body(String initName, double initMass, double initRadius, Vector3 initPosition, Vector3 initCurrentMovement, Color initColor) {
        name = initName;
        mass = initMass;
        radius = initRadius;
        position = initPosition;
        currentMovement = initCurrentMovement;
        color = initColor;

    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getCurrentMovement() {
        return currentMovement;
    }

    public Color getColor() {
        return color;
    }

    // Returns the distance between this body and the specified 'body'.
    public double distanceTo(Body body) {
        double distance = this.position.distanceTo(body.position);
        //TODO: implement method.   DONE
        return distance;
    }

    //Returns a vector representing the gravitational force exerted by 'body' on this body.
    //The gravitational Force F is calculated by F = G*(m1*m2)/(r*r), with m1 and m2 being the masses of the objects
    //interacting, r being the distance between the centers of the masses and G being the gravitational constant.
    //To calculate the force exerted on b1, simply multiply the normalized vector pointing from b1 to b2 with the
    //calculated force
    public Vector3 gravitationalForce(Body body) {
        double force = Simulation.G * ((this.mass * body.mass) / Math.pow(this.position.distanceTo(body.position), 2));
        Vector3 direction = body.position.minus(this.position);
        direction.normalize();

        //TODO: implement method.   DONE
        return direction.times(force);
    }

    // Moves this body to a new position, according to the specified force vector 'force' exerted
    // on it, and updates the current movement accordingly.
    // (Movement depends on the mass of this body, its current movement and the exerted force)
    // Hint: see simulation loop in Simulation.java to find out how this is done
    public void move(Vector3 force) {
        /*Vector3 newPosition = new Vector3();
        newPosition.plus(this.position.times());*//*
        Vector3 newPosition = new Vector3();
        this.currentMovement = force.plus(newPosition);
        //this.currentMovement.times(1 / this.mass);
        this.position = this.currentMovement.times(1 / this.mass);
        // very bad attempt to solve this, if Tutor / Prof is reading this: we get
        // SO LITTLE information in order to write our functions
        */

        Vector3 newPosition = (force.times(1 / this.mass).plus(this.position)).plus(this.currentMovement);
        Vector3 newMovement = newPosition.minus(this.position);
        this.position = newPosition;
        this.currentMovement = newMovement;
        //TODO: implement method.   DONE
    }


    // Returns a string with the information about this body including
    // name, mass, radius, position and current movement. Example:
    // "Earth, 5.972E24 kg, radius: 6371000.0 m, position: [1.48E11,0.0,0.0] m, movement: [0.0,29290.0,0.0] m/s."
    public String toString() {

        //TODO: implement method.   DONE
        return this.name + ", " + this.mass + " kg, radius: " + this.radius + " m, position: " + this.position + " m, movement: " + this.currentMovement + " m/s.";
    }

    // Draws the body to the current StdDraw canvas as a dot using 'color' of this body.
    // The radius of the dot is in relation to the radius of the celestial body
    // (use a conversion based on the logarithm as in 'Simulation.java').
    // Hint: use the method drawAsDot implemented in Vector3 for this
    public void draw() {
        this.position.drawAsDot(1e9 * Math.log10(this.radius), this.color);
        //TODO: implement method.   DONE
    }

    public static void main(String[] args) {
        Vector3 sunPosition = new Vector3(0, 0, 0);
        Vector3 sunCurrentMovement = new Vector3(0, 0, 0);
        Body sun = new Body("Sol", 1.989e30, 696340e3, sunPosition, sunCurrentMovement, StdDraw.YELLOW);

        Vector3 earthPosition = new Vector3(148e9, 0, 0);
        Vector3 earthCurrentMovement = new Vector3(0, 20.29e3, 0);
        Body earth = new Body("Earth", 5.972e24, 6371e3, earthPosition, earthCurrentMovement, StdDraw.BLUE);

        Vector3 mercuryPosition = new Vector3(-46.0e9, 0, 0);
        Vector3 mercuryCurrentMovement = new Vector3(0, -47.87e3, 0);
        Body mercury = new Body("Mercury", 3.301e23, 2.4397e3, mercuryPosition, mercuryCurrentMovement, StdDraw.RED);

        System.out.println("testing distance: " + sun.distanceTo(earth));
        System.out.println("testing to string: " + earth);
    }

}

