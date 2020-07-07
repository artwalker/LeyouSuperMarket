package com.leyou.user.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HackerStar
 * @create 2020-06-26 16:09
 */
public class ThreadUtils {
    private static final ExecutorService es =
            Executors.newFixedThreadPool(10);
    public static void execute(Runnable runable) {
        es.submit(runable);
    }
}
