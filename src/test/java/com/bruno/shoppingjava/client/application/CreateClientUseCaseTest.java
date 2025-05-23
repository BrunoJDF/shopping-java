package com.bruno.shoppingjava.client.application;

import com.bruno.shoppingjava.client.ClientUnitTestCase;
import com.bruno.shoppingjava.client.application.request.CreateClientRequest;
import com.bruno.shoppingjava.client.application.request.CreateClientRequestMother;
import com.bruno.shoppingjava.client.domain.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CreateClientUseCaseTest extends ClientUnitTestCase {

  @Mock
  private ClientRepository clientRepository;
  @InjectMocks
  private CreateClientUseCase systemUnderTest;

  @Test
  void createClient() {
    // Given
    CreateClientRequest createClientRequest = CreateClientRequestMother.random();

    // When
    when(clientRepository.create(any()))
      .thenReturn(createClientRequest.toClientDomain());
    var res = systemUnderTest.createClient(createClientRequest);

    // Then
    assertThat(res).isNotNull();
  }
}
