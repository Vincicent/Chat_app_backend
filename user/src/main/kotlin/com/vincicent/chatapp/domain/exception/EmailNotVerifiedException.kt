package com.vincicent.chatapp.domain.exception

import java.lang.RuntimeException

class EmailNotVerifiedException: RuntimeException(
    "Email is not verified"
)