package com.candyacao.javademo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import com.briup.day09.Test;

public class PerformanceTester {
	private static final int TIMES = 100000;
	
	public static abstract class Tester{
		private String operation;
		public Tester(String operation) {
			this.operation = operation;
		}
		public abstract void test(List<String> list);
		public String getOperation() {
			return operation;
		}
	}
	
	static Tester iterateTester = new Tester("iterate") {
		//执行迭代操作的匿名类
		@Override
		public void test(List<String> list) {
			for(int i=0;i<10;i++) {
				Iterator<String> it=list.iterator();
				while(it.hasNext()) {
					it.next();
				}
			}
		}
	};
	
	static Tester getTester = new Tester("get") {
//执行随机访问操作的匿名类
		@Override
		public void test(List<String> list) {
			for(int i=0;i<list.size();i++) {
				for(int j = 0;j<10;j++) {
					list.get(j);
				}
			}
			
		}
		
	};
	
	static Tester insertTester = new Tester("insert") {
		//执行插入操作的匿名类
		@Override
		public void test(List<String> list) {
			ListIterator<String> it = list.listIterator(list.size()/2);   //从列表的中间位置开始
			for(int i=0;i<TIMES/2;i++)
				it.add("hello");
			
		}
	};
	
	static Tester removeTester = new Tester("remove") {
		//执行删除操作的匿名类
		@Override
		public void test(List<String> list) {
			ListIterator<String> it = list.listIterator();
			while(it.hasNext()) {
				it.next();
				it.remove();
			}
		}
	};
	
	static public void testJavaArray(List<String> list) {
		Tester[] testers = {iterateTester,getTester};
		test(testers,list);
	}
	
	static public void testList(List<String> list) {
		Tester[] testers = {insertTester,iterateTester,getTester,removeTester};
		test(testers,list);
	}
	
	static public void test(Tester[] testers,List<String>list) {
		for(int i=0;i<testers.length;i++) {
			System.out.print(testers[i].getOperation()+"操作：");
			long t1 = System.currentTimeMillis();
			testers[i].test(list);
			long t2 = System.currentTimeMillis();
			System.out.print(t2-t1+"  ms");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		List<String> list = null;
		
		//测试数组
		System.out.println("---------------测试数组------------");
		String[] ss = new String[TIMES];
		Arrays.fill(ss, "hello");
		list = Arrays.asList(ss);
		testJavaArray(list);
		
		ss = new String[TIMES/2];
		Collection<String> col = Arrays.asList(ss);
		
		//测试Vector
		System.out.println("------测试Vector----------");
		list = new Vector<String>();
		list.addAll(col);
		testList(list);
		
		//测试LinkedList
		System.out.println("--------测试LinkedList----------");
		list = new LinkedList<String>();
		list.addAll(col);
		testList(list);
		
		//测试ArrayList
		System.out.println("-----------测试Array List------------");
		list = new ArrayList<String>();
		list.addAll(col);
		testList(list);
	}
}
