
/**
 * Write a description of class Acesso here.
 * 
 * @author (Gian Carlo) 
 * @version (2018/02/23)
 */
public class Acceso
{
    // instance variables
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;

    /**
     * Constructor de los objetos de la clase Acesso
     */
    public Acceso(int ano, int mes, int dia, int hora, int minutos)
    {
        // initialise instance variables
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minutos = minutos;
    }

    /**
     * Metodo para devolver la hora de acceso
     */
    public int horaAcesso()
    {
        return hora;
    }
}
