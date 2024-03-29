package com.vniia.project.vniia.service;

import com.vniia.project.vniia.model.Position;
import com.vniia.project.vniia.repository.PositionRepository;
import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@ThreadSafe
@Service
public class PositionService {
	private final PositionRepository positionRepository;

	public boolean deleteById(Long id) {
		positionRepository.deleteById(id);
		return positionRepository.existsById(id);
	}
}
