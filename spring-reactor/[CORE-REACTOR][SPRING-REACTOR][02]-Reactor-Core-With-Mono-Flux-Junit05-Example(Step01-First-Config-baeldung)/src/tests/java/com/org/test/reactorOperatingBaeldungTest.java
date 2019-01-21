package com.org.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;

public class reactorOperatingBaeldungTest {
	
	@Test
	public void subscribe() {
		List<Integer> elems = new ArrayList<Integer>();
		Flux.just(1,2,3,4)
			.log()
			.subscribe(elems::add);
		
		assertThat(elems).containsExactly(1,2,3,4);
	}
	
	@Test
	public void subscribe02() {
		List<Integer> elems = new ArrayList<Integer>();
		Flux.just(1,2,3,4)
			.log()
			.subscribe(new Subscriber<Integer>() {

				@Override
				public void onComplete() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onError(Throwable arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onNext(Integer arg0) {
					elems.add(arg0);
				}

				@Override
				public void onSubscribe(Subscription s) {
					s.request(Long.MAX_VALUE);
				}
			});
		
		assertThat(elems).containsExactly(1,2,3,4);
	}
	
	@Test
	public void subscribe03() {
		List<Integer> elems = new ArrayList<Integer>();
		Flux.just(1,2,3,4)
			.log()
			.subscribe(new Subscriber<Integer>() {
				Subscription sub;
				int onNextAmount;

				@Override
				public void onNext(Integer arg0) {
					elems.add(arg0);
					onNextAmount ++;
					if (onNextAmount == 2) {
						sub.request(2);
					}
				}

				@Override
				public void onSubscribe(Subscription s) {
					this.sub = s;
					sub.request(2);
				}
				
				@Override
				public void onComplete() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onError(Throwable arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		
		assertThat(elems).containsExactly(1,2,3,4);
	}
	
	@Test
	public void subscribe04() {
		List<Integer> elems = new ArrayList<Integer>();
		Flux.just(1,2,3,4)
			.map(i -> i * 2)
			.log()
			.subscribe(new Subscriber<Integer>() {
				Subscription sub;
				int onNextAmount;

				@Override
				public void onNext(Integer arg0) {
					elems.add(arg0);
					onNextAmount ++;
					if (onNextAmount == 2) {
						sub.request(2);
					}
				}

				@Override
				public void onSubscribe(Subscription s) {
					this.sub = s;
					sub.request(2);
				}
				
				@Override
				public void onComplete() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onError(Throwable arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		
		assertThat(elems).containsExactly(2,4,6,8);
	}
}
