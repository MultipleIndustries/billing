package com.multiple.common.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class PasswordHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="PassHis_SEQ")
	@SequenceGenerator(name = "PassHis_SEQ", sequenceName = "PassHis_SEQ", allocationSize = 1, initialValue = 1)
	private Long id;

}
