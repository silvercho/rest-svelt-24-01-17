package com.ll.rsv.global.initData;

import com.ll.rsv.domain.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class All {
    private final MemberService memberService;

    @Bean
    @Order(2)
    public ApplicationRunner initAll() {
        return args -> {
            if (memberService.findByUsername("system").isPresent()) return;

            memberService.join("system", "1234");
            memberService.join("admin", "1234");
            // 시스템과 어드민 계정은 있어야한다.~
        };
    }
}