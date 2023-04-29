package uz.futuresoft.countries.data.di

import android.content.Context
import android.util.Log
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.futuresoft.countries.data.utils.Constants
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(timeout = 60, unit = TimeUnit.SECONDS)
        .writeTimeout(timeout = 60, unit = TimeUnit.SECONDS)
        .readTimeout(timeout = 60, unit = TimeUnit.SECONDS)
        .addInterceptor(interceptor = loggingInterceptor)
        .addInterceptor(interceptor = chuckerInterceptor)
        .build()

    @Provides
    fun provideLoggerInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor {
//        if (BuildConfig.DEBUG) {
            Log.d("HTTP", it)
//        }
    }.setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideChuckerInterceptor(
        @ApplicationContext context: Context,
        chuckerCollector: ChuckerCollector,
    ): ChuckerInterceptor = ChuckerInterceptor.Builder(context = context)
        .collector(collector = chuckerCollector)
        .maxContentLength(length = 550000L)
        .redactHeaders(emptySet())
        .alwaysReadResponseBody(enable = false)
        .build()

    @Provides
    fun provideChuckerCollector(
        @ApplicationContext context: Context,
    ): ChuckerCollector = ChuckerCollector(
        context = context,
        showNotification = true,
        retentionPeriod = RetentionManager.Period.ONE_WEEK
    )

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}