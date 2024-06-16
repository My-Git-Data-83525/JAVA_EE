package assignment2.beans;

import assignment2.dao.CandidateDao;
import assignment2.dao.CandidateDaoImpl;
import assignment2.pojo.Candidate;

public class UpdateBean {
	private int id;
	private String name;
	private String party;
	private int votes;

	public UpdateBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}
	public void UpdateCandidate() {
		Candidate candidate=new Candidate(id,name,party,votes);
		try(CandidateDao candDao=new CandidateDaoImpl()){
		candDao.update(candidate);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
