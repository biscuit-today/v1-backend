package com.pt.biscuIT.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MemberSubmission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberSubmissionId;
	@ManyToOne
	private Member member;
	@ManyToOne
	private Quiz quiz;
	private Boolean isCorrect;
}
