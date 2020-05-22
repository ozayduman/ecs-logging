package com.ozayduman.ecslogging.ecslogging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EnableScheduling
@Service
@Slf4j
public class SchedulerService {

    @Scheduled(fixedRate = 1000 * 2)
    public void scheduleLoggingWithFixedRate(){
        MDC.put("user.name", "özay duman");
        log.info("Logging event at [{}]", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }
    @Scheduled(fixedRate = 1000 * 1)
    public void scheduleAnotherLoggingWithFixedRate(){
        MDC.put("key.value", "x.y.z");
        log.info("Another logging event at [{}]", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
