package fr.doranco.tpjsf2.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Dates {

	public static final Date stringToDate(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static final String dateToString(Date date) {
		String dateStr = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dateStr = dateFormat.format(date);
		} catch (Exception e){
			e.printStackTrace();
		}
		return dateStr;
	}
	
	public static final String dateToStringWithPattern(Date date, String pattern) {
		String dateStr = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			dateStr = dateFormat.format(date);
		} catch (Exception e){
			e.printStackTrace();
		}
		return dateStr;
	}
	
	public static final java.util.Date dateSqlToUtil(java.sql.Date dateSql) {
		return new java.util.Date(dateSql.getTime());
	}
	
	public static final java.sql.Date dateUtilToSql(java.util.Date dateUtil) {
		return new java.sql.Date(dateUtil.getTime());
	}
	
}
