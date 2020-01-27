import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parameters {

    public String volumeShape;
    public List<String> availableShapes = new ArrayList<>(){{add("sphere"); add("cone"); add("cuboid");}};
    public float[] shapeDimensions = new float[] {(float)1., (float)1., (float)1.};

    public Parameters(){
        /* Reads user's parameters */
        /*
        Boolean inputCheck = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Input volume shape from available: " + availableShapes);

        while (inputCheck){

            volumeShape = input.nextLine();

            if (availableShapes.contains(volumeShape)) {
                System.out.println("Selected shape: " + volumeShape);
                inputCheck = false;
            } else {
                System.out.println("Wrong shape, try one from available: " + availableShapes);
            }


        }
        */
        volumeShape = "sphere";
    }
}
