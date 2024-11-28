// Generated by Dagger (https://dagger.dev).
package com.zandroid.mycalculator.repository;

import com.zandroid.mycalculator.room.CalcDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class HistoryRepository_Factory implements Factory<HistoryRepository> {
  private final Provider<CalcDao> daoProvider;

  public HistoryRepository_Factory(Provider<CalcDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public HistoryRepository get() {
    return newInstance(daoProvider.get());
  }

  public static HistoryRepository_Factory create(Provider<CalcDao> daoProvider) {
    return new HistoryRepository_Factory(daoProvider);
  }

  public static HistoryRepository newInstance(CalcDao dao) {
    return new HistoryRepository(dao);
  }
}
