package com.rockit.util;

/**
 * 
    * @ClassName: RktEnum
    * @Description: 所有枚举类型
    * @author xusw
	* @company Rockit
    * @date 2015年8月8日
    *
 */
public class RktEnum {
	/**
	 * 
	    * @ClassName: SqlType
	    * @Description: SQL语句类型：普通SQL、存储过程
	    * @author xusw
		* @company Rockit
	    * @date 2015年7月21日
	    *
	 */
	public enum SqlType{
		SQL, PROC;
	}
	
	/**
	 * 
	    * @ClassName: OS
	    * @Description: 操作系统类型
	    * @author xusw
		* @company Rockit
	    * @date 2015年7月21日
	    *
	 */
	public enum OS{
		UNIX, LINUX, WINDOWS, MAC;
	}
	
	/**
	 * 
	    * @ClassName: Sort
	    * @Description: 排序方式
	    * @author xusw
		* @company Rockit
	    * @date 2015年7月21日
	    *
	 */
	public enum Sort{
		ASC, DESC;
	}
	
	/**
	 * 
	    * @ClassName: DbType
	    * @Description: 数据库
	    * @author xusw
		* @company Rockit
	    * @date 2015年7月21日
	    *
	 */
	public enum DbType{
		ORACLE, MSSQL, MYSQL, DB2;
	}
	
	/**
	 * 
	    * @ClassName: LogType
	    * @Description: 日志类型
	    * @author xusw
		* @company Rockit
	    * @date 2015年8月8日
	    *
	 */
	public enum LogType{
		ADD,EDIT,REMOVE,DELETE;
	}

	/**
	 * 
	    * @ClassName: WebControl
	    * @Description: Web控件类型
	    * @author xusw
		* @company Rockit
	    * @date 2015年8月18日
	    *
	 */
	public enum WebControl{
		COMBO,COMBOBOX,COMBOGRID,COMBOTREE;
	}
}	
