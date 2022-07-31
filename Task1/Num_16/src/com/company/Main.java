package com.company;
import java.lang.Math;

class Point3D {
    double x;
    double y;
    double z;

    Point3D(double p_x, double p_y, double p_z)
    {
        this.x = p_x;
        this.y = p_y;
        this.z = p_z;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getZ()
    {
        return z;
    }

    public String printNoName()
    {
        String strX = Double.toString(x);
        String strY = Double.toString(y);
        String strZ = Double.toString(z);
        return "(" + strX + ", " + strY + ", " + strZ + ")";
    }
}

class Vector3DProcessor {
    double x;
    double y;
    double z;
    String name;

    public void print()
    {
        System.out.println(name + " = (" + x + ", " + y + ", " + z + ")");
    }

    Vector3DProcessor()
    {
        x = y = z = 0;
        name = "Vector0";
    }

    Vector3DProcessor(double v_x, double v_y, double v_z, String v_name)
    {
        this.x = v_x;
        this.y = v_y;
        this.z = v_z;
        this.name = v_name;
    }

    Vector3DProcessor(Object p1, Object p2, String v_name)
    {
        Point3D point1 = (Point3D) p1;
        Point3D point2 = (Point3D) p2;
        x = point2.getX() - point1.getX();
        y = point2.getY() - point1.getY();
        z = point2.getZ() - point1.getZ();
        name = v_name;
    }

    public double vectorLength()
    {
        double v_length;
        v_length = Math.sqrt(x*x + y*y + z*z);
        return v_length;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getZ()
    {
        return z;
    }

    public String getName()
    {
        return name;
    }

    public boolean vectorEquals(Object v)
    {
        Vector3DProcessor vector = (Vector3DProcessor) v;
        if(getX() != vector.getX() || getY() != vector.getY() || getZ() != vector.getZ()) return false;
        else return true;
    }

    public Vector3DProcessor vectorSum(Object v)
    {
        Vector3DProcessor vector_sum;
        double x_sum, y_sum, z_sum;
        Vector3DProcessor vector = (Vector3DProcessor) v;
        x_sum = getX() + vector.getX();
        y_sum = getY() + vector.getY();
        z_sum = getZ() + vector.getZ();
        vector_sum = new Vector3DProcessor(x_sum, y_sum, z_sum, "Sum vector");
        return vector_sum;
    }

    public Vector3DProcessor vectorDiff(Object v)
    {
        Vector3DProcessor vector_diff;
        double x_diff, y_diff, z_diff;
        Vector3DProcessor vector = (Vector3DProcessor) v;
        x_diff = getX() - vector.getX();
        y_diff = getY() - vector.getY();
        z_diff = getZ() - vector.getZ();
        vector_diff = new Vector3DProcessor(x_diff, y_diff, z_diff, "Difference vector");
        return vector_diff;
    }

    public double scalarProduct(Object v)
    {
        Vector3DProcessor vector = (Vector3DProcessor) v;
        double x_prod, y_prod, z_prod, xyz_prod;
        x_prod = getX() * vector.getX();
        y_prod = getY() * vector.getY();
        z_prod = getZ() * vector.getZ();
        xyz_prod = x_prod + y_prod + z_prod;
        return xyz_prod;
    }

    public Vector3DProcessor vectorProduct(Object v)
    {
        Vector3DProcessor vector_prod;
        double x_v, y_v, z_v;
        Vector3DProcessor vector = (Vector3DProcessor) v;
        x_v = getY() * vector.getZ() - getZ() * vector.getY();
        y_v = getZ() * vector.getX() - getX() * vector.getZ();
        z_v = getX() * vector.getY() - getY() * vector.getX();
        vector_prod = new Vector3DProcessor(x_v, y_v, z_v, "Vector Product");
        return vector_prod;
    }

    public boolean collinearVector(Object v)
    {
        Vector3DProcessor vector = (Vector3DProcessor) v;
        if((getX() / vector.getX() != getY() / vector.getY()) && (getY() / vector.getY() != getZ() / vector.getZ())) {
            return false;
        }
        else {return true;}
    }

    public String printNoName()
    {
        String strX = Double.toString(x);
        String strY = Double.toString(y);
        String strZ = Double.toString(z);
        return "(" + strX + ", " + strY + ", " + strZ + ")";
    }

    public double arrayLength() { return Math.sqrt(x * x + y * y + z * z); }
}

class Vector3DArray {

