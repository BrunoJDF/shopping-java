package com.bruno.shoppingjava.invoice.application;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GenerateCodInvoiceUseCase {

  @PersistenceContext
  private EntityManager entityManager;

  public Optional<String> generateInvoiceCode() {
    var zone = Locale.getDefault();
    var count = getInvoiceCount();
    return Optional.of(count)
      .map(c -> String.format("%s-%d", zone.getCountry(), c));
  }

  public Long getInvoiceCount() {
    var query = entityManager.createNativeQuery("SELECT nextval('shopping_cart.invoice_code_seq')");
    return ((Number) query.getSingleResult()).longValue();
  }
}
