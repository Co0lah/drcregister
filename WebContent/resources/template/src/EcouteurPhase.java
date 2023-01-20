import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class EcouteurPhase implements PhaseListener {

	private static final long serialVersionUID = 1L;

	// Méthode appelée par JSF 'APRES' une des 6 phases de JSF
	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("Phase après : " + event.getPhaseId().toString());
	}

	@Override
	// Méthode appelée par JSF 'AVANT' une des 6 phases de JSF
	public void beforePhase(PhaseEvent event) {
		System.out.println("Phase avant : " + event.getPhaseId().toString());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}

