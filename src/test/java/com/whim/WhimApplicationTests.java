package com.whim;

import com.whim.common.utils.BCryptUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class WhimApplicationTests {

    @Test
    void contextLoads() {
        log.info(BCryptUtils.encode("123456789"));
    }

}
