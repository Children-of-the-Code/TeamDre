package com.TeamDre.AnimalAdoption.Repository;

import com.TeamDre.AnimalAdoption.Model.AdoptedInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AdoptedInquiryRepository extends JpaRepository<AdoptedInquiry, Integer> {

}
