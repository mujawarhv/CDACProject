package in.cdac.ecib.dto;

public class Button {
	
	public String isrn_id;
	public boolean prelim_status;
	public boolean office_note_status;
	public boolean reco_status;
	public boolean decision_status;
	
	public String getIsrn_id() {
		return isrn_id;
	}
	
	public void setIsrn_id(String isrn_id) {
		this.isrn_id = isrn_id;
	}
	
	public boolean isPrelim_status() {
		return prelim_status;
	}
	
	public void setPrelim_status(boolean prelim_status) {
		this.prelim_status = prelim_status;
	}
	
	public boolean isOffice_note_status() {
		return office_note_status;
	}
	
	public void setOffice_note_status(boolean office_note_status) {
		this.office_note_status = office_note_status;
	}
	
	public boolean isReco_status() {
		return reco_status;
	}
	
	public void setReco_status(boolean reco_status) {
		this.reco_status = reco_status;
	}
	
	public boolean isDecision_status() {
		return decision_status;
	}
	
	public void setDecision_status(boolean decision_status) {
		this.decision_status = decision_status;
	}
	
}
