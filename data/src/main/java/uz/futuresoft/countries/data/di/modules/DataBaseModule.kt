package uz.futuresoft.countries.data.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.futuresoft.countries.data.local.database.AppDataBase

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    fun provideAppDataBase(
        @ApplicationContext context: Context,
    ): AppDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDataBase::class.java,
            name = "app_data_base"
        ).build()
    }
}