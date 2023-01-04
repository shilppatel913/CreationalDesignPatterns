package com.design.creational;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class test {

	public static void main(String args[]) throws Exception {
		DatabaseConnector db1=DatabaseConnector.getInstance("localhost:3306","Shilp","Sql@1234");
		System.out.println(db1);
		
		DatabaseConnector db2=DatabaseConnector.getInstance("localhost:3307","Isha","Isha@1234");
		
		/**same object gets returned **/
		System.out.println(db2);
		
		DatabaseConnector db3=null;
		Constructor[] constructors=DatabaseConnector.class.getDeclaredConstructors();
		
		for(Constructor constructor:constructors) {
			constructor.setAccessible(true);
			/**Exception will occur while creating this object **/
			db3=(DatabaseConnector) constructor.newInstance("localhost:3307","Isha","Isha@1234");
			break;
		}
		System.out.println(db3);
		
	}
}
