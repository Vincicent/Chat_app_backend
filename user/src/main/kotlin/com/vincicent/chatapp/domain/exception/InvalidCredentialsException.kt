package com.vincicent.chatapp.domain.exception

class InvalidCredentialsException: RuntimeException(
    "The entered credentials aren't valid"
)