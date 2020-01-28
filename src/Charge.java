import java.util.Arrays;

public class Charge {
    /* Class contains main parameters and measures of one Charge including it's coordinates, charge value, charge sign etc. */

    public int charge_val;
    public int charge_sign;
    public double energy;
    public double[] coordinates = new double[] {0., 0., 0.};
    public double[] old_coordinates;

    public Charge(int _charge_sign, int _charge_val) {
        /* Basic Charge class contructor. */
        charge_sign = _charge_sign;
        charge_val = _charge_val;
        energy = 0;
        // Initiate position of the charge.
        Arrays.fill(coordinates, 0.);
        // Save history position of the charge.
        old_coordinates = coordinates;
    }

    public void print_coordinates(){
        /* Function prints all coordinates of a single Charge. */
        System.out.println("Charge coords - " + "x: " + String.format( "%.4f", coordinates[0]) + "; y: " + String.format( "%.4f", coordinates[1]) + "; z: " +
                String.format( "%.4f", coordinates[2]) + ';');
    }

    public void change_coordinates(double _d_xyz) {
        /* Method slightly changes the position of the charge at random direction by _d_xyz amount. */
        old_coordinates = coordinates;
        for (int i=0; i<3; i++) {
            if (Math.random() >= 0.5) {
                coordinates[i] += _d_xyz;
            } else {
                coordinates[i] -= _d_xyz;
            }
        }
    }
}

