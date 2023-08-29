import dependencies.Dependencies
import extensions.implementation

plugins {
    id("commons.android-dynamic-feature")
}

dependencies {
    implementation(project(BuildModules.Features.HOME))
    implementation(project(BuildModules.Commons.VIEWS))

    implementation(Dependencies.RECYCLER_VIEW)
}
