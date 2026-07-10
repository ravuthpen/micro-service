package com.piseth.bank.gatewayserver.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Order(1)
@Slf4j
@RequiredArgsConstructor
@Component
public class RequestTracingFilter implements GlobalFilter {

    private final FilterUtility filterUtility;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
        if(isCorrelationIdPresent(requestHeaders)){
            log.debug("piseth-correlation-id found in RequestTraceFilter {}",
                    filterUtility.getCorrelationId(requestHeaders));
        }else {
            String correlationId = generateCorrelationId();
            exchange = filterUtility.setCorrelationId(exchange, correlationId);
            log.debug("pisethbank-correlation-id generate in RequestTraceFilter {}", correlationId);
        }
        return chain.filter(exchange);
    }

    private String generateCorrelationId(){
        return UUID.randomUUID().toString();
    }
    private boolean isCorrelationIdPresent(HttpHeaders requestHeaders){
        if(filterUtility.getCorrelationId(requestHeaders) != null){
            return true;
        }
        return false;
    }
}
