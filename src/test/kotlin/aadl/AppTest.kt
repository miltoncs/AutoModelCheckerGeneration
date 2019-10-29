/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package aadl

import main.createSkeleton
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.streams.asSequence
import kotlin.test.Test

class AppTest {

    @Test fun testCreateSkeleton() {

        val input = File("/Users/mstafford/Projects/thesis/SafeStubGeneration/src/test/resources/big.aadl")

        val output = createSkeleton(input.readText())

        val outputPath = Paths.get("out", "output.java").create()

        Files.write(outputPath, output.toByteArray())
    }
}

fun Path.create(overwrite: Boolean = true) = apply {
    val pathList = this.asSequence().toList()
    pathList.dropLast(1).forEach { it.createDirectory(overwrite) }
    pathList.last().createFile(overwrite)
}

fun Path.createDirectory(overwrite: Boolean = true) = apply {
    if (overwrite) {
        this.recursiveDelete()
    }
    if (!Files.exists(this)) {
        Files.createDirectory(this)
    }
}

fun Path.recursiveDelete() {
    if (Files.isDirectory(this)) {
        Files.list(this).forEach { it.recursiveDelete() }
    } else {
        Files.delete(this)
    }
}

fun Path.createFile(overwrite: Boolean = true) = apply {
    if (overwrite) {
        Files.deleteIfExists(this)
    }
    if (!Files.exists(this)) {
        Files.createFile(this)
    }
}

fun Map<String, List<String>>.pretty(): String =
        entries.joinToString(separator = "\n") { (k, v) ->
            "$k -> \n" + v.joinToString(separator = "\n") { "    $it" }
        }
