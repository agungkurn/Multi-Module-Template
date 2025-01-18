package id.ak.multimoduletemplate.common.extension

fun String.capitalizeWords(): String {
    return split(" ").map { it.replaceFirstChar { it.uppercase() } }.joinToString(separator = " ")
}