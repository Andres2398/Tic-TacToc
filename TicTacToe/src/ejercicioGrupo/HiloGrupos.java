package ejercicioGrupo;

public class HiloGrupos extends Thread {
	private int miTurno;
	private static int turno = 1; // 1-->Tics, 2---->Tacs, 3--->Tocs
	private static boolean ticsEscrito = false;
	private static boolean tacsEscrito = false;
	private static boolean tocsEscrito = false;

	public HiloGrupos(ThreadGroup grupo, String nombre, int turno) {
		super(grupo, nombre);
		this.miTurno = turno;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			boolean turnoEscrito = false;
			while (!turnoEscrito) {
				//TICS
				if (miTurno == 1 && turno == 1 && !ticsEscrito) {
					// importante actualizar las variables lo primero para intentar evitar
					// que otros hilos entren
					ticsEscrito = true;
					turnoEscrito = true;
					System.out.println(getThreadGroup().getName() + " -> " + getName());
					turno = 2;
					tacsEscrito = false;
					
					//TACS
				} else if (miTurno == 2 && turno == 2 && !tacsEscrito) {
					turnoEscrito = true;
					tacsEscrito = true;
					System.out.println(getThreadGroup().getName() + " -> " + getName());
					turno = 3;
					tocsEscrito = false;
					
					
					//TOCCS
				} else if (miTurno == 3 && turno == 3 && !tocsEscrito) {
					turnoEscrito = true;
					tocsEscrito = true;
					System.out.println(getThreadGroup().getName() + " -> " + getName());
					turno = 1;
					ticsEscrito = false;
					
				}
			// Con sleep conseguimos que haya escrito o no salga de la cpu para intentar 
			// evitar que el hilo escriba cuando no le toca
			
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}
	}
	public static void main(String[] args) {
		ThreadGroup grupoTics = new ThreadGroup("Tics");
		ThreadGroup grupoTacs = new ThreadGroup("Tacs");
		ThreadGroup grupoTocs = new ThreadGroup("Tocs");

		
		for (int i = 1; i <= 3; i++) {
			new HiloGrupos(grupoTics, "Tic " + i, 1).start();
			new HiloGrupos(grupoTacs, "Tac " + i, 2).start();
			new HiloGrupos(grupoTocs, "Toc " + i, 3).start();
		}
	}
	
	
}
