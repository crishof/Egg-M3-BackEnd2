/*1. Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.*/
SELECT 
    *
FROM
    oficina;
SELECT 
    o.codigo_oficina, o.ciudad
FROM
    oficina o
WHERE
    NOT ciudad IS NULL;

/*2. Devuelve un listado con la ciudad y el teléfono de las oficinas de España.*/
select o.ciudad, o.telefono from oficina o where pais = 'España';

/*3. Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un
código de jefe igual a 7.*/
select * from empleado;
select nombre, apellido1, apellido2, email from empleado e where codigo_jefe = 7;

/*4. Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa.*/
select puesto, nombre apellido1, apellido2, email from empleado where puesto = 'Director General';

/*5. Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean
representantes de ventas.*/
select nombre, apellido1, apellido2, puesto from empleado where puesto <> 'Representante ventas';

/*6. Devuelve un listado con el nombre de los todos los clientes españoles.*/
select * from cliente;
select * from cliente where pais = 'Spain';

/*7. Devuelve un listado con los distintos estados por los que puede pasar un pedido.*/
select distinct estado from pedido;

/*8. Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago
en 2008. Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan
repetidos. Resuelva la consulta:
o Utilizando la función YEAR de MySQL.
o Utilizando la función DATE_FORMAT de MySQL.
o Sin utilizar ninguna de las funciones anteriores.*/
select * from pago p
where year(fecha_pago) = 2008;

select * from pago p
where date_format(fecha_pago, "%Y") = 2008;

select * from pago p
where fecha_pago like '%08-%';

/*9. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de
entrega de los pedidos que no han sido entregados a tiempo.*/
select * from pedido;
select codigo_pedido, codigo_cliente,fecha_esperada, fecha_entrega
from pedido p where datediff(fecha_entrega,fecha_esperada) <= 0;

/*10. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de
entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha
esperada.
o Utilizando la función ADDDATE de MySQL.
o Utilizando la función DATEDIFF de MySQL.*/

select p.codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
from pedido p
where fecha_entrega <= adddate(fecha_esperada,interval -2 day);

/* Opcion 2 - Agrega solo los días */

select p.codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
from pedido p
where fecha_entrega <= adddate(fecha_esperada, -2);

select p.codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
from pedido p
where datediff(fecha_esperada, fecha_entrega) >= 2;

/*11. Devuelve un listado de todos los pedidos que fueron rechazados en 2009.*/
select * from pedido p
where p.estado = 'rechazado' and year(fecha_pedido) = 2009;

/*12. Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de
cualquier año.*/
select * from pedido p
where p.estado = 'entregado' and month(p.fecha_entrega) = 01;

/*13. Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal.
Ordene el resultado de mayor a menor.*/
select * from pago p
where year(fecha_pago) = 2008 and forma_pago = 'Paypal'
order by total;

/*14. Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. Tenga en
cuenta que no deben aparecer formas de pago repetidas.*/
select distinct forma_pago from pago p;

/*15. Devuelve un listado con todos los productos que pertenecen a la gama Ornamentales y que
tienen más de 100 unidades en stock. El listado deberá estar ordenado por su precio de
venta, mostrando en primer lugar los de mayor precio.*/
select * from producto where gama = 'ornamentales' and cantidad_en_stock >100;

/*16. Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo
representante de ventas tenga el código de empleado 11 o 30.*/
select * from cliente where ciudad = 'Madrid' and codigo_empleado_rep_ventas in (11,30);
/*Consultas multitabla (Composición interna)
Las consultas se deben resolver con INNER JOIN.*/

/*1. Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante
de ventas.*/
SELECT 
    c.nombre_cliente, e.nombre, e.apellido1
FROM
    cliente c
        INNER JOIN
    empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado;

select nombre_cliente as Nombre, concat(empleado.apellido1,' ', empleado.apellido2)as Vendedor 
from  cliente
inner join empleado
on cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado;

/*2. Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus
representantes de ventas.*/

SELECT distinct c.nombre_cliente as Nombre_Cliente, concat(e.nombre,' ', e.apellido2)as Vendedor
FROM cliente AS c
JOIN empleado AS e 
ON c.codigo_empleado_rep_ventas = e.codigo_empleado 
RIGHT JOIN pago AS p
ON c.codigo_cliente = p.codigo_cliente;

/*3. Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de
sus representantes de ventas.*/
select c.codigo_cliente, c.nombre_cliente, c.codigo_empleado_rep_ventas,p.codigo_cliente 
from cliente c 
left join pago p 
on c.codigo_cliente = p.codigo_cliente
where p.codigo_cliente is null;


