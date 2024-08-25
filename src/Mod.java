public class Mod {
    public static long calculateExponent(long base, long mod, long target) {
        long result = -1;
        long current = 1;

        for (long s = 1; s < mod; ++s) {
            current = (current * base) % mod;

            if (current == target) {
                result = s;
                break;
            }
        }

        return result;
    }

    public static void calculateStepsMultiply(long base, long mod, long limit) {
        long current = 1;

        for (long s = 1; Math.pow(2, s) < limit; ++s) {
            long temp = current;
            if (s == 1) {
                current = base;
            } else {
                current = current * current;
            }
            current = current % mod;
            System.out.print("$(");
            for (int i=0;i<s;i++) {
                System.out.print("x_{"+ (i+1) +"} ");
                if (i==s-2&&s!=-1){
                    System.out.print(")");
                }
            }
            System.out.print(" \\mod p =");
            System.out.println(temp*current%mod+"$    \\\\ \\hline");
        }
    }

    public static void calculateSteps(long base, long mod, long limit, int control) {
        long current = 1;

        switch (control) {
            case 1:
                for (long s = 1; Math.pow(2, s) < limit; ++s) {
                    if (s == 1) {
                        current = base;
                    } else {
                        current = current * current;
                    }
                    System.out.print((int) Math.pow(2, s) + " & $" + current);
                    current = current % mod;
                    System.out.println(" \\mod 104651 = " + current + "$    \\\\ \\hline");
                }
                break;
            case 2:
                for (long s = 1; Math.pow(2, s) < limit; ++s) {
                    if (s == 1) {
                        current = base;
                    } else {
                        current = current * current;
                    }
                    //System.out.print((int)Math.pow(2, s) + " & $" + current);
                    current = current % mod;
                    //System.out.println(" \\mod 104651 = " + current + "$    \\\\ \\hline");
                    System.out.print(current+" * ");
                }
                break;
            default:
                System.out.println("Invalid control value");
        }
    }

    public static void main(String[] args) {
        System.out.println("The value of exponent is " + calculateExponent(24576, 104651, 3190));
        calculateSteps(24576, 104651, 100418, 1);
        calculateSteps(24576, 104651, 100418, 2);
        calculateStepsMultiply(24576, 104651, 100418);
    }
}