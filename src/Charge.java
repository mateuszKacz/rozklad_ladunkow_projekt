import java.util.ArrayList;
import java.util.List;

public class Charge {

    public int charge_val;
    public int charge_sign;
    public List<Double> coords = new ArrayList<>(){{add(0.); add(0.); add(0.);}};

    public static void main(String[] args) {

    }

    public Charge(int _charge_sign, int _charge_val) {
        charge_sign = _charge_sign;
        charge_val = _charge_val;

    }
}
