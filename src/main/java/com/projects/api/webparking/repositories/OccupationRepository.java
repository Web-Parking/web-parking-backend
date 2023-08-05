package com.projects.api.webparking.repositories;

import com.projects.api.webparking.entities.Occupation;
import com.projects.api.webparking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface OccupationRepository extends JpaRepository<Occupation, String> {
	Optional<Occupation> findByCode(String code);
	@Modifying
	@Query("update Occupation o set o.status = :status where o.code = :code")
	int updateOccupationSetStatusForCode(@Param("status") Occupation.OccupationStatus status,
										 @Param("code") String code);

	@Query(value = "select * from occupations o where o.user_id = :userId order by created_at desc limit 1", nativeQuery = true)
	Optional<Occupation> findLastOccupationByUserId(String userId);
}
