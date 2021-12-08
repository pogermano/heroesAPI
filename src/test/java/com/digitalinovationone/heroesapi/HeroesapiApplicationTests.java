package com.digitalinovationone.heroesapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.boot.test.context.SpringBootTest;
import com.digitalinovationone.heroesapi.document.Heroes;
import com.digitalinovationone.heroesapi.repository.HeroesRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import static com.digitalinovationone.heroesapi.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class HeroesapiApplicationTests {


	@Autowired
	WebTestClient webTestClient;

	@Autowired
	HeroesRepository heroesRepository;


	@Test
	public void getOneHeroeById(){

		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"5")
				.exchange()
				.expectStatus().isOk()
				.expectBody();


	}
	@Test
	public void getAllHeroes(){

		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL)
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void getOneHeronotFound(){

		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"10")
				.exchange()
				.expectStatus().isNotFound();

	}


	@Test
	public void deleteHero(){

		webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"5")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);

	}

}
