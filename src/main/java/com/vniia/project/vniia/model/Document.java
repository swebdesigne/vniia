package com.vniia.project.vniia.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "document")
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String number;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	private float amount;
	private String note;
	@ToString.Exclude
	@OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
	private List<Position> positions = new ArrayList<>();
}
