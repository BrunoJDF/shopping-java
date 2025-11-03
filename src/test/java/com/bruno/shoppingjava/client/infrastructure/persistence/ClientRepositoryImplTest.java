package com.bruno.shoppingjava.client.infrastructure.persistence;

import com.bruno.shoppingjava.client.ClientUnitTestCase;
import com.bruno.shoppingjava.client.infrastructure.cache.ClientCacheManager;
import com.bruno.shoppingjava.client.infrastructure.persistence.model.ClientDAO;
import com.bruno.shoppingjava.client.infrastructure.persistence.model.ClientDAOMother;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClientRepositoryImplTest extends ClientUnitTestCase {

  @Mock
  private CrudClientRepository crudClientRepository;
  @Mock
  private ClientCacheManager clientCacheManager;
  @InjectMocks
  private ClientRepositoryImpl systemUnderTest;

  @Test
  void create() {
    ClientDAO toSave = ClientDAOMother.random();

    when(crudClientRepository.save(any(ClientDAO.class)))
      .thenReturn(toSave);

    systemUnderTest.create(toSave.toDomain());

    verify(crudClientRepository).save(toSave);
  }

  @Test
  void findById() {
    ClientDAO clientDAO = ClientDAOMother.random();

    when(clientCacheManager.get(anyLong(), any(Function.class)))
      .thenAnswer(invocation -> {
        Long key = invocation.getArgument(0);
        Function<Long, ClientDAO> handler = invocation.getArgument(1);
        return handler.apply(key);
      });
    when(crudClientRepository.findById(clientDAO.getId()))
      .thenReturn(Optional.of(clientDAO));

    systemUnderTest.findById(clientDAO.getId());

    verify(crudClientRepository).findById(clientDAO.getId());
  }

  @Test
  void findAll() {
    ClientDAO clientDAO = ClientDAOMother.random();

    when(crudClientRepository.findAll())
      .thenReturn(List.of(clientDAO));

    systemUnderTest.findAll();

    verify(crudClientRepository).findAll();
  }

  @Test
  void update() {
    ClientDAO clientDAO = ClientDAOMother.random();

    when(crudClientRepository.save(any(ClientDAO.class)))
      .thenReturn(clientDAO);

    systemUnderTest.update(clientDAO.toDomain());

    verify(crudClientRepository).save(clientDAO);
  }

  @Test
  void delete() {
    ClientDAO clientDAO = ClientDAOMother.random();

    when(crudClientRepository.findById(clientDAO.getId()))
      .thenReturn(Optional.of(clientDAO));

    systemUnderTest.delete(clientDAO.getId());

    verify(crudClientRepository).delete(clientDAO);
  }
}
