import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parameters {

    public String volume_shape;
    public double d_xyz;
    public int anealing_param;
    public double temp_parameter;
    public double k_const;
    public List<String> available_shapes = new ArrayList<>(){{add("sphere"); add("cone"); add("cuboid");}};
    public double[] shape_dimensions = new double[] {1., 1., 1., 1.}; //x, y, z, r

    public Parameters(double _d_xyz, double _temp, double _k_const){
        /* Reads user's parameters */
        /*
        Boolean inputCheck = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Input volume shape from available: " + available_shapes);

        while (inputCheck){

            volume_shape = input.nextLine();

            if (available_shapes.contains(volume_shape)) {
                System.out.println("Selected shape: " + volume_shape);
                inputCheck = false;
            } else {
                System.out.println("Wrong shape, try one from available: " + available_shapes);
            }


        }
        */
        d_xyz = _d_xyz;
        temp_parameter = _temp;
        k_const = _k_const;
        anealing_param = (int) temp_parameter;
        volume_shape = "sphere";
    }
}
