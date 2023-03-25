package com.pks.movie.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pks.movie.common.EncryptUtils;
import com.pks.movie.user.dao.UserDAO;
import com.pks.movie.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	public int addUser(
			String loginId
			, String password
			, String nickname
			, String email
			) {
		String encryptPassword = EncryptUtils.md5(password);
		return userDAO.addUser(loginId, encryptPassword, nickname, email);
	}
	
	public boolean duplicateId(String loginId) {
		int count = userDAO.selectCountByLoginId(loginId);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public User getUser(
			String loginId
			, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.selectUser(loginId, encryptPassword);
	}
	

	
}
