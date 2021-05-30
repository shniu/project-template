package com.github.cs.exchange.order.infra.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author niushaohan
 * @date 2021/5/17 19
 */
public class AuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 2);
        requestTemplate.header("checksum", "111");
    }
}
