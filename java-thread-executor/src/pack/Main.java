package pack;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Executor executor = new TestSingleThreadExecutor().getExecutor();
		executor.execute(()-> System.out.println("one runnable submitted"));
		
		ExecutorService executorService = new TestSingleThreadExecutor().getExecutorService();
		Future<String> future = executorService.submit(()->"returned from future");
		// the following invocation will block the code execution 
		String str = future.get();
		System.out.println(str);
		
		ThreadPoolExecutor fixedThreadPoolExecutor = new TestThreadPoolExecutor().newFixedThreadPool(2);
		fixedThreadPoolExecutor.submit(() -> {
		    Thread.sleep(1000);
		    return null;
		});
		fixedThreadPoolExecutor.submit(() -> {
		    Thread.sleep(1000);
		    return null;
		});
		fixedThreadPoolExecutor.submit(() -> {
		    Thread.sleep(1000);
		    return null;
		});
		System.out.println("Fixed Pool size: " + fixedThreadPoolExecutor.getPoolSize());
		System.out.println("Fixed Queue: " + fixedThreadPoolExecutor.getQueue().size());
		assertEquals(2, fixedThreadPoolExecutor.getPoolSize());
		assertEquals(1, fixedThreadPoolExecutor.getQueue().size());

		
		ThreadPoolExecutor cachedThreadPoolExecutor = new TestThreadPoolExecutor().newCachedThreadPool();
		cachedThreadPoolExecutor.submit(() -> {
		    Thread.sleep(1000);
		    return null;
		});
		cachedThreadPoolExecutor.submit(() -> {
		    Thread.sleep(1000);
		    return null;
		});
		cachedThreadPoolExecutor.submit(() -> {
		    Thread.sleep(1000);
		    return null;
		});
		System.out.println("Pool size: " + cachedThreadPoolExecutor.getPoolSize());
		System.out.println("Queue: " + cachedThreadPoolExecutor.getQueue().size());
		assertEquals(3, cachedThreadPoolExecutor.getPoolSize());
		assertEquals(0, cachedThreadPoolExecutor.getQueue().size());
	}
}

class TestSingleThreadExecutor {
	
	public Executor getExecutor() {
		Executor executor = Executors.newSingleThreadExecutor();
		return executor;
	}
	
	public ExecutorService getExecutorService() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		return executor;
	}
}

class TestThreadPoolExecutor {
	
	public ThreadPoolExecutor newFixedThreadPool(int size) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(size);
		return executor;
	}
	
	public ThreadPoolExecutor newCachedThreadPool() {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		return executor;
	}
}