package com.example.candidate.serimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.candidate.entity.Candidate;
import com.example.candidate.repo.CanRepo;
import com.example.candidate.service.CanSer;
@Service
public class CanSerImpl implements CanSer {
	@Autowired
	CanRepo canrepo;

	

	@Override
	public List<Candidate> getcans() {
		// TODO Auto-generated method stub
		return canrepo.findAll();
	}

	@Override
	public String deleteCan(int id) {
		// TODO Auto-generated method stub
		 canrepo.deleteById(id);
		 return "deelted successfully";
	}

	@Override
	public String updateSal(int id, int salary) {
		// TODO Auto-generated method stub
		Candidate c =  canrepo.findById(id).get();
		c.setSalary(salary);
		canrepo.save(c);
		
		return "update successfully";
	}

	@Override
	public List<Candidate> listAllExcel() {
		
			return canrepo.findAll();

		}

	@Override
	public Candidate addCan(Candidate candidate) {
		
		return canrepo.save(candidate);
	}

	
	}


