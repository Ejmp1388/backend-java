import interfaces.Comparador;
import interfaces.Convertidor;
import interfaces.Operador;
import interfaces.Saludador;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Saludador
        Saludador saludador =()->System.out.println("Buenas tardes");
        saludador.saludar();

        //Operador
        Operador suma=(x, y)-> x+y;
        int resultSuma = suma.operar(4,5);
        System.out.println("La respuesta es: "+ resultSuma);

        Operador producto =(x,y)->x*y;
        System.out.println("Mulplicación: "+producto.operar(5,5));

        //Comparador
        //Comparador<Integer> comparador=(Integer x, Integer y)->


        //Convertidor
        Convertidor<String, Integer> contadorCaracteres =(s)->s.length();
        Integer cantidadCaracteres = contadorCaracteres.convertir("Carlos");
        System.out.println("Cantidad de caracteres: "+cantidadCaracteres);
    }
}