package assignment2.beans;

import assignment2.dao.CandidateDao;
import assignment2.dao.CandidateDaoImpl;
import assignment2.pojo.Candidate;

public class EditCandidate {
	private int candidateId;
	private Candidate candidate;

	public EditCandidate() {
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public void editCandidate() {

		try(CandidateDao candDao=new CandidateDaoImpl()){
			candidate=candDao.findById(candidateId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
}
