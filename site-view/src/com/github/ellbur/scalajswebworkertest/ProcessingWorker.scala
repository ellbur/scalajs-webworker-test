
package com.github.ellbur.scalajswebworkertest

import org.scalajs.dom.raw.MessageEvent

import scala.scalajs.js.annotation.JSExport

@JSExport object ProcessingWorker {
  @JSExport def run(): MessageEvent => Unit = {
    { (event: MessageEvent) =>
      println(s"Received practical event ${event.data}")

      scalajs.js.Dynamic.global.postMessage(event.data.asInstanceOf[Int] + 1)
    }
  }
}
