
package com.github.ellbur.scalajswebworkertest.view

import org.scalajs.jquery.{JQueryEventObject, jQuery => $}
import reactive.{EventSource, EventStream}
import redosignals.{Source, Target}

import scalatags.JsDom.all._
import redosignals.RedoSignals._

class MainScreen extends reactive.Observing {
  private val startButton = button("Start").render

  val root = div(`class` := "main-screen",
    startButton
  ).render

  private val _started = new EventSource[Unit]
  val started = _started: EventStream[Unit]

  $(startButton).click { (_: JQueryEventObject) =>
    _started.fire()
  }
}
