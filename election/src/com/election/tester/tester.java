package com.election.tester;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.election.Dao.CandidateDao;
import com.election.entity.Candidate;

public class tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("1. See all the list of candidate ");
		System.out.println("2. Update candiadate by id");
		System.out.println("3. Add candidate");
		
		System.out.println("Enter a choice :");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			try {
				CandidateDao candidateDao = new CandidateDao();
				List<Candidate> candidateList = candidateDao.findAll();
				for (Candidate candidate : candidateList) {
					System.out.println(candidate.toString());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				CandidateDao candidateDao = new CandidateDao();
				Candidate candidate = new Candidate();
				System.out.println("Enter candidate name : ");
				candidate.setName(sc.next());
				System.out.println("Enter candidate party : ");
				candidate.setParty(sc.next());
				System.out.println("Enter votes of Candidate : ");
				candidate.setVotes(sc.nextInt());
				int result = candidateDao.update(candidate);

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				CandidateDao candidateDao = new CandidateDao();
				Candidate candidate = new Candidate();
				System.out.println("Enter candidate name : ");
				candidate.setName(sc.next());
				System.out.println("Enter candidate party : ");
				candidate.setParty(sc.next());
				System.out.println("Enter votes of Candidate : ");
				candidate.setVotes(sc.nextInt());
				int result = candidateDao.save(candidate);
				if(result>0) {
					System.out.println("candidate is Added Successfully!");
				}
				else
					System.out.println("somthing went wrong");
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}
}
