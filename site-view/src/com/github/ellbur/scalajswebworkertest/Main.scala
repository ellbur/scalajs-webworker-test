
package com.github.ellbur.scalajswebworkertest

import com.github.ellbur.scalajswebworkertest.view.MainScreen
import org.scalajs.dom.raw.{MessageEvent, Worker}
import org.scalajs.jquery.{JQueryEventObject, jQuery => $}

import scala.scalajs.js
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object Main extends JSApp with reactive.Observing {
  @JSExport
  override def main(): Unit = {
    val screen = new MainScreen

    $("body").ready { (event: JQueryEventObject) =>
      $("body").append(screen.root)
    }

    screen.started foreach { _ =>
      val worker = new Worker("worker.js")

      worker.onmessage = { (reply: js.Any) =>
        reply match {
          case reply: MessageEvent =>
            println(s"Received reply ${reply.data}")
        }
      }

      worker.postMessage("com.github.ellbur.scalajswebworkertest.ProcessingWorker().run()")
      worker.postMessage(3)
    }
  }
}
