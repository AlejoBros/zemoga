package com.alejobrosxd.zemoga.core.repo;

import com.alejobrosxd.zemoga.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

}
