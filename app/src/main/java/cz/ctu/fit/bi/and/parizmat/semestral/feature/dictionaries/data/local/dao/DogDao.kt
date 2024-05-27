package cz.ctu.fit.bi.and.parizmat.semestral.feature.dictionaries.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import cz.ctu.fit.bi.and.parizmat.semestral.feature.dictionaries.data.local.DogEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DogDao {
    @Upsert
    suspend fun upsertAll(dogs: List<DogEntity>)

    @Query("SELECT * FROM dog_entity")
    fun getDogsStream(): Flow<List<DogEntity>>

    @Query("SELECT * FROM dog_entity WHERE id =:id")
    fun getDog(id: String): Flow<DogEntity?>

    @Query("SELECT * FROM dog_entity WHERE name LIKE  '%' || :query || '%' ")
    fun filterByQueryStream(query: String): Flow<List<DogEntity>>

    @Query("DELETE FROM dog_entity")
    fun clear()
}