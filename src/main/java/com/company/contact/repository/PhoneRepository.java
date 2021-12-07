package com.company.contact.repository;

import com.company.contact.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {


    @Modifying
    @Query(value =
            " delete from contact_phones where phones_id=:id; delete from contact_phones where phones_id=:id; ", nativeQuery = true)
    void deletePhoneById(@Param("id") int id);


}
