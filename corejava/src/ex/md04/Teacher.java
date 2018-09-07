package ex.md04;

public class Teacher {
	public int id;
	public String name;
	public double salary;
	public int clRoomId;
	public int age;

	public Teacher(){}

	public Teacher(int id, String name, double salary, int clRoomId, int age){
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.clRoomId = clRoomId;
		this.age = age;
	}

	public void print(){
		System.out.println("---- Teacher ----");
		System.out.println("id:" + this.id);
		System.out.println("name:" + name);
		System.out.println("salary:" + salary);
		System.out.println("classroom id:" + clRoomId);
		System.out.println("age:" + age);
	}

}
