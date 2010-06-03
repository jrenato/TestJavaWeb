package br.com.radar.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class HibernatePhaseListener implements PhaseListener {
	private static final long serialVersionUID = -3365408826627157586L;

	@Override
	public void afterPhase(PhaseEvent event) {
		try {
			HibernateUtil.commitTransaction();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
