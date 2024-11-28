package com.zandroid.mycalculator.room;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CalcDao_Impl implements CalcDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CalcEntity> __insertionAdapterOfCalcEntity;

  private final EntityDeletionOrUpdateAdapter<CalcEntity> __deletionAdapterOfCalcEntity;

  private final SharedSQLiteStatement __preparedStmtOfClearHistory;

  public CalcDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCalcEntity = new EntityInsertionAdapter<CalcEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `table_history` (`id`,`expression`,`result`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CalcEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getExpression() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getExpression());
        }
        if (entity.getResult() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getResult());
        }
      }
    };
    this.__deletionAdapterOfCalcEntity = new EntityDeletionOrUpdateAdapter<CalcEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `table_history` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CalcEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__preparedStmtOfClearHistory = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM table_history";
        return _query;
      }
    };
  }

  @Override
  public Object insertCalculation(final CalcEntity calcEntity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCalcEntity.insert(calcEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteExpression(final CalcEntity calcEntity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCalcEntity.handle(calcEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public void clearHistory() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearHistory.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfClearHistory.release(_stmt);
    }
  }

  @Override
  public List<CalcEntity> getAllHistory() {
    final String _sql = "SELECT * FROM table_history ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfExpression = CursorUtil.getColumnIndexOrThrow(_cursor, "expression");
      final int _cursorIndexOfResult = CursorUtil.getColumnIndexOrThrow(_cursor, "result");
      final List<CalcEntity> _result = new ArrayList<CalcEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final CalcEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpExpression;
        if (_cursor.isNull(_cursorIndexOfExpression)) {
          _tmpExpression = null;
        } else {
          _tmpExpression = _cursor.getString(_cursorIndexOfExpression);
        }
        final String _tmpResult;
        if (_cursor.isNull(_cursorIndexOfResult)) {
          _tmpResult = null;
        } else {
          _tmpResult = _cursor.getString(_cursorIndexOfResult);
        }
        _item = new CalcEntity(_tmpId,_tmpExpression,_tmpResult);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
