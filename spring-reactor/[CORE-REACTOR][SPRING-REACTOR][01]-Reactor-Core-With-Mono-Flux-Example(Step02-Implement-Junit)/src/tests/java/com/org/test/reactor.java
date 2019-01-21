package com.org.test;

import java.time.Duration;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class reactor {
	
	
	/**
	 * Flux.mergeWith merges them into an interleaved sequence. Hence, we see that the sequence has changed.
	 * Flux.concatWith merges them into a non-interleaved sequence. Hence, we see that the sequence remains the same despite the delay.
	 */
	@Test
	public void interleave() {
		Flux<Long> delay = Flux.interval(Duration.ofMillis(5));
		Flux<String> alphabetWithDelay = Flux.just("a", "b").zipWith(delay, (s,d) -> s);
		Flux<String> alphabetWithoutDelay = Flux.just("d", "e");
		
		//Merget with another Flux
		Flux<String> interleaveMerge = alphabetWithDelay.mergeWith(alphabetWithoutDelay);
		StepVerifier.create(interleaveMerge).expectNext("d", "e", "a", "b").verifyComplete();
		
		//Concat with another Flux
		Flux<String> interleaveConcat = alphabetWithDelay.concatWith(alphabetWithoutDelay);
		StepVerifier.create(interleaveConcat).expectNext("a", "b", "d", "e").verifyComplete();
	}
	
	
	/**
	 * In the first example, we have 3 Fluxes emitting the title, first name, and the last name. 
	 * Flux.zip is combining them in a strict sequence (when all Fluxes have emitted their nth item). 
	 * We then concatenated them to create a Flux emitting the full names.
	 */
	@Test
	public void zipping() {
		Flux<String> titles = Flux.just("Mr.", "Mrs.");
		Flux<String> FirstName = Flux.just("Tom", "Jerry");
		Flux<String> LastName = Flux.just("Doe", "Alles");
		
		Flux<String> zipName = Flux
				.zip(titles, FirstName, LastName)
				.map(s -> String.join(" ", s.getT1(), s.getT2(), s.getT3()));
		StepVerifier.create(zipName).expectNext("Mr. Tom Doe", "Mrs. Jerry Alles").verifyComplete();
	}
	
	
	
	/**
	 * We initialized the Mono and Flux in different ways and verified that they are emitting the expected objects.
	 */
	@Test
	public void initialized() {
		Mono<String> nonEmptyMono = Mono.just("jole");
		StepVerifier.create(nonEmptyMono).expectNext("jole").verifyComplete();
		
		Flux<String> nonEmptyFlux = Flux.just("John","Mike","Shara");
		StepVerifier.create(nonEmptyFlux).expectNext("John", "Mike", "Shara").verifyComplete();
		
		Flux<String> nonEmptyInteratorFlux = Flux.fromArray(new String[] {"John","Mike","Shara"});
		StepVerifier.create(nonEmptyInteratorFlux).expectNext("John","Mike","Shara").verifyComplete();
	}
	
	
	
	/**
	 * In this example, we created an empty Mono and a Flux
	 *  and used a StepVerifier to test them. 
	 *  The Publisher s completed without emitting any object.
	 */
    @Test
    public void empty() {
        Mono<String> emptyMono = Mono.empty();
        StepVerifier.create(emptyMono).verifyComplete();

        Flux<String> emptyFlux = Flux.empty();
        StepVerifier.create(emptyFlux).verifyComplete();
    }
}
