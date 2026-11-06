# Interpolación: Lagrange vs. Diferencias Divididas de Newton

Práctica de la asignatura **SCC-1017 Métodos Numéricos** (Instituto Tecnológico Superior de Xalapa, Ingeniería en Sistemas Computacionales).

El proyecto implementa en Java dos métodos de interpolación polinomial y compara sus resultados sobre un mismo conjunto de nodos:

- **Diferencias Divididas de Newton** (código base proporcionado por el docente).
- **Polinomio de Lagrange** (clase completada por el alumno).

El código de Newton proviene del [repositorio oficial de la asignatura](https://github.com/victorvasher/M-todos-N-mericos-ITSX/tree/main/Interpolaci%C3%B3n).

## Estructura del proyecto

```
src/
└── Interpolacion/
    ├── InterpolacionNewton.java    # Diferencias divididas de Newton (sin modificar)
    ├── InterpolacionLagrange.java  # Lagrange: línea de la productoria L_i(x) completada
    └── Main.java                   # Ejecuta ambos métodos y compara resultados
```

## Requerimientos del entorno

- JDK 17 o superior.
- Desarrollado en IntelliJ IDEA con OpenJDK 26.
- No requiere librerías externas.

## Compilación y ejecución

Desde la carpeta raíz del repositorio:

```
javac -encoding UTF-8 -d out src/Interpolacion/*.java
java -cp out Interpolacion.Main
```

También puede abrirse la carpeta en IntelliJ IDEA y ejecutar la clase `Main`.

## Datos de prueba

| Nodo | x | y |
|---|---|---|
| 0 | 0.0 | 1.0 |
| 1 | 1.0 | 3.0 |
| 2 | 3.0 | 2.0 |
| 3 | 4.0 | 5.0 |

Punto de evaluación: **x = 2.0**

## Resultado esperado

```
--- TABLA DE DIFERENCIAS DIVIDIDAS ---
x_i	f[x_i]	Orden 1	Orden 2	Orden 3
-----------------------------------------------------
0.00	1.0000	2.0000	-0.8333	0.5000
1.00	3.0000	-0.5000	1.1667
3.00	2.0000	3.0000
4.00	5.0000

Newton:   P(2.00) = 2.3333
Lagrange: P(2.00) = 2.3333
```

## Cambio realizado en Lagrange

En `InterpolacionLagrange.java` se sustituyó la línea incompleta `termino *= 0.0;` por la productoria del polinomio base:

```java
termino *= (xEval - x[j]) / (x[i] - x[j]);
```

## Autor

Victor Ruiz Ruiz
