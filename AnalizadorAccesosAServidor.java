import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Write a description of class AnalizadorAccesosAServidor here.
 * 
 * @author (Gian Carlo) 
 * @version (2018/02/23)
 */
public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> datos;

    /**
     * Constructor de los objetos de la clase Acesso
     */
    public AnalizadorAccesosAServidor()
    {
        datos = new ArrayList<>(); //ArrayList del tipo Acceso donde almacenaremos los datos
    }

    /**
     * Metodo que sirve para leer los archivos log especificados
     * @param   logALeer nombre del archivo log que queremos leer
     */
    public void analizarArchivoDeLog(String logALeer)
    {
        //Lee mediante la clase Scanner un archivo externo, e introduce los datos que hay en el archivo en el ArrayList
        try {
            File archivo = new File(logALeer);
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                String[] arrayStrings = sc.nextLine().split(" ");
                datos.add(new Acceso(Integer.parseInt(arrayStrings[0]),Integer.parseInt(arrayStrings[1]),Integer.parseInt(arrayStrings[2]),
                        Integer.parseInt(arrayStrings[3]), Integer.parseInt(arrayStrings[4])));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que encuentra la hora (solo la hora, sin tener en cuenta los minutos) a la que se producen más accesos al servidor. 
     * El método muestra por pantalla dicha hora y la devuelve. 
     * Si hay empate, devuelve la hora más alta. 
     * En caso de que se invoque este método sin haberse invocado el anterior el método informa por pantalla de que no tiene datos,
     * devuelve -1 y no hace nada más.
     */
    public int obtenerHoraMasAccesos()
    {
        int horaMasAccesos = -1;
        int contadorMasAccesos = 0;
        //Comprueba si la lista tiene objetos o esta vacia
        if(datos.size() > 0){
            //Bucle en el que tomamos cada uno de los valores de la hora del dia en una variable local
            for(int i = 0; i < 24; i++){
                int horaActual= i;
                int contador = 0;
                //Busca coincidencias en el ArrayList entre el valor actual de la variable local y cada uno de los valores del ArrayList
                for(Acceso dato : datos){
                    if(dato.horaAcesso() == horaActual){
                        contador++;
                    }
                }
                //Cuando una hora tiene mas coincidencias que las anteriores, almacena los datos en variables locales
                if(contador >= contadorMasAccesos){
                    horaMasAccesos = horaActual;
                    contadorMasAccesos = contador;
                }
            }
            datos.clear(); //Importante vaciar el ArrayList al terminar
        }
        return horaMasAccesos;
    }
}
