package com.tutorialspoint.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport{
   private String name;

   public static class MyAction extends ActionSupport{
	      public static String GOOD = SUCCESS;
	      public static String BAD = ERROR;
	   }

	   public class HelloWorld extends ActionSupport{
	      public String execute()
	      {
	         if ("SECRET".equals(name)) return MyAction.GOOD;
	         return MyAction.BAD;
	      }
	   }

	   public class SomeOtherClass extends ActionSupport{
	      public String execute()
	      {
	         return MyAction.GOOD;
	      }
	   }
}