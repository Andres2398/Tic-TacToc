package ejercicioGrupo;

public class HiloGrupos extends Thread {
	private int miTurno;
	private static int turno = 1; // 1=Tics, 2=Tacs, 3=Tocs
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
				if (miTurno == 1 && turno == 1 && !ticsEscrito) {
					System.out.println(getThreadGroup().getName() + " -> " + getName());
					ticsEscrito = true;
					turno = 2;
					tacsEscrito = false;
					turnoEscrito = true;

				} else if (miTurno == 2 && turno == 2 && !tacsEscrito) {
					System.out.println(getThreadGroup().getName() + " -> " + getName());
					tacsEscrito = true;
					turno = 3;
					tocsEscrito = false;
					turnoEscrito = true;
				} else if (miTurno == 3 && turno == 3 && !tocsEscrito) {
					System.out.println(getThreadGroup().getName() + " -> " + getName());
					tocsEscrito = true;
					turno = 1;
					ticsEscrito = false;
					turnoEscrito = true;
				}

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}
	}
}
