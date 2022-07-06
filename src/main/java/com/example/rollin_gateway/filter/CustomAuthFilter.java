//package com.example.rollin_gateway.filter;
//
//import org.apache.http.HttpHeaders;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.Objects;
//
//// Gateway에서 token parsing을 하기 위한 cumstom Filter
//@Component
//public class CustomAuthFilter extends AbstractGatewayFilterFactory<CustomAuthFilter.Config> {
//
//    public CustomAuthFilter() {super(CustomAuthFilter.Config.class);}
//
//    // 실제로 filter에서 수행되는 로직
//    @Override
//    public GatewayFilter apply(Config config) {
//        return (exchange, chain) -> {
//            //토큰 검증을 위한 pre filter로 사용하기 위해 request 호출(Post Filter의 경우는 Response를 받아온다.)
//            ServerHttpRequest request = exchange.getRequest();
//            // request header에 토큰이 없을 경우 no header error 발생
//            if (!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
//                return onError(exchange, "no Header", HttpStatus.UNAUTHORIZED);
//            }
//            // Request Header의 AUTHORAZATION 속성에서 token 획득
//            String token = Objects.requireNonNull(request.getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0);
//            if (!token.equals("A.B.C.D")) {
//                return onError(exchange, "token error", HttpStatus.NOT_FOUND);
//            }
//                return chain.filter(exchange);
//        };
//    }
//
//    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus){
//        ServerHttpResponse response = exchange.getResponse();
//        response.setStatusCode(httpStatus);
//        return response.setComplete();
//    }
//    public static class Config{}
//}
