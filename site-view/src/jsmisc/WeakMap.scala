
package jsmisc

import scala.scalajs.js

class WeakMap[K,V] extends js.Object {
  def has(key: K): Boolean = js.native
  def get(key: K): V = js.native
  def set(key: K, value: V): Unit = js.native
  def delete(key: K): Unit = js.native
}
