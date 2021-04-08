package com.yx.test.rateLimit;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author yangxin@webull.com
 * @date 2021年04月08日
 * @time 4:07 下午
 * @since JDK1.8
 */
public class RateLimiterTest {
    static ExecutorService service = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        // 默认一秒钟 允许通过10次 -- 规定标准 ,
        RateLimiter rateLimiter = RateLimiter.create(3);
        for (int i = 0; i < 200; i++) {
            service.execute(() -> {
                //
//                rateLimiter.tryAcquire(); // 默认1s等待
                boolean b = rateLimiter.tryAcquire(1, TimeUnit.SECONDS); // 带等待时间
                System.out.println("limit res: " + b);
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss,SSSzzz");
                System.out.println(Thread.currentThread().getName() + "获取到了令牌，时间 = " + dateFormat.format(new Date()));
            });
        }
    }

    Map<String, RateLimiter> chm = new ConcurrentHashMap<>();

    /**
     * 需求：
     * 不同类型-实现不同的等待时间-限流还是一样
     */
    private Boolean tryAcquire(String type) {
        RateLimiter rateLimiter = null;
        Boolean res;
        if (type.equals(1)) {
            rateLimiter = chm.putIfAbsent("abc_key", RateLimiter.create(10));
            res = rateLimiter.tryAcquire(10);
        } else {
            rateLimiter = chm.putIfAbsent("abc_key", RateLimiter.create(15));
            res = rateLimiter.tryAcquire(20);
        }
        return res;
    }

}
