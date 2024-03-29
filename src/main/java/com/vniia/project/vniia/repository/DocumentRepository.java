package com.vniia.project.vniia.repository;

import com.vniia.project.vniia.model.Document;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {
	public List<Document> findAll();
	Optional<Document> findByNumber(String number);
}
