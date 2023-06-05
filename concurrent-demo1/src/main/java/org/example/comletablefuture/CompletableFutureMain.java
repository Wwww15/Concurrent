package org.example.comletablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.*;
import java.util.stream.Stream;

public class CompletableFutureMain {

    public static void main(String[] args) {
        test8();
    }

    /**
     * complete
     */
    private static void test1() {
        CompletableFuture completableFuture = new CompletableFuture();
        new Thread(() -> {
            try {
                System.out.println("开始任务");
                Thread.sleep(10000);
                completableFuture.complete("完成任务");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("等待任务完成！");
        try {
            System.out.println(completableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("已经完成任务！");
    }

    /**
     * runAsync
     */
    private static void test2() {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("执行任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            System.out.println(completableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("执行完成!");

    }


    /**
     * supplyAsync
     */
    private static void test3() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(10000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "完成任务！";
            }
        });

        try {
            System.out.println(completableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("执行完成!");
    }

    /**
     * supplyAsync
     * thenRun
     */
    private static void test4() {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(10000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "吃完饭啦！";
            }
        }).thenRun(new Runnable() {
            @Override
            public void run() {
                System.out.println("吃完饭后开始运动！");
            }
        });

        try {
            completableFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束活动！");

    }

    /**
     * supplyAsync
     * thenAccept
     */
    private static void test5() {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "吃完饭啦！";
            }
        }).thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
                System.out.println("吃完饭后开始运动！");
            }
        });

        try {
            completableFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束活动！");
    }


    /**
     * supplyAsync
     * thenApply
     */
    private static void test6() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "吃完饭啦！";
            }
        }).thenApply(new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println(s);
                return "吃完饭后开始运动！";
            }
        });

        try {
            System.out.println(completableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束活动！");
    }


    /**
     * supplyAsync
     * thenCompose
     * apply
     */
    private static void test7() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "吃完饭啦！";
            }
        }).thenCompose(new Function<String, CompletionStage<Integer>>() {
            @Override
            public CompletionStage<Integer> apply(String s) {
                return CompletableFuture.supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        return s.length();
                    }
                });
            }
        });

        try {
            System.out.println(completableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束活动！");
    }


    /**
     * supplyAsync
     * thenCombine
     */
    private static void test8() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return +00000000000000000000000002;
            }
        }).thenCombine(CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return -0001;
            }
        }), new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer o, Integer o2) {
                return o + o2;
            }
        });

        try {
            System.out.println(completableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束活动！");
    }


}
