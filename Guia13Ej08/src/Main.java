//class Uno {
//    private static int metodo1() {
//        int valor = 0;
//        try {
//            valor = valor + 1;
//            valor = valor + Integer.parseInt("42");
//            valor = valor + 1;
//            System.out.println("Valor final del try:" + valor);
//        } catch (NumberFormatException e) {
//            valor = valor + Integer.parseInt("42");
//            System.out.println("Valor final del catch:" + valor);
//        } finally {
//            valor = valor + 1;
//            System.out.println("Valor final del finally: " + valor);
//        }
//        valor = valor + 1;
//        System.out.println("Valor antes del return: " + valor);
//        return valor;
//    }
//    public static void main(String[] args) {
//
//        System.out.println("Clase 1");
//        try {
//            System.out.println(metodo1());
//        } catch (Exception e) {
//            System.err.println("Excepcion en metodo() ");
//            e.printStackTrace();
//        }
//    }
//}

//class Dos {
//    private static int metodo2() {
//        int valor = 0;
//        try {
//            valor = valor + 1;
//            valor = valor + Integer.parseInt("W");
//            valor = valor + 1;
//            System.out.println("Valor final del try: " + valor);
//        } catch (NumberFormatException e) {
//            valor = valor + Integer.parseInt("42");
//            System.out.println("Valor final del catch: " + valor);
//        } finally {
//            valor = valor + 1;
//            System.out.println("Valor final del finally: " + valor);
//        }
//        valor = valor + 1;
//        System.out.println("Valor antes del return: " + valor);
//        return valor;
//    }
//
//    public static void main(String[] args) {
//
//        System.out.println("Clase 2");
//
//        try {
//            System.out.println(metodo2());
//        } catch (Exception e) {
//            System.err.println(" Excepcion en metodo ( ) ");
//            e.printStackTrace();
//        }
//    }
//}


class Tres {
    private static int metodo3() {
        int valor = 0;
        try {
            valor = valor + 1;
            valor = valor + Integer.parseInt("W");
            valor = valor + 1;
            System.out.println("Valor final del try: " + valor);
        } catch (NumberFormatException e) {
            valor = valor + Integer.parseInt("W");
            System.out.println("Valor final del catch: " + valor);
        } finally {
            valor = valor + 1;
            System.out.println("Valor final del finally:" + valor);
        }
        valor = valor + 1;
        System.out.println("Valor antes del return: " + valor);
        return valor;
    }

    public static void main(String[] args) {

        System.out.println("Clase 3");
        try {
            System.out.println(metodo3());
        } catch (Exception e) {
            System.out.println("Excepcion en metodo ( ) ");  // err es para verlo en rojo
//            e.printStackTrace();
        }
    }
}