import java.util.Random;

public class TotalCharge {

    public Charge[] total_charge;
    public int number_of_charges;
    public double total_energy;
    Parameters params;

    public TotalCharge (int _number_of_charges, Parameters _params) {

        total_charge = new Charge[_number_of_charges];
        number_of_charges = _number_of_charges;
        params = _params;

        for (int i=0; i<number_of_charges; i++) {
            total_charge[i] = new Charge(-1, 1);
        }
        recalculate_all_energies();
        total_energy = calculate_total_energy();
    }

    public void plot() {
        /* add jzy3d library for 3d plots */
    }

    public void print_coordinates(){
        /* prints coordinates of all charges */
        for (int i=0; i<number_of_charges; i++) {
            total_charge[i].print_coordinates();
        }
    }

    public void calculate_charge_energy(int charge_number) {
        /* Method calculates energy for one charge */

        total_charge[charge_number].energy = calculate_charge_superposition_energy(charge_number) +
                                             calculate_surface_energy(charge_number);
    }

    public void recalculate_all_energies() {
        /* Method recalculates energies for all charges */

        for (int i=0; i<number_of_charges; i++) {
            calculate_charge_energy(i);
        }
    }

    public double calculate_total_energy() {
        /* Method returns total energy of the whole */
        double new_total_energy = 0;

        for (Charge charge: total_charge) {
            new_total_energy += charge.energy;
        }
        return new_total_energy;
    }

    public void position_change(int i) {
        /* Method changes position of charge i by d_xyz param */
        total_charge[i].change_coordinates(params.d_xyz);
    }

    public void revert_change(int i) {
        /* Reverts the change if the change wasn't accepted */

        total_charge[i].coordinates = total_charge[i].old_coordinates;
        recalculate_all_energies();
    }

    public double calculate_change_probability(double _new_total_energy) {
        /* Method returns actual acceptance probability of the new state. */
        return Math.exp(-params.k_const * Math.abs(_new_total_energy-total_energy)/params.temp_parameter);
    }

    public double calculate_charge_superposition_energy(int _charge_number) {
   /* Method takes */
        double _new_energy = 0;
        for (int i=0; i<number_of_charges; i++) {
            // U(r) = SUM(k*q*Q_i/r_i) - equation for potential of charge q
            if (i != _charge_number) {
                _new_energy += 1 / (Math.sqrt(
                                    Math.pow((total_charge[_charge_number].coordinates[0] - total_charge[i].coordinates[0]), 2) +
                                    Math.pow((total_charge[_charge_number].coordinates[1] - total_charge[i].coordinates[1]), 2) +
                                    Math.pow((total_charge[_charge_number].coordinates[2] - total_charge[i].coordinates[2]), 2)));
            }
        }
        return _new_energy;
    }

    public double calculate_surface_energy(int _charge_number) {
        /* Method calculates energy of surface vs charge */
        /* U_s = 1/(d)
        * d - wektor between surface and charge
        * d = |A * x_a + B * y_b + C * z_c - D| / SQRT(A^2 + B^2 + C^2)
        * A,B,C,D - surface dimensions, D is a radius in sphere */
        return 1/ ((Math.abs(params.shape_dimensions[0] * total_charge[_charge_number].coordinates[0] +
                            params.shape_dimensions[1] * total_charge[_charge_number].coordinates[1] +
                            params.shape_dimensions[2] * total_charge[_charge_number].coordinates[2] -
                            params.shape_dimensions[3]))
                    /
                    Math.sqrt(Math.pow(params.shape_dimensions[0], 2) +
                              Math.pow(params.shape_dimensions[1], 2) +
                              Math.pow(params.shape_dimensions[2], 2)));
    }
}
