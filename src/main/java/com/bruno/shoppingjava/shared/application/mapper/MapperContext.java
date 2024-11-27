package com.bruno.shoppingjava.shared.application.mapper;

public interface MapperContext {
  <T> T map(Object source, Class<T> target);
}
