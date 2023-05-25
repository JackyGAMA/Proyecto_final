import java.util.Scanner;

public class CalculadoraVectores {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese las componentes del primer vector:");
        double[] vector1 = leerVector(scanner);

        System.out.println("Ingrese las componentes del segundo vector:");
        double[] vector2 = leerVector(scanner);

        double[] vectorOrtogonal = calcularVectorOrtogonal(vector1, vector2);
        double[] vectorUnitario = calcularVectorUnitario(vectorOrtogonal);

        System.out.println("El vector ortogonal es:");
        imprimirVector(vectorOrtogonal);

        System.out.println("El vector unitario es:");
        imprimirVector(vectorUnitario);
    }

    public static double[] leerVector(Scanner scanner) {
        double[] vector = new double[3];
        for (int i = 0; i < vector.length; i++) {
            System.out.print("Componente " + (i + 1) + ": ");
            vector[i] = scanner.nextDouble();
        }
        return vector;
    }

    public static double[] calcularVectorOrtogonal(double[] vector1, double[] vector2) {
        double[] vectorOrtogonal = new double[3];
        vectorOrtogonal[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1];
        vectorOrtogonal[1] = vector1[2] * vector2[0] - vector1[0] * vector2[2];
        vectorOrtogonal[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0];
        return vectorOrtogonal;
    }

    public static double[] calcularVectorUnitario(double[] vector) {
        double magnitud = Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1] + vector[2] * vector[2]);
        double[] vectorUnitario = new double[3];
        vectorUnitario[0] = vector[0] / magnitud;
        vectorUnitario[1] = vector[1] / magnitud;
        vectorUnitario[2] = vector[2] / magnitud;
        return vectorUnitario;
    }

    public static void imprimirVector(double[] vector) {
        System.out.print("(");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
            if (i < vector.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }
}
