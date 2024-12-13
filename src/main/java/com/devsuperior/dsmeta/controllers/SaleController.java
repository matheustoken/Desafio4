package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SalesReportDTO;
import com.devsuperior.dsmeta.dto.SummaryDTO;
import com.devsuperior.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService saleService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = saleService.findById(id);
		return ResponseEntity.ok(dto);
	}
	@GetMapping(value = "/report")
	public ResponseEntity<Page<SalesReportDTO>> getReport(
			@RequestParam(value = "minDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate minDate,
			@RequestParam(value = "maxDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate maxDate,
			@RequestParam(value = "name", required = false) String name,
			Pageable pageable) {

		Page<SalesReportDTO> dto = saleService.getSalesReport(minDate, maxDate, name, pageable);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<Page<SummaryDTO>> getSummary(
			@RequestParam(value = "minDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate minDate,
			@RequestParam(value = "maxDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate maxDate,
			@RequestParam(value = "name", required = false) String name,
			Pageable pageable) {

		Page<SummaryDTO> dto = saleService.getSummary(minDate, maxDate, name, pageable);
		return ResponseEntity.ok(dto);
	}
}
