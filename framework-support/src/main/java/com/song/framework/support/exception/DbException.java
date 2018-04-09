package com.song.framework.support.exception;

public class DbException extends RuntimeException{

	private static final long serialVersionUID = -8988319509437181569L;

	/**
	 * 数据库操作,insert返回0
	 */
	public static final DbException DB_INSERT_RESULT_NULL = new DbException("901001", "数据库操作,insert返回主键为空");

	/**
	 * 数据库操作,update返回0
	 */
	public static final DbException DB_UPDATE_RESULT_0 = new DbException("901002", "数据库操作,update返回0");
	
	/**
     * 数据库操作,delete返回0
     */
    public static final DbException DB_DELETE_RESULT_0 = new DbException("901003", "数据库操作,delete返回0");

	protected String code;
	protected String msg;

	public DbException(String code , String msg , Object... obj) {
		super(String.format(msg, obj));
		this.code = code;
		this.msg = String.format(msg, obj);
	}
	
	public DbException(String msg ,Throwable e) {
		super(msg , e);
		this.msg = msg;
	}
	
	public DbException(String msg) {
		super(msg );
	}
	
	public DbException(Throwable e) {
		super( e);
	}
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}

}
