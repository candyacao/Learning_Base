package ex.md04;

public class Classroom {
	public Teacher teacher;						//保存教师	
	public Student[] students = new Student[40];//保存学生
	public int index = 0;						//保存学生数量

	public Teacher getTeacher(){
		//返回教室中的教师
		return teacher;
	}

	public Student[] getStudents(){
		//返回所有的学生
		return getStudents();
		
	}

	public void setTeacher(Teacher tea){
		//更换教师
		
	}

	public void addStudent(Student stu){
		//增加学生
		
	}

	public boolean removeStudent(int idx){
		return false;
		//删除学生
		
	}

	public int getStudentNum(){
		return index;
		//返回教室中学生的数量
		
	}

	public void print(){
		//输出当前教室中的教师和学生的信息
		
	}

}
