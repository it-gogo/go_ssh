package com.sb.exception;

public class ALLRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	public BxunException(){
//		super();
//	}
	
	public ALLRuntimeException(String message){
		super(message);
	}
	
	public ALLRuntimeException(String message,Throwable throwable){
		super(message,throwable);
	}
	
	public ALLRuntimeException(Throwable throwable){
		super(throwable);
		throwable.printStackTrace();
	}
	
}
