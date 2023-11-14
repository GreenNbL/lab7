package org.example.GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainDialog extends JFrame { //объявление класса GUISample
    Button b1 = new Button("Открыть "); //создание кнопки с надписью "Add"
    JCheckBox checkBox= new JCheckBox("Доктора");
    JCheckBox checkBox2= new JCheckBox("Пациенты");

    public MainDialog() {
        setLocationRelativeTo(null);//объявление конструктора класса
        setLayout(null); //отключение менеджера компоновки
        setSize(400, 250); //установка размеров фрейма
        setTitle("Больница"); //установка заголовка фрейма
        setBackground(Color.orange); //установка цвета заднего фона фрейма
        add(b1); //добавление кнопки к окну
        b1.setBounds(150, 150, 120, 24); //установка размеров кнопки
        b1.setForeground(Color.black); //установка цвета переднего фона кнопки
        b1.setBackground(Color.lightGray); //установка цвета заднего фона кнопки
        add(checkBox); //добавление кнопки к окну
        checkBox.setBounds(50, 50, 120, 24); //установка размеров
        add(checkBox2); //добавление кнопки к окну
        checkBox2.setBounds(50, 100, 120, 24); //установка размеров кнопки
        addWindowListener(new WindowClose());
        /*регистрация блока прослушивания событий типа ActionEvent*/
        b1.addActionListener(new ButtonAdd());
        checkBox.addActionListener(new BoxChoice());
        checkBox2.addActionListener(new BoxChoice2());

    }
    class BoxChoice implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(checkBox.isSelected())
                checkBox2.setSelected(false);
        }
    }
    class BoxChoice2 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(checkBox2.isSelected())
                checkBox.setSelected(false);
        }
    }

    class WindowClose extends WindowAdapter {
        /*метод, который вызывается при закрытии окна*/
        public void windowClosing(WindowEvent we) {
            setVisible(false); //фрейм-окно становится невидимым
        }
    }
    class ButtonAdd implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            if(checkBox.isSelected()) {
                DialogDoctor();
            }
            else {
                if (checkBox2.isSelected()) {
                     DialogPatient();
                }
            }
        }
    }
    public static void DialogPatient()
    {
       PatientTable patientTable =new PatientTable();
    }
    public static void DialogDoctor()
    {
        DoctorTable doctorTable =new DoctorTable();
    }

}