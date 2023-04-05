/*
Write a class definition for an abstract class, Vehicle, that contains:
• a double instance variable, maxSpeed
• a protected double instance variable, currentSpeed
• a constructor accepting a double used to initialize the maxSpeed instance variable
• an abstract method, accelerate, that accepts no parameters and returns nothing.
• a method getCurrentSpeed that returns the value of currentSpeed
• a method getMaxSpeed that returns the value of maxSpeed
• a method pedalToTheMetal, that repeatedly calls accelerate until the speed of the vehicle
is equal to maxSpeed. pedalToTheMetal returns nothing.

Can you create an instance of Vehicle?

 */

abstract class Vehicle {
    public double maxSpeed;
    protected double currentSpeed;
    public Vehicle(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public abstract void accelerate();
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    public double getMaxSpeed() {
        return maxSpeed;
    }
    public void pedalToTheMetal() {
        while (currentSpeed < maxSpeed) {
            accelerate();
        }
    }

}

class Car extends Vehicle{
    public Car(double maxSpeed){
        super(maxSpeed);
    }

    @Override
    public void accelerate(){
        currentSpeed++;
        System.out.println("Current speed: " + currentSpeed);
    }
}
public class T1Q4{
    public static void main(String[]args){
        // Vehicle v = new Vehicle(100);
        // System.out.println(v.maxSpeed);
        Car vehicle = new Car(10);
        vehicle.pedalToTheMetal();
    }
}