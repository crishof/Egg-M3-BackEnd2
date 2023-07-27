import entidades.Armadura;
import servicios.Jarvis;

public class Main {
    public static void main(String[] args) {

        Jarvis js = new Jarvis();
        Armadura armadura = js.iniciarArmadura();

        js.iniciarSistema(armadura);
    }

}

