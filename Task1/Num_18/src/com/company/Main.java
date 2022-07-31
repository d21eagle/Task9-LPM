public class Main {

    public static void main(String[] args) {
        System.out.println("\n\n// 18 задание //");
        Vector3DArray vArr = new Vector3DArray(5);

        Vector3D vector0 = new Vector3D(0, 0, 0);
        Vector3D vector1 = new Vector3D(2, 5, -1);
        Vector3D vector2 = new Vector3D(-12, 4, 1);
        Vector3D vector3 = new Vector3D(1, 1, 1);
        Vector3D vector4 = new Vector3D(-1, -1, 1);


        vArr.replaceVector(vector0, 0);
        vArr.replaceVector(vector1, 1);
        vArr.replaceVector(vector2, 2);
        vArr.replaceVector(vector3, 3);
        vArr.replaceVector(vector4, 4);


        System.out.println("Длина массива = " + vArr.getLength());
        System.out.println("Наибольшая длина векторов в массиве = " + vArr.maxLength());

        //Vector3D vM=vector1;
        Vector3D vM = new Vector3D(45, 6, 3);

        int i = vArr.searchVect(vM);
        System.out.println("Результат поиска вектора M" + vM.printXYZ() + " в массиве = " + i);

        Vector3D sumAll = vArr.summarize();
        System.out.println("Сумма всех векторов в массиве = " + sumAll.printXYZ());


        double[] z = {2, 2, 2, 2, 12};
        try {
            Vector3D lineCombVector = new Vector3D();
            lineCombVector = vArr.linearComb(z);
            System.out.println("Результат вычисление линейной комбинации = " + lineCombVector.printXYZ());
        } catch (Exception e) {
            System.out.println("Результат не существует, т.к. длины массивов разные. ");
        }

        Point3D P = new Point3D(0, 0, 0);
        Point3D[] pArr = vArr.shiftPoint(P);
        System.out.println("\nСдвиг массива по точке P" + P.printXYZ());
        for (int i1 = 0; i1 < pArr.length; i1++) {
            System.out.println("P[" + i1 + "] = (" + pArr[i1].getX() + ", " + pArr[i1].getY() + ", " + pArr[i1].getZ() + ")");
        }
        System.out.println();
    }

public class Vector3DArray {

    private final Vector3D[] vectorArray; //массив векторов
    private final int vectorLength; //массив длин векторов


    //конструктор по размеру, создаёт n векторов длины 0
    public Vector3DArray ( int n ) {
        vectorArray = new Vector3D[n];
        vectorLength = n;
        for ( int i = 0; i < vectorArray.length; i++ ) {
            vectorArray[i] = new Vector3D();
        }
    }

    //длина массива
    public int getLength() {
        return vectorLength;
    }

    //замена i-го элемента массива на заданный вектор а
    public void replaceVector( Vector3D a, int i ) {
        vectorArray[i] = a;
        //vectLenArr[i] = a.vectorLength();
    }

    //поиск максимальной длины вектора в массиве
    public double maxLength(){
        double max = vectorArray[0].length();
        for ( int i = 1; i < vectorLength; i++ ){
            if (max< vectorArray[i].length() ) {
                max = vectorArray[i].length();
            }
        }
        return max;
    }

    //поиск заданного вектора в массиве
    public int searchVect ( Vector3D v0){
        int k = -1;
        for ( int i = 0; i < vectorArray.length; i++ ){
            if ((v0.getX() == vectorArray[i].getX())&&(v0.getY() == vectorArray[i].getY())&&(v0.getZ() == vectorArray[i].getZ())) {
                k = i;
                return k;
            }
        }
        return k;
    }

    //сумма всех векторов массива
    public Vector3D summarize () {
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;

        for (Vector3D vector3D : vectorArray) {
            x += vector3D.getX();
            y += vector3D.getY();
            z += vector3D.getZ();
        }
        return new Vector3D(x, y, z);
    }

    //вычисление линейной комбинации векторов
    public Vector3D linearComb ( double[] c ) throws Exception {
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;

        if ( c.length != vectorArray.length ){
            throw new Exception();
        } else {
            for (int i = 0; i < vectorArray.length; i++) {
                x += c[i] * vectorArray[i].getX();
                y += c[i] * vectorArray[i].getY();
                z += c[i] * vectorArray[i].getZ();
            }
        }
        return new Vector3D(x, y, z);
    }

    //массив из точек, сдвинутых на заданный вектор
    public Point3D[] shiftPoint ( Point3D P ){
        double pointX, pointY, pointZ;
        Point3D[] pointArr = new Point3D[vectorArray.length];
        for (int i = 0; i < vectorArray.length; i++) {
            pointX = P.getX() + vectorArray[i].getX();
            pointY = P.getY() + vectorArray[i].getY();
            pointZ = P.getZ() + vectorArray[i].getZ();
            pointArr[i] = new Point3D( pointX, pointY, pointZ );
        }
        return pointArr;
    }

}

    public String printXYZ () {
        String strX = Double.toString(x);
        String strY = Double.toString(y);
        String strZ = Double.toString(z);
        return "(" + strX + ", " + strY + ", " + strZ + ")";
    }
