package org.nadim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="student_tbl")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer stdId;
	private String stdName;
	private String stdGender;
	private String stdCourse;
	private String stdAddress;

}
