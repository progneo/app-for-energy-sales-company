package com.enplus.energetic.ui.screen.oneTimePin;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class OneTimePinViewModel_Factory implements Factory<OneTimePinViewModel> {
  @Override
  public OneTimePinViewModel get() {
    return newInstance();
  }

  public static OneTimePinViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static OneTimePinViewModel newInstance() {
    return new OneTimePinViewModel();
  }

  private static final class InstanceHolder {
    private static final OneTimePinViewModel_Factory INSTANCE = new OneTimePinViewModel_Factory();
  }
}
