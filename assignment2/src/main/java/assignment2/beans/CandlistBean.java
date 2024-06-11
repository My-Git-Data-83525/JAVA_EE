package assignment2.beans;

import java.util.ArrayList;
import java.util.List;

import assignment2.dao.CandidateDao;
import assignment2.dao.CandidateDaoImpl;
import assignment2.pojo.Candidate;

public class CandlistBean {
	private List<Candidate> list;

	public CandlistBean() {
		list = new ArrayList<Candidate>();
	}

	public List<Candidate> getList() {
		return list;
	}
	
	public void setList(List<Candidate> list) {
		this.list=list;
	}

	public void candList() {

		try (CandidateDao candDao = new CandidateDaoImpl()) {
			list = candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
