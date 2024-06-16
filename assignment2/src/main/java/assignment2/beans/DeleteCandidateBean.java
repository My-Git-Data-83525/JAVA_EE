package assignment2.beans;

import assignment2.dao.CandidateDao;
import assignment2.dao.CandidateDaoImpl;

public class DeleteCandidateBean {
private int candidateId;
public DeleteCandidateBean() {
}
public int getCandidateId() {
	return candidateId;
}

public void setCandidateId(int candidateId) {
	this.candidateId = candidateId;
}
public void DeleteCandidate() {
	try(CandidateDao candDao=new CandidateDaoImpl()){
		candDao.deleteById(candidateId);
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
