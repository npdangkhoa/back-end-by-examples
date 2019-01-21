package com.org.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class reactorBaeldungTest {
	
	@Test
	public void subscribe() {
		List<Integer> elems = new ArrayList<Integer>();
		Flux.just(1,2,3,4).log().subscribe(elems::add);
		
		assertThat(elems).containsExactly(1,2,3,4);
	}
}
