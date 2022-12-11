package com.manarelsebaay.madarsofttask.di

import android.app.Application
import androidx.room.Room
import com.manarelsebaay.madarsofttask.core.utils.DefaultDispatcherProvider
import com.manarelsebaay.madarsofttask.core.utils.DispatcherProvider
import com.manarelsebaay.madarsofttask.data.local.MadarDatabase
import com.manarelsebaay.madarsofttask.data.repository.MadarRepositoryImpl
import com.manarelsebaay.madarsofttask.domain.repository.MadarRepository
import com.manarelsebaay.madarsofttask.domain.use_case.SaveToDBUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMadarDataBase(app: Application): MadarDatabase {
        return Room.databaseBuilder(
            app,
            MadarDatabase::class.java,
            MadarDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideMadarRepository(madarDatabase: MadarDatabase): MadarRepository {
        return MadarRepositoryImpl(madarDatabase)
    }

    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider = DefaultDispatcherProvider()


    @Provides
    @Singleton
    fun ProvideSaveToDBUseCase(
        madarRepository: MadarRepository,
        dispatcherProvider: DispatcherProvider
    ): SaveToDBUseCase {
        return SaveToDBUseCase(madarRepository, dispatcherProvider)
    }
}

