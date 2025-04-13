package com.warroom.poker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.warroom.poker.WebSocket.PokerWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    
    private final PokerWebSocketHandler pokerWebSocketHandler;
    
    public WebSocketConfig(PokerWebSocketHandler pokerWebSocketHandler) {
        this.pokerWebSocketHandler = pokerWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(pokerWebSocketHandler, "/ws").setAllowedOrigins("*");
    }

    
}