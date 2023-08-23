package com.app.mymvpapp.di.annotations.scopes

import dagger.hilt.InstallIn
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class ApplicationScope()
