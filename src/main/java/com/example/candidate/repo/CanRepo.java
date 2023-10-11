package com.example.candidate.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.candidate.entity.Candidate;

public interface CanRepo extends JpaRepository<Candidate, Integer>{

}
