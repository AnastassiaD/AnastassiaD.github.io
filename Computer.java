import java.util.Random;

public class Computer extends Player{


    public Computer(String name) {
        super(name);
    }

    public static int numberGenerator(){
        return new Random().nextInt(3)+1;
    }
}
