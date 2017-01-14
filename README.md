# CEPiK
Żeby uruchomić projekt, należy pamiętać o dodaniu Tomcata do projektu:  
`Edit Configurations...` -> klikamy w `+` -> z listy `Add new configuration` wybieramy `Tomcat Server` i `Local` ->
jeżeli nie masz wybranej wersji Tomcata, trzeba ją wskazać klikając w `Configure...` dalej klikamy w `Fix` na dole, przy komunikacie  
"**Warning:** No artifacts marked for deployment" i wybieramy `war exploded`.  
Po zaakceptowaniu powinno wszystko śmigać :)  
  
    
W przypadku pojawienia się problemów z połączeniem do bazy danych (coś tam z max_user_connections)
wystarczy zmienić użytkownika z damtch_user na damtch_user2 w pliku CEPiK\src\main\resources\cepik.properties  
`db.user=damtch_user` -> `db.user=damtch_user2`  
I odwrotnie, jeżeli będziemy na damtch_user2.  
(może kiedyś znajdę permanentne rozwiązanie tego problemu :) )
