// Generated by Dagger (https://dagger.dev).
package com.zandroid.mycalculator.di;

import com.zandroid.mycalculator.room.CalcEntity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class DatabaseModule_ProvideEntityFactory implements Factory<CalcEntity> {
  @Override
  public CalcEntity get() {
    return provideEntity();
  }

  public static DatabaseModule_ProvideEntityFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CalcEntity provideEntity() {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideEntity());
  }

  private static final class InstanceHolder {
    private static final DatabaseModule_ProvideEntityFactory INSTANCE = new DatabaseModule_ProvideEntityFactory();
  }
}