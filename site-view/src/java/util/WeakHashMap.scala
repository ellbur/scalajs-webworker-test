
package java.util

import jsmisc.WeakMap

import scala.scalajs.js

class WeakHashMap[K, V] {
  private val internal = new WeakMap[K, V]

  private def undefinedToNull(x: Any): Any =
    if (js.isUndefined(x))
      null
    else
      x

  def get(key: K): V = undefinedToNull(internal.get(key)).asInstanceOf[V]
  def put(key: K, value: V): V = { internal.set(key, value); value }
  def remove(key: K) = {
    val before = internal.get(key)
    internal.delete(key)
    undefinedToNull(before)
  }
}
