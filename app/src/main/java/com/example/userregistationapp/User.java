package com.example.userregistationapp;

//Importa anotação do Room necessarios para mapear esta classe como uma entidade do banco dados
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    //Define o campo 'id' como chave primaria de tabela e configura para ser gerado automaticamente
    @PrimaryKey(autoGenerate = true)
    private int id;

    //Campos que representam as colunas da tabela para armazenar os dados do usuario
    private String name; //Nome do usuario
    private String cpf; //CPF do usuario
    private String email; //email do usuario
    private String phone; //Fone do usuario

    //Constrututor da classe que sera usado para criar novo objeto User
    public User(String name, String cpf, String email, String phone){
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }

    //Metodos getter e setter para acessar e modicar os dados do objeto User

    //Retorna o ID do usuario
    public int getId(){return id;}

    //Define o ID do usuario (usado pelo Room para preencher automaticamente)
    public void setId(int id){this.id = id;}

    //Retorna nome do usuario
    public String getName(){return name;}

    //Retorna CPF do usuario
    public String getCpf(){return cpf;}

    //Retorna email do usuario
    public String getEmail(){return email;}

    //Retorna phone do usuario
    public String getPhone(){return phone;}
}
