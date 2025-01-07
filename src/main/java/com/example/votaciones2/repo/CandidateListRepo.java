package com.example.votaciones2.repo;

import com.example.votaciones2.models.CandidateList;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateListRepo extends IGenericRepo<CandidateList, Integer> {
}
