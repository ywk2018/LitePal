package com.example.litepal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Book mBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_create_book:
                LitePal.getDatabase();
                Toast.makeText(this, "创建成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_add_data:
                mBook = new Book();
                mBook.setName("java is good");
                mBook.setAuthor("youwenkai");
                mBook.setPages(110);
                mBook.setPrice(8.88);
                mBook.setPress("Unknow");
                mBook.save();
                break;
            case R.id.btn_up_data:
                mBook = new Book();
                mBook.setPages(1000);
                mBook.setPrice(9.99);
                mBook.updateAll("name = ? and author = ?", "java is good", "youwenkai");
                break;
            case R.id.btn_delect_data:
                DataSupport.deleteAll(Book.class,"Pages > ?", "100");
                break;
            case R.id.btn_query_data:
                List<Book> books = DataSupport.findAll(Book.class);
                for (Book book: books){
                    Log.d(TAG, "book name is" + book.getName());
                    Log.d(TAG, "book author is" + book.getAuthor());
                    Log.d(TAG, "book pages is" + book.getPages());
                    Log.d(TAG, "book price is" + book.getPrice());
                    Log.d(TAG, "book press is" + book.getPress());
                }
                break;
        }
    }
}
