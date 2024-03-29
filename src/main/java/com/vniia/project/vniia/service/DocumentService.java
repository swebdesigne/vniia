package com.vniia.project.vniia.service;

import com.vniia.project.vniia.model.Document;
import com.vniia.project.vniia.model.Position;
import com.vniia.project.vniia.repository.DocumentRepository;
import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@ThreadSafe
public class DocumentService {
	private final DocumentRepository documentRepository;

	@Transactional
	public void save(Document document) {
		setAmount(document);
		document.getPositions().forEach(pos -> pos.setDocument(document));
		documentRepository.save(document);
	}

	public List<Document> findAll() {
		return documentRepository.findAll();
	}

	public Optional<Document> findById(Long id) {
		return documentRepository.findById(id);
	}

	public void delete(Long id) {
		documentRepository.deleteById(id);
	}

	public void update(Document document) {
		setAmount(document);
		document.getPositions().forEach(pos -> pos.setDocument(document));
		documentRepository.save(document);
	}

	private void setAmount(Document document) {
		var sum = (float) document.getPositions()
				.stream()
				.mapToDouble(Position::getAmount)
				.sum();
		document.setAmount(sum);
	}

	public Optional<Document> findByNumber(String number) {
		return documentRepository.findByNumber(number);
	}
}
