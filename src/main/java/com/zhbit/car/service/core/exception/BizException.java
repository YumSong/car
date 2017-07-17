package com.zhbit.car.service.core.exception;

/**
 * 
 * @Description:业务异常定义
 * @author lz
 * @date 2016年4月12日 下午2:03:21
 */
public class BizException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8705253478122503487L;

	public BizException(String message){
		super(message);
	}
	
	public BizException(String errCode , String message){
		super(errCode, message);
	}
	
	public BizException(String message , Throwable cause){
		super(message, cause);
	}
	
}
