package com.offer.chapter2;

import java.io.ObjectStreamException;
import java.io.Serializable;

//序列化下的单例模式
public class Singleton3 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static class Entity{
		private static Singleton3 instance = new Singleton3();
	}
	
	private Singleton3() {}
	
	public static Singleton3 getInstance() {
		return Entity.instance;
	}
	
	//该方法在反序列化时被调用，该方法不是接口定义的方法
	protected Object readResolve() throws ObjectStreamException{
		System.out.println("调用readResolve方法");
		return Entity.instance;
	}
	
}
