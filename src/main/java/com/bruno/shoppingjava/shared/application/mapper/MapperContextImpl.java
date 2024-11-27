package com.bruno.shoppingjava.shared.application.mapper;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapperContextImpl implements MapperContext{

  private final MapperFacade mapperFacade;

  @Override
  public <T> T map(Object source, Class<T> target) {
    return mapperFacade.map(source, target);
  }
}
