package com.exception.test;
/**
 * 在这个继承了Exception类的自定义异常类中，我们定义了如下变量：
　　id：独立标示符，这个是用来进行标示类中什么地方出现了错误被捕捉到。
　　classname：捕捉到这个错误的类的名字。
　　method：捕捉到这个错误的方法的名字。
　　message：用来描述整个事件的情况。
　　previous：是MyException得一个实例，若在链表中它是第一个的话，那么它就是null。
 * @author Song Shi Chao
 *
 */
public class MyThreeException extends Exception {
	private int id; // a unique id
	private String classname; // the name of the class
	private String method; // the name of the method
	private String message; // a detailed message
	private MyThreeException previous = null; // the exception which was caught
	private String separator = "\n"; // line separator

	public MyThreeException(int id, String classname, String method, String message,
			MyThreeException previous) {
		this.id = id;
		this.classname = classname;
		this.method = method;
		this.message = message;
		this.previous = previous;
	}

	public String traceBack() {
		return traceBack("\n");
	}

	public String traceBack(String sep) {
		this.separator = sep;
		int level = 0;
		MyThreeException e = this;
		String text = line("Calling sequence (top to bottom)");
		while (e != null) {
			level++;
			text += line("--level " + level + "--------------------------------------");
			text += line("Class/Method: " + e.classname + "/" + e.method);
			text += line("Id : " + e.id);
			text += line("Message : " + e.message);
			e = e.previous;
		}
		
		return text;
	}

	private String line(String s) {
		return s + separator;
	}
}