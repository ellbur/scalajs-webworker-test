
package com.github.ellbur.scalajswebworkertest

import org.scalajs.dom.raw.MessageEvent

import scala.scalajs.js
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object WorkerMain extends JSApp {
  @JSExport def main(): Unit = {
    var delegate: Option[MessageEvent => Unit] = None

    scalajs.js.Dynamic.global.onmessage = { (event: MessageEvent) =>
      delegate match {
        case Some(delegate) => delegate(event)
        case None => delegate = Some(js.eval(event.data.asInstanceOf[String]).asInstanceOf[MessageEvent => Unit])
      }
    }
  }
}
