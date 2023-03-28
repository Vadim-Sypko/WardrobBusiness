package com.example.wardrobbusiness;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float coat = 70; // пальто
    byte coatDiscount = 77; // скидка в %
    float hat = 25; // шляпа
    byte hatDiscount = 37;
    float suit = 53; // костюм
    byte suitDiscount = 44;
    float shirt = 19; // сорочкка
    float shoes = 41; //туфли
    byte shoesDiscount = 32;
    float account = 312; //счет пользователя
    //создадим поля для вывода полученных значений на экран
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut;    // поле возможного остатка от покупки

    // метод подсчета стоимости делового гардероба
    private float calculation(){
        //создание и инициализация переменной подсчета стоимости
        float count = (coat * (100-coatDiscount)+hat*(100-hatDiscount)+suit*(100-suitDiscount)+shirt+shoes*(100-shoesDiscount))/100;
        return count; //возврат подсчитанного значения
    }
    //метод определния возможностей бюджета покупки делового гардероба
    private boolean possibility(){
        if (calculation() <= account){ //если стоимость гардероба меньше имеющихся средств
            return true; // возврат истина
        } else {         // иначе
            return false; // возврат ложь
        }
    }
    // определение возможной сдачи
    private float balance(){
        if (possibility()){          // если возможность приобретения имеется
            return account-calculation(); // то возвращается остаток от покупки
        } else {                         // иначе
            return -1;                // маркер недостатка денежных средств
        }
    }

// вывод на экран полученных значений
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        possibilityOut = findViewById(R.id.possibilityOut);  // вывод инфо о возможности покупки
        balanceOut = findViewById(R.id.balanceOut);  // вывод инфо о возможном остатке

        if (possibility()){
            possibilityOut.setText("Имеется достаточно средств для покупки делового гардероба");
            balanceOut.setText("Остаток от покупки " + balance() + " серебрянных монет");
        } else {
            possibilityOut.setText("Недостаточно средств для покупки делового гардероба");
            balanceOut.setText("  -  ");
        }

    }
}