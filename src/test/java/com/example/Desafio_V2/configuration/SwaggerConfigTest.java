package com.example.Desafio_V2.configuration;

import static org.junit.Assert.assertNotNull;

import com.example.desafio_v2.configuration.SwaggerConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SwaggerConfigTest {

  @Test
  public void shouldGetDocket() {
    SwaggerConfig swaggerConfig = new SwaggerConfig();
    assertNotNull("Docket não pode ser null!", swaggerConfig.api());
  }

}