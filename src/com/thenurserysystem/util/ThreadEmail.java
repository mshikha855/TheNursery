package com.thenurserysystem.util;

import com.thenurserysystem.bean.SendEmail;
import com.thenurserysystem.bean.User;

public class ThreadEmail implements Runnable {

	
	String sendemail=null;
	String msg=null;
	public void Send(String email,String message)
	{
		sendemail=email;
		msg=message;
	}
	User u = new User();

	@Override
	public void run() {
		try {
			SendEmail s = new SendEmail();
			String mail = sendemail;
			s.sendmail(mail, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
