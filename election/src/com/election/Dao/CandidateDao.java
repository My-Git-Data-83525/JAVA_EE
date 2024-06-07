package com.election.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.election.entity.Candidate;
import com.election.util.DbUtils;

public class CandidateDao {
	private Connection connection;
	
	Scanner sc=new Scanner(System.in);

	public CandidateDao() throws SQLException {
		connection = DbUtils.getConnection();
	}

	public List<Candidate> findAll() throws Exception {
		String query="select * from candidates";
		List<Candidate> candidateList=new ArrayList<Candidate>();
		try(PreparedStatement stmt=connection.prepareStatement(query)){
			ResultSet rs=stmt.executeQuery();
			System.out.println(rs.toString());
			while(rs.next()) {
				Candidate candidate=new Candidate();
				candidate.setId(rs.getInt(1));
				candidate.setName(rs.getString(2));
				candidate.setParty(rs.getNString(3));
				candidate.setVotes(rs.getInt(4));
				candidateList.add(candidate);
			}
		}
		return candidateList;

	}

	public List<Candidate> findByParty(String party) throws Exception {
		String party1="";
		System.out.println("Enter a party :");
		party1=sc.next();
		String query="select * from candidates where party=?";
		List<Candidate> candidateList=new ArrayList<Candidate>();
		try(PreparedStatement stmt=connection.prepareStatement(query)){
		stmt.setString(1, party1);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			Candidate candidate=new Candidate();
			candidate.setId(rs.getInt(1));
			candidate.setName(rs.getString(2));
			candidate.setParty(rs.getString(3));
			candidate.setVotes(rs.getInt(4));
			candidateList.add(candidate);
			
		}
		}
		return candidateList;

	}

	public List<Candidate> findAllOrderByVotesDesc() throws Exception {
		return null;
	}

	public int save(Candidate c) throws Exception {
		int votes;
		String name="",party="";
		String query="insert into candidates(name,party,votes) values(?,?,?)";
		try(PreparedStatement stmt=connection.prepareStatement(query)){
			stmt.setInt(3, c.getVotes());
			stmt.setString(2, c.getParty());
			stmt.setString(1, c.getName());
//			System.out.println(query);
			int num= stmt.executeUpdate();
			System.out.println(num);
			return num;
		}
	}

	public int deleteById(int id) throws Exception {
		int num;
		String query="delete from candidates where id=?";
		try(PreparedStatement stmt=connection.prepareStatement(query)){
			stmt.setInt(1,id);
//			System.out.println(query);
			num= stmt.executeUpdate();
			System.out.println(num);
		}
		return num;
	}

	public int update(Candidate c) throws Exception {
		int id,votes;
		String name="",party="";
		System.out.println("Enter a candidate id :");
		id=sc.nextInt();
		String query="update candidates set name=?,party=?,votes=? where id=?";
		try(PreparedStatement stmt=connection.prepareStatement(query)){
			stmt.setInt(4,id);
			stmt.setInt(3, c.getVotes());
			stmt.setString(2, c.getParty());
			stmt.setString(1, c.getName());
			System.out.println(query);
			int num= stmt.executeUpdate();
//			System.out.println(num);
			return num;
		}
	}

	public Candidate findById(int id) throws Exception {
		return null;
	}

	public int incrementVotes(int id) throws Exception {
		return 0;
	}

}
