package com.TeamDre.AnimalAdoption.Repository;

import com.TeamDre.AnimalAdoption.Model.AdoptedInquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AdoptedInquiryRepository extends JpaRepository<AdoptedInquiry, Integer> {
    @Query("FROM AdoptedInquiry WHERE user_id = :id")
    public List<AdoptedInquiry> getInquiriesByUserID(@Param("id") int id);
    @Query("FROM AdoptedInquiry WHERE animal_id = :id")
    public List<AdoptedInquiry> getInquiriesByAnimalId(@Param("id") int id);
    @Query("FROM AdoptedInquiry WHERE status = :status")
    public List<AdoptedInquiry> getInquiriesByStatus(@Param("status") AdoptedInquiry.Status status);
}
