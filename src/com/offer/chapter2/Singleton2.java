package com.offer.chapter2;

/**
 *  懒汉模式--保证线程安全--内部类
 * @author admin
 *
 */
public class Singleton2 {
	
	private static class Entity{
		private static Entity instance = new Entity();
	}
	
	private Singleton2() {}
	
	public static Entity getInstance() {
		return Entity.instance;
	}
}
