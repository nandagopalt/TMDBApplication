package com.amalwin.tmdbapplication.presentation.di.core

import dagger.Component


@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    DatabaseModule::class,
    RemoteDataSourceModule::class,
    LocalDataSourceModule::class,
    CacheDataSourceModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {

}