package com.bilalfazlani.swiftbar4s

import com.bilalfazlani.swiftbar4s.models._
import com.bilalfazlani.swiftbar4s.models.MenuItem._
import com.bilalfazlani.swiftbar4s.parser.{MenuRenderer}
import com.bilalfazlani.swiftbar4s.dsl._
import org.reactivestreams._

class MenuSubscriber(menuRenderer: MenuRenderer)
    extends Subscriber[MenuBuilder] {
  var sub: Option[Subscription] = None

  override def onSubscribe(subscription: Subscription): Unit = {
    sub = Some(subscription)
    sub.get.request(1)
  }

  override def onNext(item: MenuBuilder): Unit = {
    sub.foreach { s =>
      menuRenderer.renderMenu(item, true)
      s.request(1)
    }
  }

  override def onError(t: Throwable): Unit = sys.exit(1)

  override def onComplete(): Unit = sys.exit(0)
}
