package ru.grom.tasklist.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.grom.tasklist.model.Note;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM Note")
    List<Note> getNoteDao();

    @Query("SELECT * FROM Note")
    LiveData<List<Note>> getAllLiveData();

    @Query("SELECT * FROM Note WHERE uid IN (:userIds)")
    List<Note> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Note WHERE uid = :uid LIMIT 1 ")
    Note findById(int uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);
}