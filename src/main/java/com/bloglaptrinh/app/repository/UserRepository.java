package com.bloglaptrinh.app.repository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.bloglaptrinh.app.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>, JpaSpecificationExecutor<User> {

    User findOneById(Long id);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT u FROM User u WHERE loginId = :loginId ")
    User findOneByLoginId(@Param("loginId") String loginId);
    User findOneByEmail(String email);
    List<User> findAllByIdIn(Collection<Long> ids);
    User findOneForUpdateById(Long id);
    @Modifying
    @Query("update User set lastLoginTime = :lastLoginTime where id = :id ")
    int updateLastLoginTime(@Param("id") long id, @Param("lastLoginTime") Date lastLoginTime);
}