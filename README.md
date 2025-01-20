### Estructuras No Lineales – Ejercicios con Árboles  

#### Resumen del Proyecto  
Este proyecto se centra en implementar cuatro ejercicios prácticos relacionados con árboles binarios, con el propósito de fortalecer el entendimiento de estructuras de datos no lineales y su manejo en el lenguaje Java.

---

#### **Ejercicio 1: Inserción en un Árbol Binario de Búsqueda (BST)**  
El objetivo es implementar un algoritmo que permita insertar valores en un Árbol Binario de Búsqueda (BST). Este tipo de árbol sigue la regla básica: los valores menores que la raíz se colocan a la izquierda, mientras que los mayores van a la derecha.  
- **Entrada de ejemplo:** `[5, 3, 7, 2, 4, 6, 8]`  
- **Árbol resultante:**  
  ```
      5
   3     7
  2 4   6 8
  ```

---

#### **Ejercicio 2: Inversión de un Árbol Binario**  
En este ejercicio, se invierte un árbol binario intercambiando las ramas izquierda y derecha de cada nodo.  
- **Ejemplo de entrada:**  
  ```
      4
   2     7
  1 3   6 9
  ```  
- **Salida esperada (árbol invertido):**  
  ```
      4
   7     2
  9 6   3 1
  ```

---

#### **Ejercicio 3: Listar Niveles del Árbol en Listas Enlazadas**  
El propósito de este ejercicio es devolver cada nivel del árbol binario como una lista enlazada.  
- **Árbol de entrada:**  
  ```
      4
   2     7
  1 3   6 9
  ```  
- **Salida esperada:**  
  ```
  Nivel 0: 4  
  Nivel 1: 2 -> 7  
  Nivel 2: 1 -> 3 -> 6 -> 9
  ```

---

#### **Ejercicio 4: Cálculo de la Profundidad Máxima**  
Este ejercicio calcula la máxima profundidad de un árbol binario, que es la cantidad de niveles desde la raíz hasta el nodo más profundo.  
- **Árbol de entrada:**  
  ```
      4
   2     7
  1 3     8
  ```  
- **Salida esperada:**  
  La profundidad máxima es **3**. (*En el PDF parece indicar 4, pero quizás hay una confusión al considerar los niveles o los nodos.*)

---

#### **Instrucciones para Ejecutar el Proyecto**  
1. Compila y ejecuta el archivo principal `App.java`.  
2. Descomenta el método que corresponda al ejercicio que deseas probar:  
   - `runEjercicio1()` para insertar en un BST.  
   - `runEjercicio2()` para invertir un árbol binario.  
   - `runEjercicio3()` para listar niveles.  
   - `runEjercicio4()` para calcular la profundidad máxima.  

---

#### **Conclusión**  
Estos ejercicios ofrecen una oportunidad práctica para trabajar con árboles binarios, abarcando aspectos como la inserción, la inversión, el recorrido por niveles y el análisis de profundidad. Al realizarlos, podrás desarrollar una comprensión sólida de las estructuras de datos no lineales y cómo implementarlas de manera eficiente en Java.
