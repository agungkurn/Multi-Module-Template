import org.gradle.kotlin.dsl.libs

plugins {
    id(libs.plugins.common.library.get().pluginId)
}

android {
    namespace = "id.ak.multimoduletemplate.common"
}
