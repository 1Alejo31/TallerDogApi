package com.example.tallerejecutandoservicios.Services

//Creacion de un data class para la recepcion de datos por medio de un objeto json
data class RandomDogImageDto(val message: String, val status: String)

data class DogsListDto(val message: Map<String, List<String>>, val status: String)
