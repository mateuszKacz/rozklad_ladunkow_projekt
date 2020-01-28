
public class ChargeDistribution {

    public static void main(String[] args) {

        Parameters params = new Parameters(0.001, 100., 8);
        TotalCharge total_charge = new TotalCharge(30, params); // Create 10 particles with negative charge
        SimulationCore sim = new SimulationCore(params, total_charge);
        sim.simulation(100000);
    }

}
