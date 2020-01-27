import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Parameters {

    public String volumeShape;
    public List<String> availableShapes = new ArrayList<>(){{add("sphere"); add("cone"); add("cuboid");}};
    public List<Double> shapeDimensions = new ArrayList<>(){{add(1.); add(1.); add(1.);}};

    public void main(String[] args){
        Parameters params = new Parameters();
    }

    public Parameters(){
        /* Reads user's parameters */

        Boolean inputCheck = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Input volume shape from available: sphere, cuboid, cone.");

        while (inputCheck){

            volumeShape = input.nextLine();

            if (availableShapes.contains(volumeShape)) {
                System.out.println("Selected shape: " + volumeShape);
                inputCheck = false;
            } else {
                System.out.println("Wrong shape, try again");
            }
        }
    }
}
