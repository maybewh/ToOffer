package com.offer.chapter2;

/**
 *  ����ģʽ--��֤�̰߳�ȫ--�ڲ���
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
