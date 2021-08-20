package com.ringl.common.core.log

import co.touchlab.kermit.Kermit
import org.koin.mp.KoinPlatformTools

val logger = KoinPlatformTools.defaultContext().get().get<Kermit>()