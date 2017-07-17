package com.zhbit.car.service.core.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * 基础异常类
 * 
 * @author lz
 *
 */
public class BaseException extends NestedRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1412085389887154939L;

	/**
	 * 自定义异常编码
	 */
	private String errCode;

	public BaseException(String message) {
		super(message);
	}

	public BaseException(String errCode, String message) {
		super(message);
		this.errCode = errCode;
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 获取异常编码
	 * 
	 * @return errCode 异常编码
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * 设置异常编码
	 * 
	 * @param errCode
	 *            异常编码
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

}