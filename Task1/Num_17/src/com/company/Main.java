package com.company;

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

    public void Point3D(double x1, double y1, double z1, double x2, double y2, double z2, String v_name)
    {
        x = x2 - x1;
        y = y2 - y1;
        z = z2 - z1;
        name = v_name;
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

    public void vectorSumDiff(Object v)
    {
        Vector3DProcessor vector = (Vector3DProcessor) v;
        double x_sum, y_sum, z_sum, x_diff, y_diff, z_diff;
        x_sum = getX() + vector.getX();
        y_sum = getY() + vector.getY();
        z_sum = getZ() + vector.getZ();
        x_diff = getX() - vector.getX();
        y_diff = getY() - vector.getY();
        z_diff = getZ() - vector.getZ();
        System.out.println("Sum vector = (" + x_sum + ", " + y_sum + ", " + z_sum + ")");
        System.out.println("Difference vector = (" + x_diff + ", " + y_diff + ", " + z_diff + ")");
    }

    public void scalarProduct(Object v)
    {
        Vector3DProcessor vector = (Vector3DProcessor) v;
        double x_prod, y_prod, z_prod, xyz_prod;
        x_prod = getX() * vector.getX();
        y_prod = getY() * vector.getY();
        z_prod = getZ() * vector.getZ();
        xyz_prod = x_prod + y_prod + z_prod;
        System.out.println("Scalar Product of vectors: " + xyz_prod);
    }

    public void vectorProduct(Object v)
    {
        Vector3DProcessor vector = (Vector3DProcessor) v;
        double x_v, y_v, z_v;
        x_v = getY() * vector.getZ() - getZ() * vector.getY();
        y_v = getZ() * vector.getX() - getX() * vector.getZ();
        z_v = getX() * vector.getZ() - getY() * vector.getX();
        System.out.println("Vector Product = (" + x_v + ", " + y_v + ", " + z_v + ")");
    }

    public void collinearVector(Object v)
    {
        Vector3DProcessor vector = (Vector3DProcessor) v;
        if((getX() / vector.getX() != getY() / vector.getY()) && (getY() / vector.getY() != getZ() / vector.getZ())) {
            System.out.println("Vectors aren't collinear!");
        }
        else {System.out.println("Vectors are collinear!");}
    }
}
public class Main {

    public static void main(String[] args) {

        Vector3DProcessor vector1 = new Vector3DProcessor(1,4,6,"Vector1");
        Vector3DProcessor vector2 = new Vector3DProcessor(2,8,12,"Vector2");
        //Vector3DProcessor vector2 = new Vector3DProcessor();
        //vector2.Point3D(3, 4, 5, 0, 0, 0, "Vector2");

        vector1.print();
        vector2.print();
        vector1.vectorSumDiff(vector2);
        vector1.scalarProduct(vector2);
        vector1.vectorProduct(vector2);
        vector1.collinearVector(vector2);
    }
}
