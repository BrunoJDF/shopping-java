package com.bruno.shoppingjava.client.application;

import com.bruno.shoppingjava.client.domain.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteClientUseCase {
  private final ClientRepository repository;

  public Boolean delete(Long id) {
    return repository.delete(id);
  }
}
