package com.sb.exception;

import org.hibernate.HibernateException;

/**
 * 数据库访问异常
 * @author Administrator
 *
 */
public class DaoException extends HibernateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoException(Throwable root) {
		super(root);
//		root.printStackTrace();
		// TODO Auto-generated constructor stub
	}

	public DaoException(String string, Throwable root) {
		super(string, root);
		// TODO Auto-generated constructor stub
	}

	public DaoException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

}
