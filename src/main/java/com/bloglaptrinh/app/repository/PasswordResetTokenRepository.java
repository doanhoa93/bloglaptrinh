package com.bloglaptrinh.app.repository;

import com.bloglaptrinh.app.domain.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, String> {

	PasswordResetToken findOneByToken(@Param("token") String token);
}
