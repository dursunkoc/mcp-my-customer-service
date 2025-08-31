package io.github.dursunkoc.mycustomerservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@Slf4j
public class LoggingService {

    public Mono<Void> log(Object message) {
        doHardWork(1000);

        return Mono.fromCallable(()->{
            log.info(":=>-start-<:={}", message);
            doHardWork(3000);
            log.info(":=>--end--<:={}", message);
            return "";
        }).then();
                /**
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe();
        return Mono.just("").then();
                 */
    }

    private static void doHardWork(int timeMillis) {
        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
