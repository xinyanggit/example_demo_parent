package com.yx.test.future;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yangxin@webull.com
 * @date 2020年12月07日
 * @time 11:12 上午
 * @since JDK1.8
 */
public class FutureTest {

    static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static String downloadImage() {
        int nextInt = RandomUtils.nextInt(0, 10);
        System.out.println(Thread.currentThread().getName() + "==>downloadImage:休眠时间" + nextInt + "：秒");
        try {
            Thread.sleep(nextInt * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "downloadImage:" + nextInt;
    }

    public static String downloadUrl(String str) {
        int nextInt = RandomUtils.nextInt(0, 10);
        System.out.println(Thread.currentThread().getName() + "==>downloadUrl:休眠时间" + nextInt + "：秒");
        try {
            Thread.sleep(nextInt * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "downloadUrl:" + nextInt;
    }

    /* public static void main(String[] args) throws ExecutionException, InterruptedException {
         for (int i = 0; i < 100; i++) {
             executorService.submit(() -> {
                 CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> downloadImage()).thenApply((str -> downloadUrl(str)));
                 try {
                     System.out.println(stringCompletableFuture.get());
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 } catch (ExecutionException e) {
                     e.printStackTrace();
                 }
                 ;
             });
         }
         String now = CompletableFuture.completedFuture("message").thenApply(str -> str.toUpperCase()).getNow("error");
         System.out.println(now);
     }*/
    public static void main(String[] args) throws ExecutionException, Exception {
        // normal();
        allOfDemo();
//       andOfDemo();
    }

    /**
     * 1、首先异步调用cars 获取car list，
     * 2 复合一个completionStage填写每个汽车的评分，通过rating() --获取汽车的评分
     * 3、汽车填写好评分之后，结束这个列表
     * 4、打印每个汽车和评分
     **/
    static List<Long> carIds = new ArrayList<>(1000);

    public static void theadCacl() {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            return "欢迎关注 ";
        }).thenApply(t -> {
            return t + "微信公众号 ";
        }).thenCombine(CompletableFuture.completedFuture("Java识堂"), (t, u) -> {
            return t + u;
        }).whenComplete((t, e) -> {
            // 欢迎关注 微信公众号 Java识堂
            System.out.println(t);
        });
    }

    public static void allOfDemo() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            sleepRandom();
            return "欢迎关注";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            sleepRandom();
            return "微信公众号";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            sleepRandom();
            return "Java识堂";
        });
// 欢迎关注 微信公众号 Java识堂
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(future1, future2, future3)
                .thenApply(v ->
                        Stream.of(future1, future2, future3)
                                .map(CompletableFuture::join)
                                .collect(Collectors.joining(" ")))
                .thenAccept(System.out::print);
    }


    public static void andOfDemo() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            sleepRandom();
            return "欢迎关注";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            sleepRandom();
            return "微信公众号";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            sleepRandom();
            return "Java识堂";
        });
        CompletableFuture<Object> resultFuture = CompletableFuture.anyOf(future1, future2, future3);
// 欢迎关注 微信公众号 Java识堂 随机输出
        System.out.println(resultFuture.get());

    }

    public static void sleepRandom() {
        int i = RandomUtils.nextInt(0, 10);
        System.out.println(i);
        try {
            Thread.sleep(i * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void normal() {

        long startDate = System.currentTimeMillis();
        List<Car> carList = carIds.stream().map(id ->
                getCarById(id)
        ).collect(Collectors.toList());
        carList.stream().peek(car -> car.setScore(rating(car))).forEach(System.out::println);
        long cost = System.currentTimeMillis() - startDate;
        System.out.println("花费时间：" + cost / 1000 + " s");
    }


    //汽车对象
    static class Car {
        private Long carId;
        private String score;

        public Car(Long carId) {
            this.carId = carId;
        }

        public Long getCarId() {
            return carId;
        }

        public void setCarId(Long carId) {
            this.carId = carId;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }
    }

    public static String rating(Car car) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "car" + car.getCarId();
    }

    public static CompletionStage getCompletionCarById(Long id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(new Car(id));
    }

    public static Car getCarById(Long id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Car(id);
    }


}