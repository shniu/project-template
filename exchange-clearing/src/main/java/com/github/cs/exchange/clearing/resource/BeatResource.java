package com.github.cs.exchange.clearing.resource;

import com.github.cs.exchange.common.api.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author niushaohan
 * @date 2021/5/17 13
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class BeatResource {

    @Resource
    private RestTemplate restTemplate;

    @Resource(name = "balancedRestTemplate")
    private RestTemplate balancedRestTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    private AtomicLong nextIndex = new AtomicLong(1);

    @GetMapping("/v2/beat")
    public BaseResponse pingHelloV2() {
        log.info("Get v2 beat, {} vs. {}", balancedRestTemplate, restTemplate);
        String url = "http://ex-account-srv/api/v1/account/beat";
        return balancedRestTemplate.getForObject(url, BaseResponse.class);
    }

    @GetMapping("/v1/beat")
    public BaseResponse pingHello() {

        String endpoint = getUrl("ex-account-srv");
        String url = String.format("%s/api/v1/account/beat", endpoint);

        BaseResponse response = restTemplate.getForObject(url, BaseResponse.class);

        return response;
    }

    String getUrl(String srvName) {
        List<ServiceInstance> instances = discoveryClient.getInstances(srvName);
        log.info("instances -> {}", instances);

        if (instances == null || instances.isEmpty()) {
            return null;
        }

        int instanceSize = instances.size();

        for (; ; ) {
            long current = nextIndex.get();
            long next = (current + 1) % instanceSize;
            if (nextIndex.compareAndSet(current, next) && next < instanceSize) {
                ServiceInstance serviceInstance = instances.get((int) next);
                return serviceInstance.getUri().toString();
            }
        }
    }
}
