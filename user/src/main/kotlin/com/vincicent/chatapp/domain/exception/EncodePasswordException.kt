package com.vincicent.chatapp.domain.exception

import java.lang.RuntimeException

class EncodePasswordException: RuntimeException(
    "Encoding password failed"
)