package com.vniia.project.vniia.controller;

import com.vniia.project.vniia.model.Document;
import com.vniia.project.vniia.model.Position;
import com.vniia.project.vniia.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller(value = "/")
public class DocumentController {
	private final DocumentService documentService;

	@GetMapping
	public String allDocuments(Model model) {
		var documents = documentService.findAll();
		model.addAttribute("documents", documents);
		documentService.findAll().stream().map(Document::getPositions).forEach(System.out::println);
		return "/document/all";
	}

	@GetMapping("/document/create")
	public String create(Model model) {
		model.addAttribute("document", new Document());
		model.addAttribute("position", new Position());
		return "/document/create";
	}

	@PostMapping("/document/add")
	public String add(@ModelAttribute("document") Document document) {
		documentService.save(document);
		return "redirect:/";
	}

	@GetMapping("/document/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		model.addAttribute("document", documentService.findById(id).get());
		return "/document/edit";
	}

	@GetMapping("/document/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		documentService.delete(id);
		return "redirect:/";
	}

	@PostMapping("/document/update")
	public String update(@ModelAttribute("document") Document document) {
		documentService.update(document);
		return "redirect:/";
	}

	@GetMapping("/document/findByNumber/{number}")
	public ResponseEntity<?> findByNumber(@PathVariable("number") String number) {
		var document = documentService.findByNumber(number).isPresent();
		return ResponseEntity.ok(document);
	}
}
