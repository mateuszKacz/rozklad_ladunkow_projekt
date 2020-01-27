import java.util.ArrayList;
import java.util.List;

public class Charge {

    public int charge_val;
    public int charge_sign;
    public float[] coords = new float[] {(float)0., (float)0., (float)0.};

    public static void main(String[] args) {

    }

    public Charge(int _charge_sign, int _charge_val) {
        charge_sign = _charge_sign;
        charge_val = _charge_val;

        for (int i=0; i<coords.length; i++) {
             coords[i] = (float) Math.random();
        }
    }

    public void print_coords(){

        System.out.println("Charge coords - " + "x: " + coords[0] + " y: " + coords[1] + " z: " + coords[2]);

    }
}

