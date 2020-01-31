
public class ChargeDistribution {

    public static void main(String[] args) {
        /* Good working parameters:
        * d_xyz = 0.001
        * temp = 100.
        * k_const = 8
        * number_of_charges = 30
        * iterations = 100000 */
        Parameters params = new Parameters(0.0001, 100., 8);
        TotalCharge total_charge = new TotalCharge(30, params); // Create 10 particles with negative charge
        SimulationCore sim = new SimulationCore(params, total_charge);
        //SimulationSynchronous sim = new SimulationSynchronous(params, total_charge);
        sim.simulation(1000000); // those are iterations in a single loop
    }
}
