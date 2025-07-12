package com.techlabs.curd;
import java.sql.Date;

public class Employee {
	private int empno;
	private String ename;
	private String job;
	private int manager;
	private Date hiredate;
	private double sal;
	private double comm;
	private int deptno;
	
	public Employee() {}
	
	public Employee(int empno, String ename, String job, int manager, Date hiredate, double sal, double comm,
			int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.manager = manager;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", job=" + job + ", manager=" + manager + ", hiredate="
				+ hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
}
