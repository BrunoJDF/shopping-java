package com.bruno.shoppingjava.client.infrastructure.persistence;

import com.bruno.shoppingjava.client.ClientInfrastructureTestCase;
import com.bruno.shoppingjava.client.infrastructure.persistence.model.ClientDAO;
import com.bruno.shoppingjava.client.infrastructure.persistence.model.ClientDAOMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class ClientRepositoryImplIntegrationTest extends ClientInfrastructureTestCase {

  @Autowired
  private ClientRepositoryImpl repository;

  @BeforeEach
  void setUp() {
    String sql = String.format(
      "DELETE FROM %s.client",
      SCHEMA
    );
    jdbcTemplate.update(sql);
  }

  @Test
  void should_create_client() {
    // given
    var client = ClientDAOMother.random();

    // when
    var created = repository.create(client.toDomain());

    // then
    assertThat(created).isNotNull();
    assertThat(created.getId()).isNotNull();
    assertThat(created.getName()).isEqualTo(client.getName());
  }

  @Test
  void should_find_client_by_id() {
    // given
    var client = ClientDAOMother.random();
    var created = repository.create(client.toDomain());

    // when
    var found = repository.findById(created.getId());
    // then
    assertThat(found).isNotNull();
    assertThat(found.getId()).isEqualTo(created.getId());
    assertThat(found.getName()).isEqualTo(client.getName());
  }

  @Test
  void should_find_all_clients() {
    // given
    var client1 = ClientDAOMother.random();
    var client2 = ClientDAOMother.random();
    repository.create(client1.toDomain());
    repository.create(client2.toDomain());

    // when
    var clients = repository.findAll();

    // then
    assertThat(clients).isNotEmpty()
      .hasSize(2);
  }

  @Test
  void should_update_client() {
    // given
    var client = ClientDAOMother.random();
    var created = repository.create(client.toDomain());

    var updatedClient = ClientDAO.fromDomain(created);
    updatedClient.setName("Updated Name");

    // when
    var updated = repository.update(updatedClient.toDomain());

    // then
    assertThat(updated).isNotNull();
    assertThat(updated.getId()).isEqualTo(created.getId());
    assertThat(updated.getName()).isEqualTo("Updated Name");
  }
}
