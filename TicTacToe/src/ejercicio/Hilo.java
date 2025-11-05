package ejercicio;

public class Hilo extends Thread {
    private static int turno = 1;  
    private int miTurno;
    
    
    public Hilo(String nombre, int miTurno) {
        this.setName(nombre);
        this.miTurno = miTurno;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) { 
            while (turno != miTurno) {
                try {
                   
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

          
            System.out.println(getName());

           
            if (turno == 1)
                turno = 2;
            else if (turno == 2)
                turno = 3;
            else
                turno = 1;

           
           
        }
    }

    public static void main(String[] args) {
        Hilo tic = new Hilo("tic", 1);
        Hilo tac = new Hilo("tac", 2);
        Hilo toc = new Hilo("toc", 3);

        tic.start();
        tac.start();
        toc.start();
    }
}
