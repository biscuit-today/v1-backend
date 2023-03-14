package com.pt.biscuIT.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MemberHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberHistoryId;
	@ManyToOne
	private Member member;
	@ManyToOne
	private Content content;
	private LocalDateTime createdDate;
}
