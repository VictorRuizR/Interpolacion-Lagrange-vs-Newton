package Interpolacion;

/**
 * Interpolación polinomial por el método de Lagrange.
 *
 * Código base proporcionado por el docente. El alumno completó únicamente
 * la línea marcada como "LÍNEA CORREGIDA" (productoria del polinomio base L_i(x)).
 */
public class InterpolacionLagrange {

    /**
     * Valida los datos de entrada antes de interpolar (código del docente, sin cambios):
     * arreglos no nulos ni vacíos, del mismo tamaño y sin nodos x repetidos.
     */
    private static void validarDatos(double[] x, double[] y) {
        if (x == null || y == null || x.length == 0 || y.length == 0) {
            throw new IllegalArgumentException("Los arreglos no pueden ser nulos ni estar vacios.");
        }
        if (x.length != y.length) {
            throw new IllegalArgumentException("Los arreglos x y y deben tener el mismo tamano.");
        }
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (x[i] == x[j]) {
                    throw new IllegalArgumentException("Nodos de x repetidos: " + x[i]);
                }
            }
        }
    }

    /**
     * Evalúa en xEval el polinomio interpolador de Lagrange:
     *
     *     P(x) = sum_{i=0}^{n-1} y_i * L_i(x)
     *     L_i(x) = prod_{j != i} (x - x_j) / (x_i - x_j)
     *
     * @param x     Arreglo con los nodos de x
     * @param y     Arreglo con los valores f(x) en cada nodo
     * @param xEval Punto donde se desea interpolar
     * @return El valor interpolado P(xEval)
     */
    public static double interpolacionLagrange(double[] x, double[] y, double xEval) {
        validarDatos(x, y);
        double resultado = 0.0;
        int n = x.length;

        for (int i = 0; i < n; i++) {
            // Se inicia con y_i; en el ciclo interno se multiplica por L_i(xEval)
            double termino = y[i];
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    // *** LÍNEA CORREGIDA (actividad solicitada en el PDF) ***
                    // Productoria de L_i(x): cada factor es (xEval - x_j) / (x_i - x_j)
                    termino *= (xEval - x[j]) / (x[i] - x[j]);
                }
            }
            // Se suma el término y_i * L_i(xEval) al polinomio
            resultado += termino;
        }
        return resultado;
    }
}
