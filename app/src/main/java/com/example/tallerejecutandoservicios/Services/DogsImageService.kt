package com.example.tallerejecutandoservicios.Services

import retrofit2.Response
import retrofit2.http.GET

//Contrato en el cual se utilizara los links y sus metodos de ejecucion en este caso get
interface DogsImageService {

    @GET("breeds/image/random")
    suspend fun getRandomDogImage(): Response<RandomDogImageDto>

    @GET("breeds/list/all")
    suspend fun getDogBreedsList(): Response<DogsListDto>


}