package ejercicioGrupo;

public class App {



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
