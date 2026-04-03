package com.example.userregistationapp;

//O Data Access Object é o componente que serve para a persistencia de dados. Serve para definir as operações que podem ser feitas no banco de dados com relação de entidade User

//Importa as notações do Room necessarias para definir o DAO (Data Access Object)

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

//Importa a calsse List do Java para retornar uma lista de usuarios
import java.util.List;

@Dao
public interface UserDao {
    //Metodo para inserir um usuario na tela do BD
    //A anotação @Insert infroma a Room que este metodo deve ser usado para inserir dado

    @Insert
    void inserir(User user);

    //Metodo para buscar todos usuarios cadastrados no BD
    //A anotação @Query permite definir uma consulta SQL personalizada
    @Query("SELECT * FROM user")
    List<User> getALLUsers();
}
