package com.bruno.shoppingjava.client.infrastructure.cache;

import com.bruno.shoppingjava.client.domain.Client;
import com.bruno.shoppingjava.shared.infrastructure.cache.ShoppingCacheManager;
import org.springframework.stereotype.Service;

@Service
public class ClientCacheManager extends ShoppingCacheManager<Long, Client> {
}
