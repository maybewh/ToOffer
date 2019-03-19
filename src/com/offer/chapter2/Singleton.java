package com.offer.chapter2;

/**
 * 写一个多线程下的单例模式
 * 扩展：定义一个总统类，可以从该类继承出FrenchPresident和AmericanPresident
 * @author admin
 *
 */
public class Singleton {
	//使用饿汉模式,能保证线程安全
	private static Entity entity = new Entity();
	
	private Singleton() {}
	
	public static Entity getInstance() {
		return entity;
	}
}
