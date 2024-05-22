package cz.ctu.fit.bi.and.semestral.feature.dictionaries.data.api

import cz.ctu.fit.bi.and.semestral.feature.dictionaries.data.api.dto.DogResponse
import cz.ctu.fit.bi.and.semestral.feature.dictionaries.data.api.dto.GroupDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DogApi {
    @GET("breeds")
    suspend fun getBreeds(@Query("page[number]")number: Int ): DogResponse

    @GET("groups/{id}")
    suspend fun getGroups(@Path("id") id: String): GroupDto
}