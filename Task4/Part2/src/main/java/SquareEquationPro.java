import java.util.Arrays;
import java.util.Objects;

public class SquareEquationPro {

    SquareEquation equation;

    public SquareEquationPro(SquareEquation equation) {
        this.equation = equation;
    }

    public SquareEquation getEquation() {
        return equation;
    }

    public void setEquation(SquareEquation equation) {
        this.equation = equation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SquareEquationPro)) return false;
        SquareEquationPro that = (SquareEquationPro) o;
        return getEquation().equals(that.getEquation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEquation());
    }

    @Override
    public String toString() {
        return String.format("Equation: %fa + %fb + %f = 0", equation.getA(), equation.getB(), equation.getC());
    }

    // Возвращает больший корень или выбрасывает исключение, если корней нет
    public double getMaxAnswer() throws IllegalArgumentException {
        return Arrays.stream(equation.solveSquareEquation()).max().orElseThrow(IllegalArgumentException::new);
    }
}
