package com.github.cs.exchange.match.engine.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author niushaohan
 * @date 2021/3/2 15
 */
@AllArgsConstructor
@Getter
@Builder
public final class MatchingEngineConfiguration {

    /**
     * Performance configuration.
     */
    private PerformanceConfiguration performanceCfg;

    public static MatchingEngineConfiguration.MatchingEngineConfigurationBuilder defaultBuilder() {
        return builder()
                .performanceCfg(PerformanceConfiguration.DEFAULT);
    }
}
