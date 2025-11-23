package com.rintaroo.mokumokusolo.di

import com.rintaroo.mokumokusolo.data.database.AppDatabase
import com.rintaroo.mokumokusolo.data.repository.AppRepository
import com.rintaroo.mokumokusolo.data.repository.AppRepositoryImpl
import com.rintaroo.mokumokusolo.data.repository.ExpenditureRepository
import com.rintaroo.mokumokusolo.data.repository.ExpenditureRepositoryImpl
import com.rintaroo.mokumokusolo.model.ItemType
import com.rintaroo.mokumokusolo.ui.editItem.EditItemViewModel
import com.rintaroo.mokumokusolo.ui.main.MainViewModel
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