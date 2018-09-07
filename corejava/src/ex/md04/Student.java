package ex.md04;

public class Student {
	public int id;
	public String name;
	public int age;

	public void print(){
		System.out.println("------ Student ------");
		System.out.println("id:" + id);
		System.out.println("name:" + name);
		System.out.println("age:" + age);
	}

	public Student(int sId, String sName, int sAge){
		id = sId;
		name = sName;
		age = sAge;
	}

}
