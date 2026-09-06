package com.atlas.mobile.agent.data.database

import androidx.room.*

@Entity(tableName = "memories")
data class MemoryEntity(
    @PrimaryKey val id: String,
    val projectId: String?,
    val content: String,
    val category: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Dao
interface MemoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(memory: MemoryEntity)

    @Query("SELECT * FROM memories WHERE projectId = :projectId ORDER BY timestamp DESC")
    suspend fun getProjectMemories(projectId: String): List<MemoryEntity>

    @Query("DELETE FROM memories WHERE content LIKE '%' || :keyword || '%'")
    suspend fun forgetByKeyword(keyword: String): Int
}

@Database(entities = [MemoryEntity::class], version = 1, exportSchema = false)
abstract class AtlasDatabase : RoomDatabase() {
    abstract fun memoryDao(): MemoryDao
}
