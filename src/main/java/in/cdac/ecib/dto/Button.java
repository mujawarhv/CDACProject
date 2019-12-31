package in.cdac.ecib.dto;

public class Button {
	
	public boolean preliminary_scrutiny;
	public boolean office_note;
	public boolean recommendation;
	public boolean decision;
	
	public void setPreliminary_scrutiny(boolean preliminary_scrutiny) {
		this.preliminary_scrutiny = preliminary_scrutiny;
	}
	public void setOffice_note(boolean office_note) {
		this.office_note = office_note;
	}
	public void setRecommendation(boolean recommendation) {
		this.recommendation = recommendation;
	}
	public void setDecision(boolean decision) {
		this.decision = decision;
	}
	public boolean isPreliminary_scrutiny() {
		return preliminary_scrutiny;
	}
	public boolean isOffice_note() {
		return office_note;
	}
	public boolean isRecommendation() {
		return recommendation;
	}
	public boolean isDecision() {
		return decision;
	}
	
	
}
