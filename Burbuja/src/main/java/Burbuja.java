/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.JOptionPane;
import java.util.Random;

public class Burbuja {
    Random r = new Random();
    int A[];
    int N;
    static boolean v = false;

    public void TamVector() {
        String tam = JOptionPane.showInputDialog("¿De qué tamaño será el vector?");
        N = Integer.parseInt(tam);
        A = new int[N];
    }

    public void Vector() {
        v = true;
        for (int i = 0; i < N; i++) {
            String input = JOptionPane.showInputDialog("Ingrese el dato A[" + i + "]:");
            int dato = Integer.parseInt(input);
            A[i] = dato;
        }
    }

    public void VectorAleatorio() {
        v = true;
        for (int i = 0; i < N; i++) {
            A[i] = r.nextInt(100);
            System.out.println("A[" + i + "]= " + A[i]);
        }
    }

    public void BurbujaMenor() {
        int aux;
        for (int i = 1; i < N; i++) {
            for (int j = N - 1; j >= i; j--) {
                if (A[j - 1] > A[j]) {
                    aux = A[j - 1];
                    A[j - 1] = A[j];
                    A[j] = aux;
                }
            }
        }
    }

    public void BurbujaMayor() {
        int aux;
        for (int i = N - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[j + 1]) {
                    aux = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = aux;
                }
            }
        }
    }

    public void BurbujaSeñal() {
        int I = 1;
        int aux;
        boolean BAND = false;
        while ((I <= N - 1) && (BAND == false)) {
            BAND = true;
            for (int J = 0; J < N - 1; J++) {
                if (A[J] > A[J + 1]) {
                    aux = A[J];
                    A[J] = A[J + 1];
                    A[J + 1] = aux;
                    BAND = false;
                }
            }
            I = I + 1;
        }
    }

    public void BurbujaShakerShort() {
        int IZQ = 1, DER = N - 1, K = N - 1;
        int AUX;
        while (DER >= IZQ) {
            for (int I = DER; I >= IZQ; I--) {
                if (A[I - 1] > A[I]) {
                    AUX = A[I - 1];
                    A[I - 1] = A[I];
                    A[I] = AUX;
                    K = I;
                }
            }
            IZQ = K + 1;
            for (int I = IZQ; I <= DER; I++) {
                if (A[I - 1] > A[I]) {
                    AUX = A[I - 1];
                    A[I - 1] = A[I];
                    A[I] = AUX;
                    K = I;
                }
            }
            DER = K - 1;
        }
    }

    public void BurbujaInseccion() {
        int AUX;
        int K;

        for (int I = 1; I < N; I++) {
            AUX = A[I];
            K = I - 1;

            while ((K >= 0) && (AUX < A[K])) {
                A[K + 1] = A[K];
                K = K - 1;
            }

            A[K + 1] = AUX;
        }
    }

    public void imprimir() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result.append(A[i]).append(" ");
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    public static void main(String[] args) {
        Burbuja sc = new Burbuja();
        int res;
        do {
            String menu = "\nMenu" +
                    "\nMETODOS DE ORDENAMIENTO" +
                    "\n1) Llenar un vector" +
                    "\n2) Llenar aleatoriamente" +
                    "\n3) Burbuja menor" +
                    "\n4) Burbuja mayor" +
                    "\n5) Burbuja señal" +
                    "\n6) Sacudida" +
                    "\n7) Inseccion" +
                    "\n8) Salir\n";

            res = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (res) {
                case 1:
                    if (!sc.v) {
                        sc.TamVector();
                        sc.Vector();
                    } else
                        JOptionPane.showMessageDialog(null, "Ya hay un vector hecho o lleno");
                    break;
                case 2:
                    if (!sc.v) {
                        sc.TamVector();
                        sc.VectorAleatorio();
                    } else
                        JOptionPane.showMessageDialog(null, "Ya hay un vector hecho o lleno");
                    break;
                case 3:
                    sc.BurbujaMenor();
                    JOptionPane.showMessageDialog(null, "\n(BURBUJA MENOR):");
                    sc.imprimir();
                    break;
                case 4:
                    sc.BurbujaMayor();
                    JOptionPane.showMessageDialog(null, "\n(BURBUJA MAYOR):");
                    sc.imprimir();
                    break;
                case 5:
                    sc.BurbujaSeñal();
                    JOptionPane.showMessageDialog(null, "\n(BURBUJA SEÑAL):");
                    sc.imprimir();
                    break;
                case 6:
                    sc.BurbujaShakerShort();
                    JOptionPane.showMessageDialog(null, "\nArreglo ordenado (BURBUJA SACUDIDA):");
                    sc.imprimir();
                    break;
                case 7:
                    sc.BurbujaInseccion();
                    JOptionPane.showMessageDialog(null, "\n(BURBUJA Inseccion):");
                    sc.imprimir();
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "¡Ya te salistes del programa!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Escoja una de las opciones que hay en el menú");
            }
     } while (res != 8);
   }
}