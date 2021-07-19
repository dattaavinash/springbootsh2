package com.example.spdbconc.configuration;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsynchronusConfiguration implements AsyncConfigurer {
	@Override
	public Executor getAsyncExecutor() {
		int numOfCores=Runtime.getRuntime().availableProcessors();
		ThreadPoolTaskExecutor threadPoolTaskExecutor =new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(numOfCores);
		threadPoolTaskExecutor.setMaxPoolSize(numOfCores);
		threadPoolTaskExecutor.setThreadNamePrefix("AsyncThread-");
		threadPoolTaskExecutor.initialize();
		return threadPoolTaskExecutor;
	}

}
