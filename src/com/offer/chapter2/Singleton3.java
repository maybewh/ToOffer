package com.offer.chapter2;

import java.io.ObjectStreamException;
import java.io.Serializable;

//���л��µĵ���ģʽ
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
	
	//�÷����ڷ����л�ʱ�����ã��÷������ǽӿڶ���ķ���
	protected Object readResolve() throws ObjectStreamException{
		System.out.println("����readResolve����");
		return Entity.instance;
	}
	
}
