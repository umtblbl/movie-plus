import dependencies.Dependencies
import extensions.implementation

plugins {
    id("commons.android-library")
}

dependencies {
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL)
    implementation(Dependencies.CONSTRAINT_LAYOUT)
    implementation(Dependencies.RECYCLER_VIEW)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.FRAGMENT_KTX)
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.COIL)
    implementation("com.github.bumptech.glide:glide:4.16.0")
}
