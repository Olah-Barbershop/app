buildscript {
    extra.apply {
        set("lifecycle_version", "2.6.1")
    }
}
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
}