package mascota;

public class Fecha {
    private final int dia;
    private final int mes;
    private final int año;
    
    //Constructor
    public Fecha (int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    
    //Observadores
    public int getDia(){
        return this.dia;
    }
    
    public int getMes(){
        return this.mes;
    }
    
    public int getAño(){
        return this.año;
    }
    
    public int getDiasMes(int mes){
        int dias;
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
            dias = 31;
        else if ( mes == 4 || mes == 6 || mes == 9 || mes == 11) 
            dias = 30;
        else if ( mes == 2 && esBisiesto())
            dias = 29;
        else
            dias = 28;
        
        
        return dias;
    }
    
    //Propios de tipo
    public boolean esBisiesto() {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }
    
    public boolean esFechaAnterior(Fecha otraFecha) {
        boolean respuesta = false;
        
        if(this.año > otraFecha.getAño())
            respuesta = true;
        else if (this.año >= otraFecha.getAño() && this.mes > otraFecha.getMes())
            respuesta = true;
        else 
         if(this.año >= otraFecha.getAño() && this.mes >= otraFecha.getMes() && this.dia > otraFecha.getDia())   
             respuesta = true;
        return respuesta;
    }
    
    public int diasTranscurridos(Fecha unaFecha){
        int dias = 0;
        for (int i = 0; i <= unaFecha.getMes(); i++) {
            dias += getDiasMes(i);
        }
        dias += unaFecha.getDia();
        return dias;
    }
    
    public Fecha calculaFecha(Fecha unaFecha, int diasASumar) {
        int unaFechaDia = unaFecha.getDia();
        int unaFechaMes = unaFecha.getMes();
        int unaFechaAño = unaFecha.getAño();

        for (int i = 0; i < diasASumar; i++) {
            unaFechaDia++;

            if (unaFechaDia > getDiasMes(unaFechaMes)) {
                unaFechaDia = 1;
                unaFechaMes++;

                if (unaFechaMes > 12) {
                    unaFechaMes = 1;
                    unaFechaAño++;
                }
            }
        }

        return new Fecha(unaFechaDia, unaFechaMes, unaFechaAño);
    }
}
