package com.example

import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.*
import java.io.*

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    routing {
        routeFilesystem()
        routeResources()
    }
}

fun Route.routeFilesystem() {
    get("/") {
        call.respondHtml {
            head {
                title { +"Ktor: static-content" }
                styleLink("/static/styles.css")
                script(src = "/static/script.js") {}
            }
            body {
                p {
                    +"Hello from Ktor static content sample application"
                }
                p {
                    +"Current directory is ${System.getProperty("user.dir")}"
                }
                img(src = "static/image.png") {
                    onClick = "message('clicked the image')"
                }
            }
        }
    }
    static("static") {
        // When running under IDEA make sure that working directory is set to this sample's project folder
        staticRootFolder = File("files")
        files("css")
        files("js")
        file("image.png")
        file("random.txt", "image.png")
        default("index.html")
    }
    static("custom") {
        staticRootFolder = File("/tmp") // Establishes a root folder
        files("public") // For this to work, make sure you have /tmp/public on your system
        static("themes") {
            // services /custom/themes
            files("data")
        }
    }
}

fun Route.routeResources() {
    get("/resources") {
        call.respondHtml {
            head {
                title { +"Ktor: static-content" }
                styleLink("/static-resources/styles.css")
            }
            body {
                p {
                    +"Hello from Ktor static content served from resources, if the background is cornflowerblue"
                }
            }
        }
    }

    static("static-resources") {
        resources("css")
    }
}