/*4. Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes
junto con la ciudad de la oficina a la que pertenece el representante.*/
SELECT distinct c.nombre_cliente as Nombre_Cliente, concat(e.nombre,' ', e.apellido2)as Vendedor,
o.ciudad
FROM cliente AS c
JOIN empleado AS e 
ON c.codigo_empleado_rep_ventas = e.codigo_empleado 
join oficina as o
on e.codigo_oficina = o.codigo_oficina
RIGHT JOIN pago AS p
ON c.codigo_cliente = p.codigo_cliente;

/*5. Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus
representantes junto con la ciudad de la oficina a la que pertenece el representante.*/
SELECT distinct c.nombre_cliente as Nombre_Cliente, concat(e.nombre,' ', e.apellido2)as Vendedor,
o.ciudad
FROM cliente AS c
JOIN empleado AS e 
ON c.codigo_empleado_rep_ventas = e.codigo_empleado 
join oficina as o
on e.codigo_oficina = o.codigo_oficina
left JOIN pago AS p
ON c.codigo_cliente = p.codigo_cliente
where p.codigo_cliente is null;

/*6. Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.*/
select o.linea_direccion1 from oficina as o
left join cliente as c
on o.region = c.region
where c.linea_direccion2 = 'Fuenlabrada';

/*7. Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad
de la oficina a la que pertenece el representante.*/
select c.nombre_cliente, e.nombre, o.ciudad from cliente as c
join empleado as e
on c.codigo_empleado_rep_ventas = e.codigo_empleado
join oficina as o
on e.codigo_oficina = o.codigo_oficina;

/*8. Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.*/
select nombre as empleado, j.nombre as jefe
from empleado e
left join empleado j
on e.codigo_jefe = j.codigo_empleado;


/*9. Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.*/
select c.nombre_cliente
from cliente c
left join pedido p
on c.codigo_cliente = p.codigo_cliente
where p.fecha_entrega > p.fecha_esperada
group by nombre_cliente;

/*10. Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
Consultas multitabla (Composición externa)*/

select distinct p.gama, c.nombre_cliente from producto p
join detalle_pedido d on p.codigo_producto = d.codigo_producto 
left join pedido on d.codigo_pedido = pedido.codigo_pedido
join cliente c on pedido.codigo_cliente = c.codigo_cliente;

/*Resuelva todas las consultas utilizando las cláusulas LEFT JOIN, RIGHT JOIN, JOIN.*/

/*1. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.*/
select c.nombre_cliente, p.forma_pago from cliente c
left join pago p on c.codigo_cliente = p.codigo_cliente
where forma_pago is null;

/*2. Devuelve un listado que muestre solamente los clientes que no han realizado ningún
pedido.*/
select c.nombre_cliente, p.estado from cliente c
left join pedido p on c.codigo_cliente = p.codigo_cliente
where estado is null;

/*3. Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que
no han realizado ningún pedido.*/
select c.nombre_cliente, ped.estado, pago.forma_pago from cliente c
left join pedido ped on c.codigo_cliente = ped.codigo_cliente
left join pago on ped.codigo_cliente = pago.codigo_cliente;

/*4. Devuelve un listado que muestre solamente los empleados que no tienen una oficina
asociada.*/
select e.nombre, o.codigo_oficina from empleado e
left join oficina o on e.codigo_oficina = o.codigo_oficina
where e.codigo_oficina is null;
/*--------------------------------- REVISAR - NO HAY DATOS__________*/
select * from oficina;
select * from empleado;

/*5. Devuelve un listado que muestre solamente los empleados que no tienen un cliente
asociado.*/
select e.nombre, c.nombre_cliente from empleado e
left join cliente c on c.codigo_empleado_rep_ventas = e.codigo_empleado
where c.nombre_cliente is null;

/*6. Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los
que no tienen un cliente asociado.*/
select e.nombre, o.codigo_oficina, c.nombre_cliente from empleado e
join oficina o on e.codigo_oficina = o.codigo_oficina
left join cliente c on c.codigo_empleado_rep_ventas = e.codigo_empleado;
/*--------------------------------- REVISAR - NO HAY DATOS__________
where c.nombre_cliente is null;
where e.codigo_oficina is null;
*/
/*7. Devuelve un listado de los productos que nunca han aparecido en un pedido.*/
select p.nombre, d.codigo_producto from producto p
left join detalle_pedido d on p.codigo_producto = d.codigo_producto
where d.codigo_producto is null;

