package com.pks.movie.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pks.movie.user.model.User;

@Repository
public interface UserDAO {

	public int addUser(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("nickname") String nickname
			, @Param("email") String email);
	
	
	public int selectCountByLoginId(@Param("loginId") String loginId);	
	
	public User selectUser(
			@Param("loginId") String loginId
			, @Param("password") String password);
	
	
	public User selectUserById(@Param("userId") int userId);
	
}
