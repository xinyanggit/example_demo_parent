package com.yx.test.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author yangxin@webull.com
 * @date 2020年12月08日
 * @time 11:58 上午
 * @since JDK1.8
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception, InterruptedException {
        orderProcess();
    }

    public static void sleep(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1、查询航班
     * 2、查询酒店
     * 3、汇总
     */
    public static void orderProcess() {
        CompletableFuture<String> orderAir = CompletableFuture.supplyAsync(() -> {
            System.out.println("查询航班");
            sleep(1000L);
            System.out.println("订购航班");
            return "航班信息";
        });
        CompletableFuture<String> orderHotel = CompletableFuture.supplyAsync(() -> {
            System.out.println("查询酒店");
            sleep(1000L);
            System.out.println("订购酒店");
            return "酒店信息";
        });
    /*    CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(orderAir, orderHotel);
        try {
            voidCompletableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        CompletableFuture<String> stringCompletableFuture = orderAir.thenCombine(orderHotel, (air, hotel) -> {
            System.out.println(air + "-" + hotel);
            return "租车信息";
        });
        stringCompletableFuture.join();
    }
}