    Vector3DProcessor[] vectors;
    int arrOfLength;

    // Конструктор по размеру (создает массив из нулевых векторов)
    public Vector3DArray(int n) {
        vectors = new Vector3DProcessor[n];
        arrOfLength = n;
        for ( int i = 0; i < vectors.length; i++)
            vectors[i] = new Vector3DProcessor();
    }

    // Длина массива
    public int vectorArrLength()
    {
        return arrOfLength;
    }

    // Замена i-го элемента массива на заданный вектор
    public void replaceElem(Vector3DProcessor v1, int i)
    {
        if (i < 0) throw new NullPointerException("i can not be null!");
        vectors[i] = v1;
    }

    // Наибольшая длина вектора в массиве
    public double maxLength()
    {
        double maxLen = vectors[0].arrayLength();
        for ( int i = 1; i < arrOfLength; i++)
            if (maxLen < vectors[i].arrayLength()) maxLen = vectors[i].arrayLength();
        return maxLen;
    }

    // Поиск заданного вектора в массиве
    public int vectorSearch(Vector3DProcessor v1)
    {
        int temp = -1;
        for (int i = 0; i < vectors.length; i++){
            if ((v1.getX() == vectors[i].getX())
                    && (v1.getY() == vectors[i].getY())
                    && (v1.getZ() == vectors[i].getZ()))
            {
                temp = i;
                return temp;
            }
        }
        return temp;
    }

    // Сумма всех векторов в массиве
    public Vector3DProcessor vectorArrSum()
    {
        double x = 0.0, y = 0.0, z = 0.0;
        for(Vector3DProcessor v1: vectors)
        {
            x += v1.getX();
            y += v1.getY();
            z += v1.getZ();
        }
        return new Vector3DProcessor(x, y, z, "Sum of all vectors in the array: ");
    }

    // Линейная комбинация векторов с заданными коэффициентами
    public Vector3DProcessor linearCombo(double[] indexArr) throws Exception
    {
        if (indexArr.length != vectors.length) throw new Exception();
        else
        {
            double x = 0.0, y = 0.0, z = 0.0;
            for(int i = 0; i < vectors.length; i++)
            {
                x += indexArr[i] * vectors[i].getX();
                y += indexArr[i] * vectors[i].getY();
                z += indexArr[i] * vectors[i].getZ();
            }
            return new Vector3DProcessor(x, y, z, "Linear combination of vectors: ");
        }
    }

    // Массив точек, каждая из которых – результат сдвига точки P, на соответствующий вектор
    public Point3D[] shiftPoint(Point3D P)
    {
        double pX, pY, pZ;
        Point3D[] pointArr = new Point3D[vectors.length];
        for (int i = 0; i < vectors.length; i++)
        {
            pX = P.getX() + vectors[i].getX();
            pY = P.getY() + vectors[i].getY();
            pZ = P.getZ() + vectors[i].getZ();
            pointArr[i] = new Point3D(pX, pY, pZ);
        }
        return pointArr;
    }
}

public class Main {

