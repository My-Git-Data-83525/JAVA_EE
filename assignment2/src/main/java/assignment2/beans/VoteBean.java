package assignment2.beans;

import assignment2.dao.CandidateDao;
import assignment2.dao.CandidateDaoImpl;
import assignment2.dao.UserDao;
import assignment2.dao.UserDaoImpl;

public class VoteBean {
	private int userid;
	private int candidateid;

	public VoteBean() {
	}

	public int getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(int candidateid) {
		this.candidateid = candidateid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void checkVote() 
	{
		int i = 0;
		try (CandidateDao candDao = new CandidateDaoImpl()) 
		{
			i = candDao.incrementVote(candidateid);
			if (i > 0) 
			{
				try (UserDao userDao = new UserDaoImpl()) 
				{
					userDao.updateStatus(userid, true);
				}
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}

