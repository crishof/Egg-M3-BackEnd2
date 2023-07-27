/*1. Mostrar el nombre de todos los jugadores ordenados alfabéticamente.*/
select nombre from jugadores order by nombre asc
;
/*2. Mostrar el nombre de los jugadores que sean pivots (‘C’) y que pesen más de 200 libras,
ordenados por nombre alfabéticamente.*/
select nombre,peso,posicion from jugadores where posicion = 'c' and peso > 200 order by nombre asc;

/*3. Mostrar el nombre de todos los equipos ordenados alfabéticamente.*/
select nombre from equipos order by nombre asc;

/*4. Mostrar el nombre de los equipos del este (East).*/
select nombre,conferencia from equipos where conferencia = 'east';

/*5. Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.*/
select nombre,ciudad from equipos where ciudad like 'c%' order by nombre asc;

/*6. Mostrar todos los jugadores y su equipo ordenados por nombre del equipo.*/
select nombre,nombre_equipo from jugadores order by nombre_equipo;

/*7. Mostrar todos los jugadores del equipo “Raptors” ordenados por nombre.*/
select nombre,nombre_equipo from jugadores where nombre_equipo = 'Raptors';

/*8. Mostrar los puntos por partido del jugador ‘Pau Gasol’.*/
select puntos_por_partido from estadisticas 
where jugador = (select codigo from jugadores where nombre = 'Pau Gasol');

/*9. Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.*/
select puntos_por_partido from estadisticas 
where temporada = '04/05' and jugador = (select codigo from jugadores where nombre = 'Pau Gasol');

/*10. Mostrar el número de puntos de cada jugador en toda su carrera.*/
select jugador, round(sum(puntos_por_partido)) from estadisticas group by jugador;

/*11. Mostrar el número de jugadores de cada equipo.*/
select nombre_equipo, count(codigo) as jugadores_cant from jugadores group by nombre_equipo order by nombre_equipo asc;

/*12. Mostrar el jugador que más puntos ha realizado en toda su carrera.*/
select jugador,sum(puntos_por_partido) from estadisticas group by jugador order by sum(Puntos_por_partido) desc limit 1;

/*13. Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.*/
select nombre, conferencia, division 
from nba.equipos 
where nombre = (select nombre_equipo from nba.jugadores order by altura desc limit 1);

/*14. Mostrar el partido o partidos (equipo_local, equipo_visitante y diferencia) con mayor
diferencia de puntos.*/

select equipo_local, equipo_visitante, (puntos_local - puntos_visitante) as diferencia 
from nba.partidos order by diferencia desc limit 10;
select * from nba.partidos;

/*15. Mostrar quien gana en cada partido (codigo, equipo_local, equipo_visitante,
equipo_ganador), en caso de empate sera null.*/

select codigo,(puntos_local-puntos_visitante)as diferencia, equipo_local,equipo_visitante, 
 CASE
    WHEN (puntos_local - puntos_visitante) < 0 THEN equipo_visitante
    WHEN (puntos_local - puntos_visitante) > 0 THEN equipo_local
    ELSE 'EMPATE'
  END as equipo_ganador
  from nba.partidos;

select * from nba.partidos;
