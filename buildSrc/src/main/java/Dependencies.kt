object ApplicationId {
    val id = "pl.branchdev.challenge"
}

object Modules {
    val app = ":app"
    val data = ":data"
    val network = ":network"
    val eventRepository = ":eventrepository"
    val schedule = ":schedule"
    val eventscreen = ":eventscreen"
    val playback = ":playback"
    val androidCommon = ":common:android_common"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val gradle = "3.4.0"
    val compileSdk = 28
    val minSdk = 21
    val targetSdk = 28
    val appcompat = "1.0.2"
    val design = "1.0.0"
    val recyclerview = "1.0.0"
    val kotlin = "1.3.21"
    val rxjava = "2.2.6"
    val rxkotlin = "2.3.0"
    val retrofit = "2.5.0"
    val loggingInterceptor = "3.12.1"
    val glide = "4.9.0"
    val koin = "2.0.0-beta-1"
    val junit = "4.12"
    val assertjCore = "3.12.0"
    val mockitoKotlin = "2.1.0"
    val mockitoInline = "2.24.5"
    val material = "1.0.0"
    val constraint = "1.1.3"
    val gson = "2.8.5"
    val rxandroid = "2.0.2"
}

object Libraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    val rxjavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
}

object SupportLibraries {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val design = "com.google.android.material:material:${Versions.design}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val material = "com.google.android.material:material:${Versions.material}"
    val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
}

object TestLibraries {
    val junit = "junit:junit:${Versions.junit}"
    val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
}
