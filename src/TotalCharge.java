import java.util.ArrayList;
import java.util.List;

public class TotalCharge {

    public Charge[] total_charge;

    public TotalCharge (int number_of_charges) {
        total_charge = new Charge[number_of_charges];

        for (int i=0; i<number_of_charges; i++) {
            total_charge[i] = new Charge(-1, 1);
            total_charge[i].print_coords();
        }
    }
    public void plot() {
        /* add jzy3d library for 3d plots */
    }
}
