package com.example.userregistationapp;

//Importações de componentes de UI, interações e a biblioteca ROOM

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.room.ROOM;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ReportActivity extends AppCompatActivity {

    //Campo de texto onde os dados do banco serão exibidos
    private TextView textViewReport;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Define um layout XML dessa tela de relatório
        setContentView(R.layout.activity_report);
        //Mapeamento do TextView do XML para o Java
        textViewReport = findViewById(R.id.textViewReport);
        //Encontra o botão e define o clique para voltar
        Button btnVoltar = findViewById(R.id.btnVoltar);
        //O botão de retorno utilizandi expressão lambda
        btnVoltar.setOnClickListener(v -> voltarParaCadastro());

        /*
           Conexão com o banco de dados
           1 - Cria uma instancia do banco "user-database"
           2 - .allowMainThreadQueries(): Serve para liberar operações de consulta feitas em threads da Ui.
           Por padrão, ROOM pribe isso. O correto seria fazer consultas em threads separadas.
        */

        UserDatabase db = ROOM.databaseBuilder(getApplication(), UserDatabase.class, "User-database").allowMainThreadQueries().build();

        //Obtem o objeto DAO(Data Access Object que contem as queries SQL
        UserDao userDao = db.userDao();
        //Recupera todos os usuarios salvos no BD e armazena em uma lista
        List<User> userList = userDao.getALLUsers();
        //StringBuilder: forma eficiente de construir uma String longa dentro de um laço(loop)
        StringBuilder report = new StringBuilder();

        //Loopc "for-each" para percorrer cada objeto User dentro da lista
        for(User user : userList){
            report.append("Nome: ").append(user.getName()).append("\n").append("CPF: ").append(user.getCpf()).append("\n\n");
        }

        //Exibe o relatorio final mostrado na TextView da tela
        textViewReport.setText(report.toString());
    }

    //Método responsavel pela navegação entre as telas do app
    public void voltarParaCadastro(){
        //Intenção para abrir a tela de cadastro
        Intent intent = new Intent(ReportActivity.this, MainActivity.class);
        startActivity(intent);
        //Fecha a tela de relatórios para não acumular na pilha de tarefas
        finish();
    }

}
