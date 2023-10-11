package com.example.candidate.service;

import java.util.List;

import com.example.candidate.entity.Candidate;

public interface CanSer {
	Candidate addCan(Candidate candidate);
	List<Candidate> getcans();
	String deleteCan(int id);
	String updateSal(int id,int salary);
	public List<Candidate> listAllExcel();
		
	
	

}
