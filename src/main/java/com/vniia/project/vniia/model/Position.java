package com.vniia.project.vniia.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "position")
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String number;
	private String name;
	private float amount;
	@JoinColumn(name = "document_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Document document;
}