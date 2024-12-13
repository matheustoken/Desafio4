package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SalesReportDTO;
import com.devsuperior.dsmeta.dto.SummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;

	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = saleRepository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SalesReportDTO> getSalesReport(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		if (maxDate == null) {
			maxDate = today;
		}
		if (minDate == null) {
			minDate = maxDate.minusYears(1L);
		}
		return saleRepository.getSalesReport(minDate, maxDate, (name == null || name.isEmpty()) ? null : name, pageable);
	}

	public Page<SummaryDTO> getSummary(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable) {
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		if (maxDate == null) {
			maxDate = today;
		}
		if (minDate == null) {
			minDate = maxDate.minusYears(1L);
		}
		return saleRepository.getSummary(minDate, maxDate, (name == null || name.isEmpty()) ? null : name, pageable);
	}

}