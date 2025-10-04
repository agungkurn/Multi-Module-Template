package id.ak.multimoduletemplate.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.ak.convention.data.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideJson() = Json {
        // Handle missing/extra fields
        ignoreUnknownKeys = true
        coerceInputValues = true

        // Handle nulls gracefully
        explicitNulls = false

        // Pretty print untuk debugging
        prettyPrint = BuildConfig.DEBUG

        // Untuk compatibility dengan backend yang lenient
        isLenient = true
    }

    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit = Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()
}