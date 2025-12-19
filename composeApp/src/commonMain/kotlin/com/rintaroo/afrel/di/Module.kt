package com.rintaroo.afrel.di

import com.rintaroo.afrel.data.database.AppDatabase
import com.rintaroo.afrel.data.repository.AppRepository
import com.rintaroo.afrel.data.repository.AppRepositoryImpl
import com.rintaroo.afrel.data.repository.ExpenditureRepository
import com.rintaroo.afrel.data.repository.ExpenditureRepositoryImpl
import com.rintaroo.afrel.model.ItemType
import com.rintaroo.afrel.ui.editItem.EditItemViewModel
import com.rintaroo.afrel.ui.main.MainViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun commonAppModule(): Module = module {
    single { get<AppDatabase>().appDao() }

    single { get<AppDatabase>().expenditureDao() }

    single<AppRepository> { AppRepositoryImpl(get()) }

    single<ExpenditureRepository> { ExpenditureRepositoryImpl(get()) }

    viewModel { MainViewModel(get(), get()) }

    viewModel { (itemId: Int, itemType: ItemType) ->
        EditItemViewModel(get(), get(), itemId, itemType)
    }

}