package com.offer.chapter2;

/**
 * дһ�����߳��µĵ���ģʽ
 * ��չ������һ����ͳ�࣬���ԴӸ���̳г�FrenchPresident��AmericanPresident
 * @author admin
 *
 */
public class Singleton {
	//ʹ�ö���ģʽ,�ܱ�֤�̰߳�ȫ
	private static Entity entity = new Entity();
	
	private Singleton() {}
	
	public static Entity getInstance() {
		return entity;
	}
}
