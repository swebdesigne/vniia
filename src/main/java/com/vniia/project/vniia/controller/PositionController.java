package com.vniia.project.vniia.controller;

import com.vniia.project.vniia.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping(value = "/position")
@Controller
public class PositionController {
	private final PositionService positionService;

	@GetMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		var isDeleted = !positionService.deleteById(id);
		return ResponseEntity.ok(isDeleted);
	}

}
