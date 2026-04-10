package com.example.userregistationapp;

//Importa as anotações e classes da biblioteca Room e do Android

import android.content.Context; //Classe que representa o contexto da aplicação (necessario para acessar recurso)
import androidx.room.Database; //Anotação para marcar a classe como um banco de dados Room
import androidx.room.Room;
import androidx.room.RoomDatabase; //Classe base que representa o BD

/*
  Anotação @Database define que a classe representa o banco de dados Room. Ela especifica as entidades (tabelas) que o banco irá conter e a versão do BD
*/

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    //Instancia unica (singleton) do BD
    private static UserDatabase instance;

    //Método abstrato que será implementado pela Room
    public abstract UserDao userDao();

    //Método que retorna a instancia do BD
    //O uso do 'synchronized' garante que apenas uma thread possa acessar este metodo por vez, evitando que duas instancias do BD sejam criadas acidentalmente
    public static synchronized UserDatabase getInstance(Context context) {
        //Verifica se já existe uma instancia de BD
        if (instance == null) {
            //Cria a intancia do BD usando Room
            //Usa o context da aplicação para evitar vazamento de memória
            //fallbackToDestructiveMigration - Se houver mudança de versão e não houver migração, o BD será recriado do zero
            instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user-database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        //Retorna a instancia criada
        return instance;
    }

}
