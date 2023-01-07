package com.auditoria.envers.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table
@Audited
@AuditTable(value = "Cliente_audit")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, length = 50)
	private String nome;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate dataNascimento;

}
