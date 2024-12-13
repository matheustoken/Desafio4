package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SalesReportDTO;
import com.devsuperior.dsmeta.dto.SummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query("""
                SELECT new com.devsuperior.dsmeta.dto.SalesReportDTO(
                    obj.seller.id,
                    obj.seller.name,
                    obj.amount,
                    obj.date)
                FROM Sale obj
                WHERE obj.date BETWEEN :minDate AND :maxDate
                AND (:name IS NULL OR LOWER(obj.seller.name) LIKE LOWER(CONCAT('%', :name, '%')))
            """)
    Page<SalesReportDTO> getSalesReport(
            @Param("minDate") LocalDate minDate,
            @Param("maxDate") LocalDate maxDate,
            @Param("name") String name,
            Pageable pageable);

    @Query("""
                SELECT new com.devsuperior.dsmeta.dto.SummaryDTO(
                    obj.seller.name,
                    SUM(obj.amount))
                FROM Sale obj
                WHERE obj.date BETWEEN :minDate AND :maxDate
                AND (:name IS NULL OR LOWER(obj.seller.name) LIKE LOWER(CONCAT('%', :name, '%')))
                GROUP BY obj.seller.name
            """)
        Page<SummaryDTO> getSummary(
            @Param("minDate") LocalDate minDate,
            @Param("maxDate") LocalDate maxDate,
            @Param("name") String name,
            Pageable pageable);

}