/*8. Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los
representantes de ventas de algún cliente que haya realizado la compra de algún producto
de la gama Frutales.*/
select  distinct o.codigo_oficina, producto.gama from oficina o
join empleado e on o.codigo_oficina = e.codigo_oficina
join cliente c on e.codigo_empleado = c.codigo_empleado_rep_ventas
join pedido p on c.codigo_cliente = p.codigo_cliente
join detalle_pedido det on p.codigo_pedido = det.codigo_pedido
join producto on det.codigo_producto = producto.codigo_producto
where producto.gama = 'Frutales'
order by codigo_oficina;

/*9. Devuelve un listado con los clientes que han realizado algún pedido, pero no han realizado
ningún pago.*/

/*10. Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el
nombre de su jefe asociado.

Consultas resumen*/

/*1. ¿Cuántos empleados hay en la compañía?*/

/*2. ¿Cuántos clientes tiene cada país?*/

/*3. ¿Cuál fue el pago medio en 2009?*/

/*4. ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el
número de pedidos.*/

/*5. Calcula el precio de venta del producto más caro y más barato en una misma consulta.*/

/*6. Calcula el número de clientes que tiene la empresa.*/

/*7. ¿Cuántos clientes tiene la ciudad de Madrid?*/

/*8. ¿Calcula cuántos clientes tiene cada una de las ciudades que empiezan por M?*/

/*9. Devuelve el nombre de los representantes de ventas y el número de clientes al que atiende
cada uno.*/

/*10. Calcula el número de clientes que no tiene asignado representante de ventas.*/

/*11. Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado
deberá mostrar el nombre y los apellidos de cada cliente.*/

/*12. Calcula el número de productos diferentes que hay en cada uno de los pedidos.*/

/*13. Calcula la suma de la cantidad total de todos los productos que aparecen en cada uno de
los pedidos.*/

/*14. Devuelve un listado de los 20 productos más vendidos y el número total de unidades que
se han vendido de cada uno. El listado deberá estar ordenado por el número total de
unidades vendidas.*/

/*15. La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el
IVA y el total facturado. La base imponible se calcula sumando el coste del producto por el
número de unidades vendidas de la tabla detalle_pedido. El IVA es el 21 % de la base
imponible, y el total la suma de los dos campos anteriores.*/

/*16. La misma información que en la pregunta anterior, pero agrupada por código de producto.*/

/*17. La misma información que en la pregunta anterior, pero agrupada por código de producto
filtrada por los códigos que empiecen por OR.*/

/*18. Lista las ventas totales de los productos que hayan facturado más de 3000 euros. Se
mostrará el nombre, unidades vendidas, total facturado y total facturado con impuestos (21%
IVA)*/

Subconsultas con operadores básicos de comparación

/*1. Devuelve el nombre del cliente con mayor límite de crédito.*/

/*2. Devuelve el nombre del producto que tenga el precio de venta más caro.*/

/*3. Devuelve el nombre del producto del que se han vendido más unidades. (Tenga en cuenta
que tendrá que calcular cuál es el número total de unidades que se han vendido de cada
producto a partir de los datos de la tabla detalle_pedido. Una vez que sepa cuál es el código
del producto, puede obtener su nombre fácilmente.)*/

/*4. Los clientes cuyo límite de crédito sea mayor que los pagos que haya realizado. (Sin utilizar
INNER JOIN).*/

/*5. Devuelve el producto que más unidades tiene en stock.*/

/*6. Devuelve el producto que menos unidades tiene en stock.*/

/*7. Devuelve el nombre, los apellidos y el email de los empleados que están a cargo de Alberto
Soria.*/

/*Subconsultas con ALL y ANY*/

/*1. Devuelve el nombre del cliente con mayor límite de crédito.*/

/*2. Devuelve el nombre del producto que tenga el precio de venta más caro.*/

/*3. Devuelve el producto que menos unidades tiene en stock.
Subconsultas con IN y NOT IN*/

/*1. Devuelve el nombre, apellido1 y cargo de los empleados que no representen a ningún
cliente.*/

/*2. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.*/

/*3. Devuelve un listado que muestre solamente los clientes que sí han realizado ningún pago.*/

/*4. Devuelve un listado de los productos que nunca han aparecido en un pedido.*/

/*5. Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que
no sean representante de ventas de ningún cliente.*/

/*Subconsultas con EXISTS y NOT EXISTS*/

/*1. Devuelve un listado que muestre solamente los clientes que no han realizado ningún
pago.*/

/*2. Devuelve un listado que muestre solamente los clientes que sí han realizado ningún pago.*/

/*3. Devuelve un listado de los productos que nunca han aparecido en un pedido.*/

/*4. Devuelve un listado de los productos que han aparecido en un pedido alguna vez.*/