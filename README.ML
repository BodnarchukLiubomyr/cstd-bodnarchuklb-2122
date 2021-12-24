Student: Bodnarchuk Liubomyr
Group: CE-48
Subject: CSDT

Project name: tic-tac-toe game
Programming language: Java

Additional tools/utils: Bash, Make
HW interface: UART
Data driven format: xml

Play modes: Man vs AI, Man vs Man, AI vs AI

AI supports next complexity levels: Random move, Win strategy

Actions: New, Save, Load

The proposal for data driven approach: configuration (saved in configuration file or DB): board size, distance, tool size, win statement, lose statement, AI parameters

DB
В даному проектi використовується база даних MySQL.

MySQL — вільна система керування реляційними базами даних, яка була розроблена компанією «ТсХ» для підвищення швидкодії обробки великих баз даних. 
Ця система керування базами даних (СКБД) з відкритим кодом була створена як альтернатива комерційним системам. 

Переваги MySQL:
  простота у встановленні та використанні;
  підтримується необмежена кількість користувачів, що одночасно працюють із БД;
  кількість рядків у таблицях може досягати 50 млн.;
  висока швидкість виконання команд;
  наявність простої і ефективної системи безпеки.
Для підключення до MySQL я використовував ресурси інтегрованого середовища розробки IntelliJ IDEA. Також потрібно ввести значення порта,хоста, ім'я та пароль бази даних,створеної в MySQL.

Було створено 9 моделей:
  1.account
  2.account_details
  3.payment
  4.role
  5.service
  6.tariff
  7.tariff_status
  8.wallet
  9.place
