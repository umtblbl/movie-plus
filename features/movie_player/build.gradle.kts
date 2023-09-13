import dependencies.Dependencies
import extensions.implementation

plugins {
    id("commons.android-dynamic-feature")
}

dependencies {
    implementation(project(BuildModules.Features.HOME))
    implementation(project(BuildModules.Commons.VIEWS))
    implementation(project(BuildModules.Commons.VIEWS))
    implementation("com.google.android.exoplayer:exoplayer-dash:2.19.1")
    implementation("com.google.android.exoplayer:exoplayer-core:2.19.1")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.19.1")

    implementation(Dependencies.RECYCLER_VIEW)
}
