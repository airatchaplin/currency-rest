# Currency-Rest

# Салихов Айрат Глусович

Cервис, который обращается к сервису курсов валют, и отдает gif в ответ.

1. Запускаем приложение
2. Переходим в браузере на страницу http://localhost:8080/ (либо через Postman)
3. Ответ приходит в json формате 
   
   Пример вывода :
   
      {
      
        "id":"TtU4bfUEF4BRpKZqrf",
        
        "username":"BPONG",
        
        "title":"Beer Pong Money GIF by BPONGofficial",
        
        "url":"https://media3.giphy.com/media/TtU4bfUEF4BRpKZqrf/giphy.gif?cid=bd680e4de9d480cbb38b44ddf40d69158bf927507a35648a&rid=giphy.gif",
        
        "tag":"rich"  
        
      } 
      
 Если хотите сравнить с другой датой и валютой, переходим в файл currency.properties и меняем значения: date в формате (гггг-мм-дд) и symbols в формате (RUB)
 
 
 Запуск Doker:
 
 1. Собираем проект 
 2. В терминале прописываем:
 
      $docker build -t currency-rest .
      
      $docker run -p 8080:8080 —name currency currency-rest
 
 3. Переходим в браузере на страницу http://localhost:8080
