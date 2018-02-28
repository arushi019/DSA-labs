package OOPintro;

class Bicycle {

    int cadence = 0;
    int speed = 0;
    int gear = 1;
    String name;

   public Bicycle(String name){
    	this.name=name;
    }
    void changeCadence(int newValue) {
         cadence = newValue;
    }

    void changeGear(int newValue) {
         gear = newValue;
    }

    void speedUp(int increment) {
         speed = speed + increment;   
    }

    void applyBrakes(int decrement) {
         speed = speed - decrement;
    }

    void printStates() {
         System.out.println(name+" bicycle with cadence:" +
             cadence + " speed:" + 
             speed + " gear:" + gear);
    }
}