package com.pks.movie.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	public int addUser(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("nickname") String nickname
			, @Param("email") String email);
	
}
