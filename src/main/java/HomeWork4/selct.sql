--ошибки в расписании (фильмы накладываются друг на друга), отсортированные
--по возрастанию времени.
--Выводить надо колонки «фильм 1», «время начала», «длительность»,
--«фильм 2», «время начала», «длительность»;

SELECT mv.title, s.time_s, mv.length_m FROM ticket t
	JOIN movies mv USING(movies_id)
	JOIN show_time s USING(time_id)
	GROUP BY mv.title, s.time_s, mv.length_m
	ORDER BY mv.length_m


--список фильмов, для каждого — с указанием общего числа посетителей за все время,
--среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму
--(отсортировать по убыванию прибыли).
--Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;

SELECT mv.title, COUNT(*), SUM(pr.price), AVG(s.time_id) FROM ticket t
	JOIN movies mv USING(movies_id)
	JOIN show_time s USING(time_id)
	JOIN price pr USING(price_id)
	WHERE  pr.price <> 0
	GROUP BY mv.title
	ORDER BY SUM(pr.price) DESC
UNION
SELECT 'Total',  COUNT(*) as cnt, SUM(pr.price) as sum FROM ticket t
	JOIN show_time s USING(time_id)
	JOIN price pr USING(price_id)
	ORDER BY SUM(pr.price);


--число посетителей и кассовые сборы, сгруппированные по времени начала фильма:
--с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00
--(сколько посетителей пришло с 9 до 15 часов и т.д.).

SELECT s.time_s, count(t.id), SUM(pr.price) FROM ticket t
	JOIN movies mv USING(movies_id)
	JOIN show_time s USING(time_id)
	JOIN price pr USING(price_id)
	WHERE  s.time_s BETWEEN '9:00' AND '15:00'
	GROUP BY s.time_s;

SELECT s.time_s, count(t.id), SUM(pr.price) FROM ticket t
	JOIN movies mv USING(movies_id)
	JOIN show_time s USING(time_id)
	JOIN price pr USING(price_id)
	WHERE  s.time_s BETWEEN '15:00' AND '18:00'
	GROUP BY s.time_s;

SELECT s.time_s, count(t.id), SUM(pr.price) FROM ticket t
	JOIN movies mv USING(movies_id)
	JOIN show_time s USING(time_id)
	JOIN price pr USING(price_id)
	WHERE  s.time_s BETWEEN '18:00' AND '21:00'
	GROUP BY s.time_s;

SELECT s.time_s, count(t.id), SUM(pr.price) FROM ticket t
	JOIN movies mv USING(movies_id)
	JOIN show_time s USING(time_id)
	JOIN price pr USING(price_id)
	WHERE  s.time_s BETWEEN '21:00' AND '00:00'
	GROUP BY s.time_s;



