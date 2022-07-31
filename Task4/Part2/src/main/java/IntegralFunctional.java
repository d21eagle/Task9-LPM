public class IntegralFunctional<T extends IOneRealArgumentFunction> {
    private final double rightLimit, leftLimit;

    public IntegralFunctional(double leftLimit, double rightLimit) {
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
    }

    public double calculate(T function, double eps, double c) throws IllegalArgumentException {
        if (leftLimit < function.getLeftEnd() || rightLimit > function.getRightEnd()) throw new IllegalArgumentException();
        double n = 2, s, s1 = 0, x;
        do {
            double h = (rightLimit - leftLimit) / n;
            x = leftLimit + (c * h);
            s = 0;
            for (int i = 0; i < n - 1; i++) {
                double f = function.getFunctionValue(x);
                s = s + f;
                x = x + h;
            }
            s = s * h;
            if(!(Math.abs(s - s1) <= eps)) {
                s1 = s;
                n = 2 * n;
            }
            else break;
        } while (Math.abs(s - s1) <= eps);
        return s;
    }
}