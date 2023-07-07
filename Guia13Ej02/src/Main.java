public class Main {
    public static void main(String[] args) {

        /*
        Definir una Clase que contenga algún tipo de dato de tipo array y agregue el código para
generar y capturar una excepción ArrayIndexOutOfBoundsException (índice de arreglo fuera
de rango).
         */


        int[] numeros = new int[] {1,2,3};

        try {

            System.out.println("numeros = " + numeros[3]);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Indice fuera de arreglo");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.fillInStackTrace());
            System.out.println(e.initCause(null));
        }
    }
}