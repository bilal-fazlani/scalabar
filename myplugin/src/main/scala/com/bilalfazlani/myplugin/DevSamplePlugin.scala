package com.bilalfazlani.myplugin

import com.bilalfazlani.swiftbar4s.devtools.PluginPreview
import com.bilalfazlani.swiftbar4s.dsl._

object DevSamplePlugin
    extends PluginPreview("/Users/bilal/projects/bitbar-plugins/sample.5m.sh")
    with MenuDsl {
  override val appMenu = menu("sample!!") {
    link("1easdsd", "https://google.com")
    link("yahoo", "https://yahoo.com", alternate = true)
  }
}
