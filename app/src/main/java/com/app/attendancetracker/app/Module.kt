package com.app.attendancetracker.app

import android.app.Application
import androidx.room.Room
import com.app.attendancetracker.data.Repository
import com.app.attendancetracker.data.database.ListConverter
import com.app.attendancetracker.data.database.MainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun provideListConverter(): ListConverter = ListConverter()

    @Provides
    @Singleton
    fun provideDatabase(app: Application, listConverter: ListConverter): MainDatabase =
        Room.databaseBuilder(app, MainDatabase::class.java, "AttendanceDatabase").addTypeConverter(listConverter).build()

    @Provides
    @Singleton
    fun provideFaceRepo(app: Application, db: MainDatabase): Repository = Repository(app, db)

}