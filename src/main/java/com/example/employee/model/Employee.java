package com.example.employee.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.backend.rest.serializer.LocalDateDeserializer;
import com.example.backend.rest.serializer.LocalDateSerializer;
import com.example.backend.rest.serializer.LocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@Table(name="WWV_DEMO_EMP")
public class Employee implements Serializable {
	private static final long serialVersionUID = -6734032803176750193L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMPNO")
	private Long id;
	
	@Column(name="ENAME")
	private String name;
	
	@Column(name="JOB")
	private String job;
	
	@Column(name="MGR")
	private String mgr;
	
	@Column(name="HIREDATE")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate hireDate;
	
	@Column(name="SAL")
	private BigDecimal salary;
	
	@Column(name="COMM")
	private BigDecimal comm;
	
	@Column(name="DEPTNO")
	private Integer departmentNo;
	
	@Column(name="WORK_CITY")
	private String workCity;
	
	@Column(name="WORK_COUNTRY")
	private String workCountry;
	
	public Employee() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public BigDecimal getComm() {
		return comm;
	}

	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}

	public Integer getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(Integer departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

	public String getWorkCountry() {
		return workCountry;
	}

	public void setWorkCountry(String workCountry) {
		this.workCountry = workCountry;
	}
	
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", job=" + job + ", mgr=" + mgr + ", hireDate=" + hireDate
				+ ", salary=" + salary + ", comm=" + comm + ", departmentNo=" + departmentNo + ", workCity=" + workCity
				+ ", workCountry=" + workCountry + "]";
	}
	
}
