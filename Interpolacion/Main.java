package Interpolacion;

public class Main {
    public static void main(String[] args) {
        // Nodos propios: (0, 1), (1, 3), (3, 2), (4, 5)
        double[] x = {0.0, 1.0, 3.0, 4.0};
        double[] y = {1.0, 3.0, 2.0, 5.0};

        // Punto de evaluación
        double xEval = 2.0;

        // 1. Calcular tabla de diferencias divididas llamando a la clase de interpolación
        double[][] tablaDiferencias = InterpolacionNewton.calcularDiferenciasDivididas(x, y);

        // 2. Imprimir la tabla
        InterpolacionNewton.imprimirTabla(x, tablaDiferencias);

        // 3. Mostrar los coeficientes (Diagonal superior)
        System.out.println("\n--- COEFICIENTES DEL POLINOMIO (a_k) ---");
        for (int k = 0; k < x.length; k++) {
            System.out.printf("a_%d = %.4f\n", k, tablaDiferencias[0][k]);
        }

        // 4. Evaluar con Newton en el punto xEval
        double yInterpolado = InterpolacionNewton.evaluarPolinomio(x, tablaDiferencias, xEval);

        System.out.println("\n--- RESULTADO DE LA INTERPOLACIÓN (NEWTON) ---");
        System.out.printf("El valor estimado en x = %.2f es P(%.2f) = %.4f\n", xEval, xEval, yInterpolado);

        // 5. [ACTIVIDAD DEL PDF] Evaluar con Lagrange en el mismo punto
        double yLagrange = InterpolacionLagrange.interpolacionLagrange(x, y, xEval);

        System.out.println("\n--- RESULTADO DE LA INTERPOLACIÓN (LAGRANGE) ---");
        System.out.printf("El valor estimado en x = %.2f es P(%.2f) = %.4f\n", xEval, xEval, yLagrange);

        // 6. Comparación de ambos métodos
        System.out.println("\n--- COMPARACIÓN NEWTON VS LAGRANGE ---");
        System.out.printf("Newton:   %.10f\n", yInterpolado);
        System.out.printf("Lagrange: %.10f\n", yLagrange);
        System.out.printf("Diferencia absoluta: %.3e\n", Math.abs(yInterpolado - yLagrange));
    }
}
