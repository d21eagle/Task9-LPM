public interface IOneArgumentFunctional<T extends IOneRealArgumentFunction> {
    double calculate(T func);
}