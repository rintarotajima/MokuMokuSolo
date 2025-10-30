package com.example.mokumokusolo.di

import com.example.mokumokusolo.data.database.AppDatabase
import com.example.mokumokusolo.data.repository.AppRepository
import com.example.mokumokusolo.data.repository.AppRepositoryImpl
import com.example.mokumokusolo.data.repository.ExpenditureRepository
import com.example.mokumokusolo.data.repository.ExpenditureRepositoryImpl
import com.example.mokumokusolo.ui.editItem.EditItemViewModel
import com.example.mokumokusolo.ui.main.MainViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun commonAppModule(): Module = module {
    single { get<AppDatabase>().appDao() }

    single { get<AppDatabase>().expenditureDao() }

    single<AppRepository> { AppRepositoryImpl(get()) }

    single<ExpenditureRepository> { ExpenditureRepositoryImpl(get()) }

    viewModel { MainViewModel(get(), get()) }

    viewModel { (itemId: Int, itemType: String) ->
        EditItemViewModel(get(), get(), itemId, itemType)
    }

}