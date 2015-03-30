package com.sb.exception;


/**
 * 系统异常异常
 * @author Administrator
 *
 */
public class ALLException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	public BxunException(){
//		super();
//	}
	
	public ALLException(String message){
		super(message);
	}
	
	public ALLException(String message,Throwable throwable){
		super(message,throwable);
	}
	
	public ALLException(Throwable throwable){
		super(throwable);
	}
	
	
}
