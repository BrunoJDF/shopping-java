package com.bruno.shoppingjava.shared.infrastructure.persistence;

import com.bruno.shoppingjava.shared.application.exception.ShoppingRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.lang.NonNull;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
@Profile("postgres")
@Configuration
public class PostgresShoppingConfig implements BeanPostProcessor {
  @Value("${shopping-cart-properties.sql.schema-context}")
  private String schemaName;

  @Override
  public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
    if (!schemaName.isEmpty() && bean instanceof DataSource dataSource) {
      try (Connection conn = dataSource.getConnection();
           Statement statement = conn.createStatement()) {
        String sql = String.format("CREATE SCHEMA IF NOT EXISTS %s;", schemaName);
        statement.execute(sql);
        LOGGER.info("After initialization {}", bean.getClass().getSimpleName());
      } catch (SQLException e) {
        String message = String.format("Failed to create schema '%s'", schemaName);
        throw new ShoppingRuntimeException(message);
      }
    }
    return bean;
  }
}