    public static void main(String[] args) {

        Vector3DProcessor vector1 = new Vector3DProcessor(1,2,3,"Vector1");
        Vector3DProcessor vector2 = new Vector3DProcessor(2,4,6,"Vector2");
        Point3D point1 = new Point3D(3,4,5);
        Point3D point2 = new Point3D(0, 0, 0);
        //Vector3DProcessor vector2 = new Vector3DProcessor(point1, point2, "Vector2");

        System.out.println("Number 16:");
        // Длина вектора 1
        vector1.print();
        double length1 = vector1.vectorLength();
        System.out.print("Length of " + vector1.getName() + ": " + length1 + "\n");

        // Длина вектора 2
        vector2.print();
        double length2 = vector2.vectorLength();
        System.out.print("Length of " + vector2.getName() + ": " + length2 + "\n");

        // Проверка векторов на равенство
        if (vector1.vectorEquals(vector2)) {
            System.out.println("Vectors are equal!");
        }
        else {
            System.out.println("Vectors aren't equal!");
        }

        System.out.println("\nNumber 17:");
        // Сумма векторов
        vector1.vectorSum(vector2).print();

        // Разность векторов
        vector1.vectorDiff(vector2).print();

        // Скалярное произведение векторов
        double scalar = vector1.scalarProduct(vector2);
        System.out.println("Scalar Product of vectors: " + scalar);

        // Векторное произведение векторов
        vector1.vectorProduct(vector2).print();

        // Проверка коллинеарности векторов
        if (vector1.collinearVector(vector2)) {
            System.out.println("Vectors are collinear!");
        }
        else {
            System.out.println("Vectors aren't collinear!");
        }

        System.out.println("\nNumber 18:");
        Vector3DArray arrVector1 = new Vector3DArray(10);

        // Вектора для заполнения
        Vector3DProcessor vector00 = new Vector3DProcessor(0, 0, 0, "Vector A");
        Vector3DProcessor vector10 = new Vector3DProcessor(3, -8, -1, "Vector B");
        Vector3DProcessor vector20 = new Vector3DProcessor(-7, 4, 3, "Vector C");
        Vector3DProcessor vector30 = new Vector3DProcessor(5, 6, 0, "Vector D");
        Vector3DProcessor vector40 = new Vector3DProcessor(-2, 13, 11, "Vector E");
        Vector3DProcessor vector50 = new Vector3DProcessor(10, -1, 9, "Vector F");

        // Замена i-го элемента массива на заданный вектор
        arrVector1.replaceElem(vector00, 0);
        arrVector1.replaceElem(vector10, 1);
        arrVector1.replaceElem(vector20, 2);
        arrVector1.replaceElem(vector30, 3);
        arrVector1.replaceElem(vector40, 4);
        arrVector1.replaceElem(vector50, 5);

        // Длина массива
        int length = arrVector1.vectorArrLength();
        System.out.println("Length of array: " + length);

        // Наибольшая длина вектора в массиве
        double maxLength = arrVector1.maxLength();
        System.out.println("Max length of vector in the array = " + maxLength);

        // Поиск заданного вектора в массиве
        Vector3DProcessor vectorZ = new Vector3DProcessor(9, 10, 11, "Vector Z");
        //Vector3DProcessor vectorA = vector10;
        int search = arrVector1.vectorSearch(vectorZ);
        System.out.println("Search result for " + vectorZ.getName() + vectorZ.printNoName() + " in the array = " + search);

        // Сумма всех векторов в массиве
        Vector3DProcessor arrSum = arrVector1.vectorArrSum();
        System.out.println(arrSum.getName() + arrSum.printNoName());

        // Вычисление линейной комбинации векторов с заданными коэффициентами
        double[] indexArr = {0, 1, 2, 3, 4, 5};
        try {
            Vector3DProcessor lineCombOfVectors = arrVector1.linearCombo(indexArr);
            System.out.println(lineCombOfVectors.getName() + lineCombOfVectors.printNoName());
        } catch (Exception e) { System.out.println("Lengths of the arrays aren't equal."); }

        // Массив точек, каждая из которых – результат сдвига точки P, на соответствующий вектор
        Point3D P = new Point3D(1, 1, 1);
        Point3D[] pointArr = arrVector1.shiftPoint(P);
        System.out.println("Shifting the array by point P" + P.printNoName() + ":");
        for (int i = 0; i < pointArr.length; i++)
        {
            System.out.println("P[" + i + "] = ("
                    + pointArr[i].getX()
                    + ", " + pointArr[i].getY()
                    + ", " + pointArr[i].getZ() + ")");
        }
    }
}
