import java.util.Random;

public class SimulationCore {
    /* Class contains main algorithm of the simulation */

    private Parameters params;
    private TotalCharge total_charge;

    public SimulationCore(Parameters _params, TotalCharge _total_charge){
        params = _params;
        total_charge = _total_charge;
    }

    public void simulation(int iterations) {
        /* Main algorithm of the simulation */
        double new_energy;
        int random_index;
        double acceptance_pdb;
        // Statistic
        double mean_pdb = 0;
        int acc_pdb_count = 0;
        // Code

        for (int an = 0; an<params.anealing_param; an++) {
            /* Simulated anealing */

            for (int s = 0; s < iterations; s++) {
                random_index = new Random().nextInt(total_charge.number_of_charges);
                total_charge.position_change(random_index);
                total_charge.recalculate_all_energies();
                new_energy = total_charge.calculate_total_energy();
                if (new_energy < total_charge.total_energy) {
                    total_charge.total_energy = new_energy; // change accepted automatically
                } else {
                    acceptance_pdb = total_charge.calculate_change_probability(new_energy);
                    //Statistic
                    mean_pdb += acceptance_pdb;
                    acc_pdb_count += 1;
                    //code
                    if (Math.random() <= acceptance_pdb) {
                        total_charge.total_energy = new_energy; // change accepted, because of the probability of accepting worse state
                    } else {
                        total_charge.revert_change(random_index);
                    }
                }
            }
            mean_pdb = mean_pdb/acc_pdb_count;

            System.out.println("Temp: " + params.temp_parameter + " ; Energy: " + total_charge.total_energy + " " +
                    "; Mean pdb: " + mean_pdb + " ;");

            params.temp_parameter -= 1;
            mean_pdb = 0;
            acc_pdb_count = 0;
        }
    }
}
