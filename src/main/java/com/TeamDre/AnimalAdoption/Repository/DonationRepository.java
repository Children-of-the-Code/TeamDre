package com.TeamDre.AnimalAdoption.Repository;

import com.TeamDre.AnimalAdoption.Model.AdoptedInquiry;
import com.TeamDre.AnimalAdoption.Model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface DonationRepository extends JpaRepository<Donation, Integer> {
    @Query("FROM Donation WHERE user_id = :id")
    public List<Donation> getDonationsByUserId(@Param("id") int id);
    @Query("FROM Donation WHERE org_id = :id")
    public List<Donation> getDonationsByOrgId(@Param("id") int id);
}
